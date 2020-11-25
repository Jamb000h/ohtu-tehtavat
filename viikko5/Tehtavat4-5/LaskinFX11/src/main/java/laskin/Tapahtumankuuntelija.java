package laskin;

import java.util.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Komentotehdas komennot;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.nollaa = nollaa;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new Komentotehdas(tuloskentta, syotekentta, plus, miinus, nollaa, sovellus);
    }
    
    @Override
    public void handle(Event event) {
        Komento komento = this.komennot.hae((Button)event.getTarget());
        komento.suorita();
        if ( sovellus.tulos()==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        
        
//        int arvo = 0;
// 
//        try {
//            arvo = Integer.parseInt(syotekentta.getText());
//        } catch (Exception e) {
//        }
// 
//        if (event.getTarget() == plus) {
//            sovellus.plus(arvo);
//        } else if (event.getTarget() == miinus) {
//            sovellus.miinus(arvo);
//        } else if (event.getTarget() == nollaa) {
//            sovellus.nollaa();
//        } else {
//            System.out.println("undo pressed");
//        }
//        
//        int laskunTulos = sovellus.tulos();
//        
//        syotekentta.setText("");
//        tuloskentta.setText("" + sovellus.tulos());
//        
//        if ( sovellus.tulos()==0) {
//            nollaa.disableProperty().set(true);
//        } else {
//            nollaa.disableProperty().set(false);
//        }
//        undo.disableProperty().set(false);
    }

}
