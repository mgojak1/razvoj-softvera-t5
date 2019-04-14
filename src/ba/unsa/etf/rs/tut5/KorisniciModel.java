package ba.unsa.etf.rs.tut5;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici;
    private SimpleObjectProperty<Korisnik> trenutniKorisnik;

    public KorisniciModel() {
        this.korisnici=FXCollections.observableArrayList();
        this.trenutniKorisnik=new SimpleObjectProperty<>();
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
    public void napuni(){
        korisnici.add(new Korisnik("Šemsudin","Dino Poplava","semso@etf.usa.ba","poplava","nemampojma"));
        korisnici.add(new Korisnik("Edin","Dino Poplava","edin@etf.usa.ba","poplava","nemampojma"));
        korisnici.add(new Korisnik("Semin","Dino Poplava","semin@etf.usa.ba","poplava","nemampojma"));
    }
}