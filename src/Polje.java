public abstract class Polje {

    RastavljacIzlazni rastavljacIzlazni;
    RastavljacUzemljenja rastavljacUzemljenja;

    boolean ukljuceno;
    boolean napajanje = true;
    PrimOpremaUp primOpremaUp;

    Prekidac prekidac;
    RastavljacSabirnicki rastavljacS1;
    RastavljacSabirnicki rastavljacS2;

    public void ukljuciGrupneSignale() {
    }

    public void iskljuciGrupneSignale() {
    }
}
