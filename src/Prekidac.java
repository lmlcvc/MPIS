import java.util.ArrayList;

public abstract class Prekidac extends Polje implements Napajanje {

    String identifikator;
    String modul;

    ArrayList<Enum> varijable = new ArrayList<Enum>();

    EnumKomanda komanda = EnumKomanda.UKLOP;
    EnumStanjePrekidacRastavljac stanje;
    EnumProradaPrestanak gubitakSF6Upozorenje = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak gubitakN2 = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak minTlakUlja = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak getGubitakSF6Blokada = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak gubitakUlja = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak uljeSF6N2 = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak apuBlokada = EnumProradaPrestanak.PRESTANAK;
    EnumProradaPrestanak kvarGrijanja = EnumProradaPrestanak.PRESTANAK;

    boolean napajanje = true;

    public void ukljuci(Polje polje) {
        if (this.napajanje) { // barem 1 od sabirničkih i barem 1 od ova 2
            if (polje.rastavljacS1.stanje == EnumStanjePrekidacRastavljac.UKLJUCEN
                    || polje.rastavljacS2.stanje == EnumStanjePrekidacRastavljac.UKLJUCEN) {
                this.stanje = EnumStanjePrekidacRastavljac.UKLJUCEN;
            } else {
                System.out.println("Nemoguće uključiti, prekidači nisu uključeni.");
            }
        } else {
            System.out.println("Nemoguće uključiti, napajanje nije spojeno.");
        }
    }

    public void iskljuci() {
        if (this.napajanje) {
            this.stanje = EnumStanjePrekidacRastavljac.ISKLJUCEN;
        } else {
            System.out.println("Nemoguće isključiti, napajanje nije spojeno.");
        }
    }

    public String posaljiSignalePrekidaca() {
        StringBuilder sb = new StringBuilder();

        sb.append(posaljiSignalKomanda());
        sb.append(posaljiSignalStanje());
        sb.append(posaljiSignalGubitakSF6Upozorenje());
        sb.append(posaljiSignalGubitakN2());
        sb.append(posaljiSignalMinTlakUlja());
        sb.append(posaljiSignalGubitakSF6Blokada());
        sb.append(posaljiSignalSF6N2Ulje());
        sb.append(posaljiSignalAPUBlokada());
        sb.append(posaljiSignalKvarGrijanja());

        return sb.toString();
    }

    private String posaljiSignalKomanda() {
        StringBuilder sb = new StringBuilder();

        EnumKomanda[] komande = EnumKomanda.values();
        for(EnumKomanda komanda : komande){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - komanda - ");
            sb.append(komanda);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalStanje(){
        StringBuilder sb = new StringBuilder();

        EnumStanjePrekidacRastavljac[] stanja = EnumStanjePrekidacRastavljac.values();
        for(EnumStanjePrekidacRastavljac stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - stanje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalGubitakSF6Upozorenje(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - gubitak SF6-upozorenje - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalGubitakN2(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - gubitak N2-blokada rada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalMinTlakUlja(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - min. tlak ulja-blokada uklopa - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalGubitakSF6Blokada(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - gubitak SF6-blokada rada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalGubitakUlja(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - gubitak ulja-blokada rada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalSF6N2Ulje(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - SF6;N2;ulje-blokada rada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalAPUBlokada(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - APU-blokada - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String posaljiSignalKvarGrijanja(){
        StringBuilder sb = new StringBuilder();

        EnumProradaPrestanak[] stanja = EnumProradaPrestanak.values();
        for(EnumProradaPrestanak stanje : stanja){
            sb.append("TS A - 220 kV - ");
            sb.append(this.modul);
            sb.append(" - ");
            sb.append(this.identifikator);
            sb.append(" - kvar grijanja - ");
            sb.append(stanje);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
