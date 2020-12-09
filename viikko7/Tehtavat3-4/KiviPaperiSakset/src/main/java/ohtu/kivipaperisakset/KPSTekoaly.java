package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS {

    private final Tekoaly tekoaly;
    
    public KPSTekoaly() {
        super();
        tekoaly = new Tekoaly();
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
