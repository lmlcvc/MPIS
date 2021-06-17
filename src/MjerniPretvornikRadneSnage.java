public class MjerniPretvornikRadneSnage extends MjerniUredaji {
    String identifikator;
    String modul;
    double radnaSnaga;

    public MjerniPretvornikRadneSnage(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
        this.radnaSnaga = 0.0;
    }

    public String posaljiSignaleMPRS() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - radna snaga [MW] - " +
                "mjerena veličina" +
                System.lineSeparator();
    }

    public String posaljiTrenutniSignalMPRS(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - radna snaga [MW] - " +
                this.radnaSnaga +
                System.lineSeparator();
    }
}
