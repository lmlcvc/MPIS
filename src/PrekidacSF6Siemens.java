public class PrekidacSF6Siemens extends Prekidac {
    EnumProradaPrestanak gubitakSF6Upozorenje, gubitakN2BlokadaRada, minTlakUljaBlokada, gubitakSF6BlokadaRada;
    EnumProradaPrestanak SF6N2Ulje, gubitakUljaBlokadaRada, APUBlokada, kvarGrijanja, neskladPolova;
    EnumUpravljanje upravljanje;

    public PrekidacSF6Siemens() {
        initVarijable();
    }

    public void initVarijable() {
        this.varijable.add(gubitakSF6Upozorenje);
        this.varijable.add(gubitakN2BlokadaRada);
        this.varijable.add(minTlakUljaBlokada);
        this.varijable.add(gubitakSF6BlokadaRada);
        this.varijable.add(SF6N2Ulje);
        this.varijable.add(gubitakUljaBlokadaRada);
        this.varijable.add(APUBlokada);
        this.varijable.add(kvarGrijanja);
        this.varijable.add(neskladPolova);
        this.varijable.add(upravljanje);

        for (Enum varijabla : varijable) {
            if(varijabla.getClass().toString().equals("EnumProradaPrestanak")){
                varijabla = EnumProradaPrestanak.PRESTANAK;
            }
        }
        upravljanje = EnumUpravljanje.DALJINSKO;
    }


    public void primOpremaUp() {
    }

    public void zastiteIsk() {
    }

}
