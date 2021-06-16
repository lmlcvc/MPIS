public class ZastitaNadstrujna extends Zastita {

    EnumProradaPrestanak npcIskljucenje = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak vpcIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak zemljospojnaIskljucenje = EnumProradaPrestanak.PRORADA;
    EnumProradaPrestanak odPreopterecenjaUpozorenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak getOdPreopterecenjaIskljucenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak relejKvar = EnumProradaPrestanak.PRESTANAK;

    public ZastitaNadstrujna(String id, String modul) {
        super(id, modul);
    }

    public String posaljiSignaleNadstrujne() {
        StringBuilder sb = new StringBuilder();

        sb.append(posaljiSignalNPC());
        sb.append(posaljiSignalVPC());
        sb.append(posaljiSignalZemljospojnaIskljucenje());
        sb.append(posaljiSignalOdPreopterecenjaUpozorenje());
        sb.append(posaljiSignalOdPreopterecenjaIskljucenje());
        sb.append(posaljiSignalRelejKvar());

        return sb.toString();
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
            sb.append(" - NPČ-isključenje - ");
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
