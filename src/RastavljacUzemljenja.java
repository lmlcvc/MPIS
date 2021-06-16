public class RastavljacUzemljenja extends Rastavljac {

    public RastavljacUzemljenja(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN; // TODO: lmao nez
    }

    public void postaviStanje() {
    }
}
