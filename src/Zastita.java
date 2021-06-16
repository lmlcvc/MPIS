import java.util.ArrayList;
import java.util.Map;

public abstract class Zastita implements Napajanje {

    String identifikator;
    IspravnostZastite ispravnost;
    boolean napajanje = true;
    boolean ukljucena = false;

    public Zastita() {
        this.ukljucena = true;
    }

    public abstract void sekOpremaUp();

    public void ukljuci() {
        if (this.napajanje) {
            // this.stanje = EnumProradaPrestanak.PRORADA;
        }
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
