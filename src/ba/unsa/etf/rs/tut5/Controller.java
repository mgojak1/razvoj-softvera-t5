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
    public TextField imeField;
    public TextField prezimeField;
    public TextField mailField;
    public TextField usernameField;
    public PasswordField passField;
    public Button btnAdd;
    public ListView<Korisnik> listView;
    public Button btnEnd;
    private KorisniciModel model;

    public Controller(KorisniciModel model) {
        this.model = model;
    }

    public void dodaj(ActionEvent actionEvent) {

    }

    public void kraj(ActionEvent actionEvent) {
        exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bind();
        listView.setItems((model.getKorisnici()));
        listView.selectionModelProperty().addListener(new ChangeListener<MultipleSelectionModel<Korisnik>>() {
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
        imeField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().unbindBidirectional((model.getTrenutniKorisnik()).prezimeProperty());
        mailField.textProperty().unbindBidirectional((model.getTrenutniKorisnik().emailProperty()));
        usernameField.textProperty().unbindBidirectional((model.getTrenutniKorisnik().usernameProperty()));
        passField.textProperty().unbindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }

    private void bind() {
        imeField.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeField.textProperty().bindBidirectional((model.getTrenutniKorisnik()).prezimeProperty());
        mailField.textProperty().bindBidirectional((model.getTrenutniKorisnik().emailProperty()));
        usernameField.textProperty().bindBidirectional((model.getTrenutniKorisnik().usernameProperty()));
        passField.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }
}