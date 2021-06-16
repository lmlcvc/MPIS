public class RastavljacIzlazni extends Rastavljac{

    public RastavljacIzlazni(String id, String modul){
        this.identifikator = id;
        this.modul = modul;
        this.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
    }

    @Override
    public void ukljuci(Polje polje) {
        if (this.napajanje) {
            this.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
            polje.rastavljacUzemljenja.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }

    }

    @Override
    public void iskljuci(Polje polje) {
        if (this.napajanje) {
            if (polje.prekidac.stanje == EnumStanjePrekidacRastavljac.ISKLJUCEN) {
                this.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
                polje.rastavljacUzemljenja.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
            } else {
                System.out.println("Nemoguće isključiti, prekidač nije isključen");
            }
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }
}
