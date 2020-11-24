//Simon ist da
//das ist aber cool!
public class Konto
{
    // Instanzvariablen
    double kontostand;
    int kontonummer;
    int pin;
    
    public Konto(int pNeueKontoNummer, int pNeuePin)
    {
        //Anfangswerte zuweisen
        kontostand=0;
        kontonummer=pNeueKontoNummer;
        pin=pNeuePin;
    }
    
    public void einzahlen(int pWert)
    {
        kontostand=kontostand+pWert;
    }
    
    public void auszahlen(int pWert, int pPin)
    {
        if(pin==pPin){
            if(pWert<kontostand){
                kontostand=kontostand-pWert;
                //System.out.println("Dein aktueller Kontostand berträgt"kontostand);
            }
        }
    }
    
    public void ueberweisen(int pUeberweisungsWert, int pPin, Konto pZielKonto)
    {
        if(pin==pPin){
            if(pUeberweisungsWert<kontostand){
                auszahlen(pUeberweisungsWert, pPin);
                pZielKonto.einzahlen(pUeberweisungsWert);
            }
        }
    }
}
