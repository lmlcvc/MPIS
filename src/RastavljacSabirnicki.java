public class RastavljacSabirnicki extends Rastavljac{

    public RastavljacSabirnicki(String id, String modul) {
        this.identifikator = id;
        this.modul = modul;
        this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
        this.komanda = RastavljacKomanda.JEDAN; // TODO: lmao nez
    }

    @Override
    public String posaljiSignal() {
        StringBuilder sb = new StringBuilder();

        sb.append("TS A - 220 kV - ");
        sb.append(this.modul);
        sb.append(" - ");
        sb.append(this.getClass());
        sb.append(" - stanje - ");
        sb.append(this.stanje);

        return sb.toString();
    }
}
