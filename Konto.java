public class Konto
{
    // Instanzvariablen
    double kontostand;
    int kontonummer;
    int pin;
    int risiko;
    int officallimit;
    int maxlimit;
    double posZinsen;
    double negZinsen;
    double dispoUeberziehungszins;
    public Konto(int pNeueKontoNummer, int pNeuePin, int pRisikostufe)
    {
        //Anfangswerte zuweisen
        kontostand=0;
        kontonummer=pNeueKontoNummer;
        pin=pNeuePin;
        risiko=pRisikostufe;
        if(risiko == 0) //beste Stufe - hohes Limit & gute Zinsen 
        {
            officallimit = -200;
            maxlimit = -500;
            posZinsen = 4;
            negZinsen = 1; // auch positive Zahlen verwenden
            dispoUeberziehungszins = 5; //auch positive Zahlen verwenden
        }
        if(risiko == 1) //mittlere Stufe - mittleres Limit & mittlere Zinsen
        {
            officallimit = -50;
            maxlimit = -100;
            posZinsen = 2;
            negZinsen = 2;
            dispoUeberziehungszins = 10;
        }
        if(risiko == 2) //nidrige Stufe - niedriges Limit & schlechte Zinsen
        {
            officallimit = 0;
            maxlimit = -50;
            posZinsen = 1;
            negZinsen = 4;
            dispoUeberziehungszins = 15;
        }
    }
    
    public void einzahlen(int pWert)
    {
        kontostand=kontostand+pWert;
    }
    
    public void auszahlen(int pWert, int pPin)
    {
        if(pin==pPin){
            if(kontostand-pWert>maxlimit){
                kontostand=kontostand-pWert;
                //System.out.println("Dein aktueller Kontostand berträgt"kontostand);
            }
        }
    }
    
    public void ueberweisen(int pUeberweisungsWert, int pPin, Konto pZielKonto)
    {
        if(pin==pPin){
            if(kontostand-pUeberweisungsWert>maxlimit){
                auszahlen(pUeberweisungsWert, pPin);
                pZielKonto.einzahlen(pUeberweisungsWert);
            }
        }
    }
    
    public void einziehen(int pEinzugsWert, Konto pZielKonto)
    {
        if(pZielKonto.kontostand-pEinzugsWert > maxlimit){
            einzahlen(pEinzugsWert);
            pZielKonto.kontostand=pZielKonto.kontostand-pEinzugsWert;
        }
    }
    
    public void GuthabenzinsenManuell(double pZinsWert)
    {
        if(pZinsWert > -100){ //unter -100 macht keinen Sinn mehr
               pZinsWert = pZinsWert/100;
               kontostand = kontostand*pZinsWert+kontostand;
        }
    }
    
    public void zinsen()
    {
        if(kontostand >= 0)
        {
            double pPosZinsen = posZinsen/100;
            kontostand = kontostand*pPosZinsen+kontostand;
            System.out.println("hier sollte was passieren");
        }
        else
        {
            if(kontostand >= officallimit)
            {
                double pNegZinsen = negZinsen/100;
                kontostand = kontostand*pNegZinsen+kontostand;
                System.out.println("ich officallimit");
            }
            else
            {
                double pDispoUeberziehungszins = dispoUeberziehungszins/100;
                kontostand = kontostand*pDispoUeberziehungszins+kontostand;
                System.out.println("non offical");
            }
        }
    }
}
