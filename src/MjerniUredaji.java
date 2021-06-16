public abstract class MjerniUredaji implements Napajanje {

    boolean napajanje = true;

    public void /*float*/ ocitaj() {
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
