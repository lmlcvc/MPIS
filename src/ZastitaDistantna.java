public class ZastitaDistantna extends Zastita {

    EnumProradaPrestanak iskljucenje = EnumProradaPrestanak.PRESTANAK;
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
        return posaljiSignalIskljucenje() +
                posaljiSignalfazaL1() +
                posaljiSignalfazaL2() +
                posaljiSignalfazaL3() +
                posaljiSignalZemljospojPoticaj() +
                posaljiSignalDrugiStupanj() +
                posaljiSignalTreciStupanj() +
                posaljiSignalCetvrtiStupanj() +
                posaljiSignalSuprotniSmjer() +
                posaljiSignalNjihanjeEnergije() +
                posaljiSignalTKSignalPrijem() +
                posaljiSignalTKSignalSlanje() +
                posaljiSignalTKSignalIskljucenje() +
                posaljiSignalNapajanjeNestanak() +
                posaljiSignalUredajKvar();
    }

    private String posaljiSignalIskljucenje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for (EnumProradaPrestanak stanje : stanja) {
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - isklju??enje - ");
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
            sb.append(" - drugi stupanj-isklju??enje - ");
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
            sb.append(" - tre??i stupanj-isklju??enje - ");
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
            sb.append(" - ??etvrti stupanj-isklju??enje - ");
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
            sb.append(" - TK signal-isklju??enje - ");
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
            sb.append(" - ure??aj-kvar - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String posaljiTrenutneSignaleDistantne() {
        return posaljiTrenutniSignalIskljucenje() +
                posaljiTrenutniSignalfazaL1() +
                posaljiTrenutniSignalfazaL2() +
                posaljiTrenutniSignalfazaL3() +
                posaljiTrenutniSignalZemljospojPoticaj() +
                posaljiTrenutniSignalDrugiStupanj() +
                posaljiTrenutniSignalTreciStupanj() +
                posaljiTrenutniSignalCetvrtiStupanj() +
                posaljiTrenutniSignalSuprotniSmjer() +
                posaljiTrenutniSignalNjihanjeEnergije() +
                posaljiTrenutniSignalTKSignalPrijem() +
                posaljiTrenutniSignalTKSignalSlanje() +
                posaljiTrenutniSignalTKSignalIskljucenje() +
                posaljiTrenutniSignalNapajanjeNestanak() +
                posaljiTrenutniSignalUredajKvar();
    }

    private String posaljiTrenutniSignalIskljucenje() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - isklju??enje - " +
                this.iskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalfazaL1() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - faza L1-poticaj - " +
                fazaL1Poticaj +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalfazaL2() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - faza L2-poticaj - " +
                fazaL2Poticaj +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalfazaL3() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - faza L3-poticaj - " +
                fazaL3Poticaj +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalZemljospojPoticaj() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - zemljospoj-poticaj - " +
                this.zemljospojPoticaj +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalDrugiStupanj() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - drugi stupanj-isklju??enje - " +
                this.drugiStupanjIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalTreciStupanj() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - tre??i stupanj-isklju??enje - " +
                this.treciStupanjIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalCetvrtiStupanj() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - ??etvrti stupanj-isklju??enje - " +
                this.cetvrtiStupanjIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalSuprotniSmjer() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - suprotni smjer-poticaj - " +
                this.suprotniSmjerPoticaj +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalNjihanjeEnergije() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - njihanje energije-blokada - " +
                this.njihanjeEnergijeBlokada +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalTKSignalPrijem() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - TK signal-prijem - " +
                this.tkSignalPrijem +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalTKSignalSlanje() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - TK signal-slanje - " +
                this.tkSignalSlanje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalTKSignalIskljucenje() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - TK signal-isklju??enje - " +
                this.tkSignalIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalNapajanjeNestanak() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - napajanje-nestanak - " +
                this.napajanjeNestanak +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalUredajKvar() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - ure??aj-kvar - " +
                this.uredajKvar +
                System.lineSeparator();
    }

    @Override
    public void sekOpremaUp() {

    }

}
