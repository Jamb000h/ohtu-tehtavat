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
public class Miinus extends Komento{
    
    public Miinus(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    public void suorita() {
        Integer arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.sovellus.miinus(arvo);
        syotekentta.setText("");
        tuloskentta.setText(this.sovellus.tulos() + "");
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
