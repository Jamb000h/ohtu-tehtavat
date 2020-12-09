package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPS {

    private final TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly() {
        super();
        tekoaly = new TekoalyParannettu(20);
    }
    
    @Override
    protected String toisenSiirto() {
        if(tokanSiirto != null) {
            tekoaly.asetaSiirto(ekanSiirto);
        }
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }
}
