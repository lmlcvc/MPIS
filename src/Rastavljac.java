public abstract class Rastavljac extends Polje implements Napajanje {
    String identifikator;
    String modul;

    EnumStanjePrekidacRastavljac stanje;
    EnumKomanda komanda = EnumKomanda.UKLOP;

    boolean napajanje = true;

    public void ukljuci(Polje polje) {
        if (this.napajanje) {
            this.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }
    }

    public void iskljuci(Polje polje) {
        if (this.napajanje) {
            if (polje.prekidac.stanje == EnumStanjePrekidacRastavljac.ISKLJUCEN) {
                this.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
            } else {
                System.out.println("Nemoguće isključiti, prekidač nije isključen");
            }
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }

    public String posaljiSignaleRastavljaca() {
        return posaljiSignalKomanda() +
                posaljiSignalStanje();
    }

    private String posaljiSignalKomanda() {
        StringBuilder sb = new StringBuilder();

        EnumKomanda[] komande = EnumKomanda.values();
        for(EnumKomanda komanda : komande){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - komanda - ");
            sb.append(komanda);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalStanje(){
        StringBuilder sb = new StringBuilder();

        EnumStanjePrekidacRastavljac[] stanja = EnumStanjePrekidacRastavljac.values();
        for(EnumStanjePrekidacRastavljac stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - stanje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String posaljiTrenutneSignaleRastavljaca() {
        return posaljiTrenutniSignalKomanda() +
                posaljiTrenutniSignalStanje();
    }

    private String posaljiTrenutniSignalKomanda() {
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - komanda - " +
                this.komanda +
                System.lineSeparator();
    }

    private String posaljiTrenutniSignalStanje(){
        return "TS A - 220 kV - " +
                this.modul +
                " - " +
                this.identifikator +
                " - stanje - " +
                this.stanje +
                System.lineSeparator();
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    } // TODO: blago nepotrebno?
}
