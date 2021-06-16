public class RastavljacSabirnicki extends Rastavljac{

    public RastavljacSabirnicki(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
        this.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
    }

}
