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
public class Tuntematon extends Komento{
    
    public Tuntematon(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    public void suorita() {
        
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
