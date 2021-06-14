public class DalekovodnoPolje extends Polje {

    ZastitaNadstrujna nadstrujnaZastita;
    ZastitaDistantna distantnaZastita;
    Apu apu;

    MjerniPretvornikRadneSnage mprs;
    MjerniPretvornikNapona mpn;
    Brojilo brojilo;

    RastavljacIzlazni rastavljacIzlazni;
    RastavljacUzemljenja rastavljacUzemljenja;

    SekOpremaUp sekOpremaUp;

    ZastiteUp zastiteUp;
    ZastiteIsk zastiteIsk;
    OstaleZastiteIsk ostaleZastiteIsk;

    public DalekovodnoPolje() {
        if (this.napajanje) {
            this.ukljuceno = true;
        }

        this.rastavljacS1 = new RastavljacSabirnicki("S1 DP");
        this.rastavljacS1.ukljuci();

        this.rastavljacS2 = new RastavljacSabirnicki("S2 DP");
        this.rastavljacS2.ukljuci();

        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja DP");

        this.rastavljacIzlazni = new RastavljacIzlazni("izlazni rastavljač DP");

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6 DP");
    }
}
