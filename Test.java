

public class Test
{
    Konto konto1;
    Konto konto2;
    Konto konto3;
    Konto konto4;

    public Test()
    {
        konto1 = new Konto(1, 1, 0);
        konto2 = new Konto(2, 2, 1);
        konto3 = new Konto(3, 3, 2);
        konto4 = new Konto(4, 4, 0);
    }

    public void testEinzahlen()
    {
        konto1.einzahlen(1000);
        konto2.einzahlen(2000);
        konto3.einzahlen(3000);
        konto4.einzahlen(4000);
    }
    
    public void testAuszahlen(){
        konto1.auszahlen(500,1); //richtig
        konto2.auszahlen(500, 100); //falscher Pin
        konto3.auszahlen(10000000, 3); // zu hoher Betrag
    }
    
    public void testUeberweisen(){
        konto1.ueberweisen(500, 1, konto2); //richtig
        konto1.ueberweisen(500, 10, konto2); //falscher Pin
        konto1.ueberweisen(1000000, 1, konto2); //zu hoher Betrag
    }
    
    public void testEinzug(){
        konto1.einziehen(100, konto2);
        konto1.einziehen(10000, konto2); //zu hoher Betrag
    }
}
