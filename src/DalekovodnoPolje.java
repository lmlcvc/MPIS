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

        this.rastavljacS1 = new RastavljacSabirnicki("Rastavljač S1", "DV");
        this.rastavljacS1.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacS2 = new RastavljacSabirnicki("Rastavljač S2", "DV");
        this.rastavljacS2.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;

        this.rastavljacUzemljenja = new RastavljacUzemljenja("Rastavljač uzemljenja", "DV");
        this.rastavljacUzemljenja.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;

        this.rastavljacIzlazni = new RastavljacIzlazni("Izlazni rastavljač", "DV");
        this.rastavljacIzlazni.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;

        this.prekidac = new PrekidacSF6Koncar("Prekidač", "DV");
        this.prekidac.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;

        this.distantnaZastita = new ZastitaDistantna("Distantna zaštita", "DV");
        this.nadstrujnaZastita = new ZastitaNadstrujna("Nadstrujna zaštita", "DV");
        this.apu = new Apu("APU", "DV");

        this.mprs = new MjerniPretvornikRadneSnage("Mjerni pretvornik radne snage", "DV");
        this.mpn = new MjerniPretvornikNapona("Mjerni pretvornik napona", "DV");
        this.brojilo = new Brojilo("Brojilo jalove energije", "DV");
    }
}
