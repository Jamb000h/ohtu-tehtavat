package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPS {

    private Tuomari tuomari;
    protected String ekanSiirto;
    protected String tokanSiirto;
    protected Scanner scanner;
    
    public KPS() {
        tuomari = new Tuomari();
        scanner = new Scanner(System.in);
    }
    
    public static KPS luoKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }
    
    public static KPS luoKPSTekoaly() {
        return new KPSTekoaly();
    }
        
    public static KPS luoKPSParempiTekoaly() {
        return new KPSParempiTekoaly();
    }

    public void pelaa() {
        tuomari = new Tuomari();
        ekanSiirto = ensimmaisenSiirto();
        tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    abstract protected String toisenSiirto();

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
