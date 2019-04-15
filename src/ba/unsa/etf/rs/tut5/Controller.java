package ba.unsa.etf.rs.tut5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Controller implements Initializable {
    public TextField imePolje;
    public TextField prezimePolje;
    public TextField mailPolje;
    public TextField usernamePolje;
    public PasswordField passPolje;
    public Button btndodaj;
    public ListView<Korisnik> listKorisnika;
    public Button btnkraj;
    private KorisniciModel model;
    public Controller(KorisniciModel model) {
        this.model = model;
    }

    public void kraj(ActionEvent actionEvent) {
        exit(0);
    }

    public void dodaj(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bind();
        listKorisnika.setItems((model.getKorisnici()));
        listKorisnika.selectionModelProperty().addListener(new ChangeListener<MultipleSelectionModel<Korisnik>>() {
            @Override
            public void changed(ObservableValue<? extends MultipleSelectionModel<Korisnik>> observable, MultipleSelectionModel<Korisnik> oldValue, MultipleSelectionModel<Korisnik> newValue) {
                if(newValue==null){
                    unbind();
                }
                else{
                    bind();
                    model.setTrenutniKorisnik(newValue.getSelectedItem());
                }
            }
        });

    }

    private void unbind() {
        imePolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimePolje.textProperty().unbindBidirectional((model.getTrenutniKorisnik()).prezimeProperty());
        mailPolje.textProperty().unbindBidirectional((model.getTrenutniKorisnik().emailProperty()));
        usernamePolje.textProperty().unbindBidirectional((model.getTrenutniKorisnik().usernameProperty()));
        passPolje.textProperty().unbindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }

    private void bind() {
        imePolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimePolje.textProperty().bindBidirectional((model.getTrenutniKorisnik()).prezimeProperty());
        mailPolje.textProperty().bindBidirectional((model.getTrenutniKorisnik().emailProperty()));
        usernamePolje.textProperty().bindBidirectional((model.getTrenutniKorisnik().usernameProperty()));
        passPolje.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }
}