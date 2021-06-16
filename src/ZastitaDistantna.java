public class ZastitaDistantna extends Zastita {

    EnumProradaPrestanak iskljucenje = EnumProradaPrestanak.PRESTANAK; // TODO: da li ima ovo?
    EnumProradaPrestanak fazaL1Poticaj = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak fazaL2Poticaj = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak fazaL3Poticaj = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak zemljospojPoticaj = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak drugiStupanjIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak treciStupanjIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak cetvrtiStupanjIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak suprotniSmjerPoticaj = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak njihanjeEnergijeBlokada = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak tkSignalPrijem = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak tkSignalSlanje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak tkSignalIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak napajanjeNestanak = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak uredajKvar = EnumProradaPrestanak.PRESTANAK;

    public ZastitaDistantna(String id, String modul) {
        super(id, modul);
    }

    public String posaljiSignaleDistantne() {
        StringBuilder sb = new StringBuilder();

        sb.append(posaljiSignalIskljucenje());
        sb.append(posaljiSignalfazaL1());
        sb.append(posaljiSignalfazaL2());
        sb.append(posaljiSignalfazaL3());
        sb.append(posaljiSignalZemljospojPoticaj());
        sb.append(posaljiSignalDrugiStupanj());
        sb.append(posaljiSignalTreciStupanj());
        sb.append(posaljiSignalCetvrtiStupanj());
        sb.append(posaljiSignalSuprotniSmjer());
        sb.append(posaljiSignalNjihanjeEnergije());
        sb.append(posaljiSignalTKSignalPrijem());
        sb.append(posaljiSignalTKSignalSlanje());
        sb.append(posaljiSignalTKSignalIskljucenje());
        sb.append(posaljiSignalNapajanjeNestanak());
        sb.append(posaljiSignalUredajKvar());

        return sb.toString();
    }

    private String posaljiSignalIskljucenje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalfazaL1() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - faza L1-poticaj - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalfazaL2() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - faza L2-poticaj - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalfazaL3() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - faza L3-poticaj - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalZemljospojPoticaj() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - zemljospoj-poticaj - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalDrugiStupanj() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - drugi stupanj-isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalTreciStupanj() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - treći stupanj-isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalCetvrtiStupanj() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - četvrti stupanj-isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalSuprotniSmjer() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - suprotni smjer-poticaj - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalNjihanjeEnergije() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - njihanje energije-blokada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalTKSignalPrijem() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - TK signal-prijem - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalTKSignalSlanje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - TK signal-slanje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalTKSignalIskljucenje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - TK signal-isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalNapajanjeNestanak() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - napajanje-nestanak - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalUredajKvar() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - uređaj-kvar - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public void sekOpremaUp() {

    }

    public void zastiteIsk() {

    }
}
