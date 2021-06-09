import java.util.ArrayList;

public abstract class Prekidac extends Polje implements Napajanje {

    String identifikator;
    StanjePrekidacRastavljac stanje;

    ArrayList<Enum> varijable = new ArrayList<Enum>();

    PrekidacKomanda komanda;
    boolean napajanje = true;

    public void ukljuci() {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }
    }

    public void iskljuci() {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }

    public void posaljiSignal() {
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
