public class SpojnoPolje extends Polje {

    public SpojnoPolje() {
        this.ukljuceno = false;

        this.rastavljacS1 = new RastavljacSabirnicki("S1 SP", "SP");
        this.rastavljacS2 = new RastavljacSabirnicki("S2 SP", "SP");

        this.rastavljacIzlazni = new RastavljacIzlazni("Izlazni rastavljač SP", "SP");
        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja SP", "SP");

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6 SP", "SP");
    }

    public void ukljuci() {
        this.rastavljacS1.ukljuci();
        this.rastavljacS2.ukljuci();

        this.prekidac.ukljuci();

        this.ukljuceno = true;
    }

    public void iskljuci() { // TODO: je li ovo dosta
        this.ukljuceno = false;
    }
}
