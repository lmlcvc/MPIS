import java.util.ArrayList;

public abstract class Prekidac extends Polje implements Napajanje {

    String identifikator;
    StanjePrekidacRastavljac stanje;
    String modul;

    ArrayList<Enum> varijable = new ArrayList<Enum>();

    PrekidacKomanda komanda;
    boolean napajanje = true;

    public void ukljuci() {
        if (this.napajanje) {
            if(this.stanje == StanjePrekidacRastavljac.UKLJUCEN){
                System.out.println("Prekidač " + this.identifikator + " je već uključen.");
            } else {
                System.out.println("Uključivanje prekidača " + this.identifikator);
                this.stanje = StanjePrekidacRastavljac.UKLJUCEN;
            }
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }
    }

    public void iskljuci() {
        if (this.napajanje) {
            this.stanje = StanjePrekidacRastavljac.ISKLJUCEN;
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }

    // TODO: funkcija za dobivanje sgnala iz trenutnog stanja uređaja
    public String posaljiSignal(){
        StringBuilder sb = new StringBuilder();

        sb.append("TS A - 220 kV - ");
        sb.append(this.modul);
        sb.append(" - ");
        sb.append(this.getClass().getSimpleName()); // TODO: ili bolje identifikator? složiti ljepše id-e
        sb.append(" - stanje - ");
        sb.append(this.stanje);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
