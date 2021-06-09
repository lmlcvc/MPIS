public class PrekidacSF6Koncar extends Prekidac {
    /*UpozorenjeKoncar gubitakSF6Upozorenje;
    BlokadaSF6Koncar gubitakSF6BlokadaRada;
    BlokadaN2Koncar gubitakN2BlokadaRada;
    BlokadaUljaKoncar gubitakUljaBlokadaRada;
    BlokadaMinTlakKoncar minTlakUljaBlokada;
    BlokadaSF6N2UljeKoncar SF6N2UljeBlokada;
    BlokadaAPUKOncar APUBlokada;
    GrijanjeKoncar kvarGrijanja;*/

    EnumProradaPrestanak gubitakSF6Upozorenje, gubitakN2BlokadaRada, minTlakUljaBlokada, gubitakSF6BlokadaRada;
    EnumProradaPrestanak SF6N2Ulje, gubitakUljaBlokadaRada, APUBlokada, kvarGrijanja;

    public PrekidacSF6Koncar() {
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

        for(EnumProradaPrestanak varijabla : varijable){
            varijabla = EnumProradaPrestanak.PRESTANAK;
        }
    }

    public void PrimOpremaUp() {

    }
}
