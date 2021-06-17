public class Brojilo extends MjerniUredaji {
    String identifikator;
    String modul;

    double jalovaEnergija;
    EnumProradaPrestanak alarm = EnumProradaPrestanak.PRESTANAK;

    public Brojilo(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;

        this.jalovaEnergija = 0.0;
    }

    public String posaljiSignaleBrojila() {
        return posaljiSignalJaloveEnergije() +
                posaljiSignalAlarma();
    }

    private String posaljiSignalJaloveEnergije(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - jalova energija [kVarh] - " +
                "mjerena veličina" +
                System.lineSeparator();
    }

    private String posaljiSignalAlarma() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - alarm - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String posaljiTrenutneSignaleBrojila() {
        return posaljiTrenutniSignalJaloveEnergije() +
                posaljiTrenutniSignalAlarma();
    }

    public String posaljiTrenutniSignalJaloveEnergije(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - jalova energija [kVarh] - " +
                this.jalovaEnergija +
                System.lineSeparator();
    }

    public String posaljiTrenutniSignalAlarma(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - alarm - " +
                this.alarm +
                System.lineSeparator();
    }

}
