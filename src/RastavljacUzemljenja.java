public class RastavljacUzemljenja extends Rastavljac {

    public RastavljacUzemljenja(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
        this.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
    }

    public void postaviStanje() {
    }
}
