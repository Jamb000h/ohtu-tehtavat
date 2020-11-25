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
    private Komento edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.nollaa = nollaa;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new Komentotehdas(tuloskentta, syotekentta, plus, miinus, nollaa, sovellus);
    }
    
    @Override
    public void handle(Event event) {
        if(event.getTarget() == undo && edellinen != null) {
            this.edellinen.peru();
            this.edellinen = null;
        } else {
            Komento komento = this.komennot.hae((Button)event.getTarget());
            komento.suorita();
            edellinen = komento;
        }
        
        if ( sovellus.tulos()==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        
        if ( this.edellinen == null) {
            undo.disableProperty().set(true);
        } else {
            undo.disableProperty().set(false);
        }
    }

}
