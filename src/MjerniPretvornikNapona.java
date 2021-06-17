public class MjerniPretvornikNapona extends MjerniUredaji {
    String identifikator;
    String modul;

    double napon;

    public MjerniPretvornikNapona(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
        this.napon = 0.0;
    }

    public String posaljiSignaleMPN() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - napon [kV] - " +
                "mjerena veličina" +
                System.lineSeparator();
    }

    public String posaljiTrenutniSignalMPN(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - radna snaga [MW] - " +
                this.napon +
                System.lineSeparator();
    }
}
