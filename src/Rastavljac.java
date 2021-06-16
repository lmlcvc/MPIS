public abstract class Rastavljac extends Polje implements Napajanje {
    String identifikator;
    String modul;
    StanjePrekidacRastavljac stanje;
    RastavljacKomanda komanda;
    boolean napajanje = true;

    // TODO: promjena između izlazznog i uzemljenja

    public void ukljuci(Polje polje) {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }
    }

    public void iskljuci(Polje polje) {
        if (this.napajanje) {
            if (polje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                this.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
            } else {
                System.out.println("Nemoguće isključiti, prekidač nije isključen");
            }
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }

    public String posaljiSignal() {
        StringBuilder sb = new StringBuilder();

        sb.append("TS A - 220 kV - ");
        sb.append(this.modul);
        sb.append(" - ");
        sb.append(this.identifikator);
        sb.append(" - stanje - ");
        sb.append(this.stanje);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    } // TODO: blago nepotrebno?
}
