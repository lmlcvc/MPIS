public class Apu implements Napajanje {

    ApuUkljucenje apuUkljucenje;
    ApuBlokada apuBlokada;
    Apu1P apu1P;
    Apu3P apu3P;
    boolean napajanje = true;

    public void posaljiSignal() {
    }

    // TODO: u kodu vidjeti je li bolje da ovo bude interface
    public void sekOpremaUp() {
    }


    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
