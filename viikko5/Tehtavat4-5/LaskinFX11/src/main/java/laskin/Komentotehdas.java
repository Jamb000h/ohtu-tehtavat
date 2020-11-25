/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Jonne
 */
public class Komentotehdas {
    private Map<Button, Komento> komennot;
    private Komento tuntematon;

    public Komentotehdas(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Sovelluslogiikka sovellus) {
        komennot = new HashMap<>();
        komennot.put(plus, new Plus(tuloskentta, syotekentta, sovellus));
        komennot.put(miinus, new Miinus(tuloskentta, syotekentta, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, sovellus));
        tuntematon = new Tuntematon(tuloskentta, syotekentta, sovellus);
    }

    public Komento hae(Button operaatio) {
        return komennot.getOrDefault(operaatio, tuntematon);
    }
}

