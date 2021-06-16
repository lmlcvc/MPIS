public class SpojnoPolje extends Polje {

    public SpojnoPolje() {
        this.ukljuceno = false;

        this.rastavljacS1 = new RastavljacSabirnicki("Rastavljač S1", "SP");
        this.rastavljacS1.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacS2 = new RastavljacSabirnicki("Rastavljač S2", "SP");
        this.rastavljacS2.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacIzlazni = new RastavljacIzlazni("Izlazni rastav.", "SP");
        this.rastavljacIzlazni.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacUzemljenja = new RastavljacUzemljenja("R. uzemljenja", "SP");
        this.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.UKLJUCEN;

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6", "SP");
        this.prekidac.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
    }

    public void ukljuci(Polje polje) {
        this.rastavljacS1.ukljuci(polje);
        this.rastavljacS2.ukljuci(polje);

        this.prekidac.ukljuci(this);

        this.ukljuceno = true;
    }

    public void iskljuci() {
        this.rastavljacS1.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacS2.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacIzlazni.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.prekidac.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
    }
}
