public class SpojnoPolje extends Polje {

    public SpojnoPolje() {
        this.ukljuceno = false;

        this.rastavljacS1 = new RastavljacSabirnicki("Rastavljač S1", "SP");
        this.rastavljacS1.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacS2 = new RastavljacSabirnicki("Rastavljač S2", "SP");
        this.rastavljacS2.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacIzlazni = new RastavljacIzlazni("Izlazni rastavljač", "SP");
        this.rastavljacIzlazni.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja", "SP");
        this.rastavljacUzemljenja.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6", "SP");
        this.prekidac.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
    }

    public void ukljuci(Polje polje) {
        this.rastavljacS1.ukljuci(polje);
        this.rastavljacS2.ukljuci(polje);

        this.prekidac.ukljuci(this);

        this.ukljuceno = true;
    }

    public void iskljuci() {
        this.rastavljacS1.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacS2.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacIzlazni.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacUzemljenja.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
        this.prekidac.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
    }
}
