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
        this.rastavljacS1.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacS2 = new RastavljacSabirnicki("S2 DP", "DV");
        this.rastavljacS2.stanje = StanjePrekidacRastavljac.UKLJUCEN;

        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja DP", "DV");
        this.rastavljacUzemljenja.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacIzlazni = new RastavljacIzlazni("izlazni rastavljač DP", "DV");
        this.rastavljacIzlazni.stanje = StanjePrekidacRastavljac.UKLJUCEN;

        this.prekidac = new PrekidacSF6Koncar("Prekidač SF6 DP", "DP");
        this.prekidac.stanje = StanjePrekidacRastavljac.ISKLJUCEN;

        this.distantnaZastita = new ZastitaDistantna();
        this.nadstrujnaZastita = new ZastitaNadstrujna();
        this.apu = new Apu();

        this.mprs = new MjerniPretvornikRadneSnage();
        this.mpn = new MjerniPretvornikNapona();
        this.brojilo = new Brojilo();
    }
}
