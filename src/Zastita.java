import java.util.ArrayList;
import java.util.Map;

public abstract class Zastita implements Napajanje {

    String identifikator;
    String modul;

    boolean napajanje = true;
    boolean ukljucena = true;

    public Zastita(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
    }

    public abstract void sekOpremaUp();

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
