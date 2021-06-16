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
        StringBuilder sb = new StringBuilder();

        sb.append(posaljiSignalUkljucenje());
        sb.append(posaljiSignalBlokada());
        sb.append(posaljiSignal1P());
        sb.append(posaljiSignal3P());

        return sb.toString();
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

    // TODO: u kodu vidjeti je li bolje da ovo bude interface
    // kaj je ovo,,
    public void sekOpremaUp() {
    }


    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
