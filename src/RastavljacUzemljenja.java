public class RastavljacUzemljenja extends Rastavljac {

    public RastavljacUzemljenja(String id) {
        this.identifikator = id;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN; // TODO: lmao nez
    }

    public void postaviStanje() {
    }
}
