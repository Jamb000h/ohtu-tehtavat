package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KPS {    
    
    public KPSPelaajaVsPelaaja() {
        super();
    }
    
    @Override
    protected String toisenSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();  
    }
}