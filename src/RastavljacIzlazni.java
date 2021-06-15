public class RastavljacIzlazni extends Rastavljac{

    public RastavljacIzlazni(String id, String modul){
        this.identifikator = id;
        this.modul = modul;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN; // TODO: lmao nez
    }

}
