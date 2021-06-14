public class RastavljacSabirnicki extends Rastavljac{

    public RastavljacSabirnicki(String id) {
        this.identifikator = id;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN; // TODO: lmao nez
    }
}
