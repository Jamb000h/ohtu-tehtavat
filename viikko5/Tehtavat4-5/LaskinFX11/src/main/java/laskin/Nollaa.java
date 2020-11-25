/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.TextField;

/**
 *
 * @author Jonne
 */
public class Nollaa extends Komento{
    
    private int aiempiTulos;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    public void suorita() {
        this.aiempiTulos = sovellus.tulos();
        this.sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("");
    }

    @Override
    public void peru() {
        this.sovellus.plus(aiempiTulos);
        syotekentta.setText("");
        tuloskentta.setText(this.sovellus.tulos() + "");
    }
    
}
