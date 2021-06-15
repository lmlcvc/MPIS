public class PrekidacSF6Koncar extends Prekidac {

    EnumProradaPrestanak gubitakSF6Upozorenje, gubitakN2BlokadaRada, minTlakUljaBlokada, gubitakSF6BlokadaRada;
    EnumProradaPrestanak SF6N2Ulje, gubitakUljaBlokadaRada, APUBlokada, kvarGrijanja;

    public PrekidacSF6Koncar(String id, String modul) {
        initVarijable();

        this.identifikator = id;
        this.modul = modul;
    }

    public void initVarijable() {
        this.varijable.add(gubitakSF6Upozorenje = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(gubitakN2BlokadaRada = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(minTlakUljaBlokada = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(gubitakSF6BlokadaRada = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(SF6N2Ulje = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(gubitakUljaBlokadaRada = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(APUBlokada = EnumProradaPrestanak.PRESTANAK);
        this.varijable.add(kvarGrijanja = EnumProradaPrestanak.PRESTANAK);
    }

    public void PrimOpremaUp() {

    }

}
