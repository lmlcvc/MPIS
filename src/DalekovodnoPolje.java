public class DalekovodnoPolje extends Polje {

    ZastitaNadstrujna nadstrujnaZastita;
    ZastitaDistantna distantnaZastita;
    Apu apu;

    MjerniPretvornikRadneSnage mprs;
    MjerniPretvornikNapona mpn;
    Brojilo brojilo;



    SekOpremaUp sekOpremaUp;

    ZastiteUp zastiteUp;
    ZastiteIsk zastiteIsk;
    OstaleZastiteIsk ostaleZastiteIsk;

    public DalekovodnoPolje() {
        if (this.napajanje) {
            this.ukljuceno = true;
        }

        this.rastavljacS1 = new RastavljacSabirnicki("S1 DP", "DV");
        this.rastavljacS1.iskljuci();

        this.rastavljacS2 = new RastavljacSabirnicki("S2 DP", "DV");
        this.rastavljacS2.ukljuci();

        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja DP", "DV");
        this.rastavljacUzemljenja.ukljuci();

        this.rastavljacIzlazni = new RastavljacIzlazni("izlazni rastavljač DP", "DV");
        this.rastavljacIzlazni.ukljuci();

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6 DP", "DP");
        this.prekidac.iskljuci();
    }
}
