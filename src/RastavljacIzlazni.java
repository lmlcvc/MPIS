public class RastavljacIzlazni extends Rastavljac{

    public RastavljacIzlazni(String id, String modul){
        this.identifikator = id;
        this.modul = modul;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN;
    }

    @Override
    public void ukljuci(Polje polje) {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
            polje.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }

    }

    @Override
    public void iskljuci(Polje polje) {
        if (this.napajanje) {
            if (polje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                this.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
                polje.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.UKLJUCEN;
            } else {
                System.out.println("Nemoguće isključiti, prekidač nije isključen");
            }
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }
}
