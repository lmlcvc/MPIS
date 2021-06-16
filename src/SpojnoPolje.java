public class SpojnoPolje extends Polje {

    public SpojnoPolje() {
        this.ukljuceno = false;

        this.rastavljacS1 = new RastavljacSabirnicki("S1 SP", "SP");
        this.rastavljacS1.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacS2 = new RastavljacSabirnicki("S2 SP", "SP");
        this.rastavljacS2.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacIzlazni = new RastavljacIzlazni("Izlazni rastavljač SP", "SP");
        this.rastavljacIzlazni.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja SP", "SP");
        this.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.UKLJUCEN;

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6 SP", "SP");
        this.prekidac.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
    }

    public void ukljuci(Polje polje) {
        this.rastavljacS1.ukljuci(polje);
        this.rastavljacS2.ukljuci(polje);

        this.prekidac.ukljuci(this);

        this.ukljuceno = true;
    }

    public void iskljuci() { // TODO: je li ovo dosta --- nije bilo dosta
        // this.ukljuceno = false;

        this.rastavljacS1.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacS2.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacIzlazni.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        this.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.prekidac.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
    }
}
