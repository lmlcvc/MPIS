public class Apu implements Napajanje {

    String identifikator;
    String modul;

    EnumProradaPrestanak apuUkljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak apuBlokada = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak apu1P = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak apu3P = EnumProradaPrestanak.PRESTANAK;

    boolean napajanje = true;

    public Apu(String id, String modul){
        this.identifikator = id;
        this.modul = modul;
    }

    public String posaljiSignaleAPU() {
        return posaljiSignalUkljucenje() +
                posaljiSignalBlokada() +
                posaljiSignal1P() +
                posaljiSignal3P();
    }

    private String posaljiSignalUkljucenje(){
        StringBuilder sb = new StringBuilder();

        EnumStanjePrekidacRastavljac[] stanja = EnumStanjePrekidacRastavljac.values();
        for(EnumStanjePrekidacRastavljac stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - APU uključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalBlokada(){
        StringBuilder sb = new StringBuilder();

        EnumStanjePrekidacRastavljac[] stanja = EnumStanjePrekidacRastavljac.values();
        for(EnumStanjePrekidacRastavljac stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - APU blokada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignal1P(){
        StringBuilder sb = new StringBuilder();

        EnumStanjePrekidacRastavljac[] stanja = EnumStanjePrekidacRastavljac.values();
        for(EnumStanjePrekidacRastavljac stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - APU 1P - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignal3P(){
        StringBuilder sb = new StringBuilder();

        EnumStanjePrekidacRastavljac[] stanja = EnumStanjePrekidacRastavljac.values();
        for(EnumStanjePrekidacRastavljac stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - APU 3P - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String posaljiTrenutneSignaleAPU() {
        return posaljiTrenutniSignalUkljucenje() +
                posaljiTrenutniSignalBlokada() +
                posaljiTrenutniSignal1P() +
                posaljiTrenutniSignal3P();
    }

    private String posaljiTrenutniSignalUkljucenje(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - APU uključenje - " +
                apuUkljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalBlokada(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - APU blokada - " +
                apuBlokada +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignal1P(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - APU 1P - " +
                apu1P +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignal3P(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - APU 3P - " +
                apu3P +
                System.lineSeparator();
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
