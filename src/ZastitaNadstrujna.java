public class ZastitaNadstrujna extends Zastita {

    EnumProradaPrestanak npcIskljucenje = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak vpcIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak zemljospojnaIskljucenje = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak odPreopterecenjaUpozorenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak odPreopterecenjaIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak relejKvar = EnumProradaPrestanak.PRESTANAK;

    public ZastitaNadstrujna(String id, String modul) {
        super(id, modul);
    }

    public String posaljiSignaleNadstrujne() {
        return posaljiSignalNPC() +
                posaljiSignalVPC() +
                posaljiSignalZemljospojnaIskljucenje() +
                posaljiSignalOdPreopterecenjaUpozorenje() +
                posaljiSignalOdPreopterecenjaIskljucenje() +
                posaljiSignalRelejKvar();
    }

    private String posaljiSignalNPC() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - NPČ-isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalVPC() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - VPČ-isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalZemljospojnaIskljucenje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - zemljospojna isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalOdPreopterecenjaUpozorenje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - od preopterećenja upozorenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalOdPreopterecenjaIskljucenje() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - od preopterećenja isključenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalRelejKvar() {
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - relej-kvar - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String posaljiTrenutneSignaleNadstrujne() {
        return posaljiTrenutniSignalNPC() +
                posaljiTrenutniSignalVPC() +
                posaljiTrenutniSignalZemljospojnaIskljucenje() +
                posaljiTrenutniSignalOdPreopterecenjaUpozorenje() +
                posaljiTrenutniSignalOdPreopterecenjaIskljucenje() +
                posaljiTrenutniSignalRelejKvar();
    }

    private String posaljiTrenutniSignalNPC() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - NPČ-isključenje - " +
                npcIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalVPC() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - VPČ-isključenje - " +
                vpcIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalZemljospojnaIskljucenje() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - zemljospojna isključenje - " +
                zemljospojnaIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalOdPreopterecenjaUpozorenje() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - od preopterećenja upozorenje - " +
                odPreopterecenjaUpozorenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalOdPreopterecenjaIskljucenje() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - od preopterećenja isključenje - " +
                odPreopterecenjaIskljucenje +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalRelejKvar() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - relej-kvar - " +
                relejKvar +
                System.lineSeparator();
    }

    public void postaviStanje() {
    }

    public void ostaleZastiteIsk() {
    }

    public void ZastiteUp() {
    }

    @Override
    public void sekOpremaUp() {

    }
}
