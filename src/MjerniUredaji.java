public abstract class MjerniUredaji extends DalekovodnoPolje implements Napajanje {

    boolean napajanje = true;

    public void /*float*/ ocitaj() {
    }

    @Override
    public boolean provjeriNapajanje() {
        return this.napajanje;
    }
}
