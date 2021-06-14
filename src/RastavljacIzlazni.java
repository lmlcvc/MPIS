public class RastavljacIzlazni extends Rastavljac{

    public RastavljacIzlazni(String id){
        this.identifikator = id;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN; // TODO: lmao nez
    }
}
