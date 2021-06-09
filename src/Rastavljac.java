public abstract class Rastavljac extends Polje implements Napajanje {
    String identifikator;
    StanjePrekidacRastavljac stanje;
    RastavljacKomanda komanda;
    boolean napajanje = true;

    public void ukljuci() {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }
    }

    public void iskljuci() {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
