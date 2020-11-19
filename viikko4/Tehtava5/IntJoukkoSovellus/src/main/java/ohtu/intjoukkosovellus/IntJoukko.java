
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            kasvata();
            return true;
        }
        return false;
    }
    
    private void kasvata() {
        if (alkioidenLkm % ljono.length == 0) {
            int[] taulukkoOld = new int[ljono.length];
            taulukkoOld = ljono;
            kopioiTaulukko(ljono, taulukkoOld);
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
        }
    }

    public boolean kuuluu(int luku) {
        return this.luvunIndeksi(luku) > -1;
    }
    
    private int luvunIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {
        int poistettavanLuvunIndeksi = luvunIndeksi(luku);
        
        if (poistettavanLuvunIndeksi > -1) {
            siirraVasemmalleAlkaenIndeksista(poistettavanLuvunIndeksi);
            alkioidenLkm--;
            return true;
        }

        return false;
    }
    
    private void siirraVasemmalleAlkaenIndeksista(int i) {
        if (i != -1) {
            for (int j = i; j < alkioidenLkm - 1; j++) {
                ljono[j] = ljono[j + 1];
            }
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String s = "{";
        for(int i = 0; i < alkioidenLkm; i++) {
            s += ljono[i];
            if(i < alkioidenLkm - 1) {
                s += ", ";
            }
        }
        s += "}";
        return s;
    }

    public int[] toIntArray() {
        int[] intArray = new int[alkioidenLkm];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = ljono[i];
        }
        return intArray;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
