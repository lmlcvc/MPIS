public abstract class Rastavljac extends Polje implements Napajanje {
    String identifikator;
    String modul;

    EnumStanjePrekidacRastavljac stanje;
    EnumKomanda komanda = EnumKomanda.UKLOP;

    boolean napajanje = true;

    // TODO: promjena između izlazznog i uzemljenja

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
        StringBuilder sb = new StringBuilder();

        sb.append(posaljiSignalKomanda());
        sb.append(posaljiSignalStanje());

        return sb.toString();
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

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    } // TODO: blago nepotrebno?
}
