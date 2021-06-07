public abstract class Zastita {

    String identifikator;
    StanjeZastite stanje; // TODO: razdvajati enum tipove stanja ili ne?
    IspravnostZastite ispravnost;

    public abstract void sekOpremaUp();
}
