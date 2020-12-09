package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            KPS kps;
            if (vastaus.endsWith("a")) {
                kps = KPS.luoKPSPelaajaVsPelaaja();
            } else if (vastaus.endsWith("b")) {
                kps = KPS.luoKPSTekoaly();
            } else if (vastaus.endsWith("c")) {
                kps = KPS.luoKPSParempiTekoaly();
            } else {
                break;
            }
            
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            kps.pelaa();

        }

    }
}
