import javax.swing.*;
import java.awt.*;

public class Postrojenje extends JFrame implements IScenariji {
    static DalekovodnoPolje dalekovodnoPolje;
    static SpojnoPolje spojnoPolje;

    private JButton ukljucitiDalekovodnoNaS1Button;
    private JButton ukljucitiDalekovodnoNaS2Button;
    private JButton iskljucitiDalekovodnoSpojenoNaS1;
    private JButton iskljucitiDalekovodnoSpojenoNaS2;
    private JButton prespojitiUkljucenoDalekovodnoNaS1;
    private JButton prespojitiUkljucenoDalekovodnoNaS2;

    private static Label labelMain;
    private static JTextArea labelDescription;

    static ZastitaDistantna zastitaDistantna = new ZastitaDistantna();
    static ZastitaNadstrujna zastitaNadstrujna = new ZastitaNadstrujna();


    public Postrojenje() {
        // instanciranje spojnog i dalekovodnog polja
        dalekovodnoPolje = new DalekovodnoPolje();
        spojnoPolje = new SpojnoPolje();

        // postavljanje kućica s tekstom
        labelMain = new Label("");
        add(labelMain);
        labelDescription = new JTextArea("");
        add(labelDescription);

        // postavljanje prozora
        setLayout(new GridLayout(0, 2));
        setSize(1000, 1000);
        setVisible(true);


        // action listeneri
        ukljucitiDalekovodnoNaS1Button.addActionListener(actionEvent -> ukljuciDalekovodnoS1());
        add(ukljucitiDalekovodnoNaS1Button);

        ukljucitiDalekovodnoNaS1Button.addActionListener(actionEvent -> ukljuciDalekovodnoS1());
        add(ukljucitiDalekovodnoNaS2Button);

        ukljucitiDalekovodnoNaS2Button.addActionListener(actionEvent -> ukljuciDalekovodnoS2());
        add(ukljucitiDalekovodnoNaS2Button);

        iskljucitiDalekovodnoSpojenoNaS1.addActionListener(actionEvent -> iskljuciDalekovodnoSpojenoNaS1());
        add(iskljucitiDalekovodnoSpojenoNaS1);

        iskljucitiDalekovodnoSpojenoNaS2.addActionListener(actionEvent -> iskljuciDalekovodnoSpojenoNaS2());
        add(iskljucitiDalekovodnoSpojenoNaS2);

        prespojitiUkljucenoDalekovodnoNaS1.addActionListener(actionEvent -> prespojiUkljucenoDalekovodnoNaS1());
        add(prespojitiUkljucenoDalekovodnoNaS1);

        prespojitiUkljucenoDalekovodnoNaS2.addActionListener(actionEvent -> prespojiUkljucenoDalekovodnoNaS2());
        add(prespojitiUkljucenoDalekovodnoNaS2);

    }


    // metode za rukovanje scenarijima
    @Override
    public void ukljuciDalekovodnoS1() {
        // TODO: treba li provjera je li već uključeno?

        labelMain.setText("");
        labelDescription.setText("");
        StringBuilder sb = new StringBuilder();

        if (Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Rastavljač ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.identifikator)
                    .append(" već je uključen.")
                    .append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
            sb.append("Uključivanje rastavljača uzemljenja ")
                    .append(System.lineSeparator());
        }


        if (Postrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Rastavljač ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacS1.identifikator)
                    .append(" već je uključen.").append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
            sb.append("Uključivanje rastavljača ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacS1.identifikator)
                    .append(System.lineSeparator());
        }


        if (Postrojenje.dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Rastavljač ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacIzlazni.identifikator)
                    .append(" već je uključen.").append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci();
            sb.append("Uključivanje rastavljača ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacIzlazni.identifikator)
                    .append(System.lineSeparator());
        }


        if (Postrojenje.dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Prekidač ")
                    .append(Postrojenje.dalekovodnoPolje.prekidac.identifikator)
                    .append(" već je uključen.").append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.prekidac.ukljuci();
            sb.append("Uključivanje prekidača ")
                    .append(Postrojenje.dalekovodnoPolje.prekidac.identifikator)
                    .append(System.lineSeparator());
        }

        labelDescription.setText(sb.toString());
        labelMain.setText("Dalekovodno polje spojeno na S1 uključeno");
        System.out.println("UKLJUČIVANJE: Dalekovodno polje spojeno na S1 uključeno");
    }

    @Override
    public void ukljuciDalekovodnoS2() {
        labelMain.setText("");
        labelDescription.setText("");
        StringBuilder sb = new StringBuilder();

        if (Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Rastavljač ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.identifikator)
                    .append(" već je uključen.")
                    .append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
            sb.append("Uključivanje rastavljača uzemljenja ")
                    .append(System.lineSeparator());
        }


        if (Postrojenje.dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Rastavljač ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacS2.identifikator)
                    .append(" već je uključen.").append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
            sb.append("Uključivanje rastavljača ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacS2.identifikator)
                    .append(System.lineSeparator());
        }


        if (Postrojenje.dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Rastavljač ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacIzlazni.identifikator)
                    .append(" već je uključen.")
                    .append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci();
            sb.append("Uključivanje rastavljača ")
                    .append(Postrojenje.dalekovodnoPolje.rastavljacIzlazni.identifikator)
                    .append(System.lineSeparator());
        }


        if (Postrojenje.dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            sb.append("Prekidač ")
                    .append(Postrojenje.dalekovodnoPolje.prekidac.identifikator)
                    .append(" već je uključen.")
                    .append(System.lineSeparator());
        } else {
            Postrojenje.dalekovodnoPolje.prekidac.ukljuci();
            sb.append("Uključivanje prekidača ")
                    .append(Postrojenje.dalekovodnoPolje.prekidac.identifikator)
                    .append(System.lineSeparator());
        }

        labelDescription.setText(sb.toString());
        labelMain.setText("Dalekovodno polje spojeno na S2 uključeno");
        System.out.println("UKLJUČIVANJE: Dalekovodno polje spojeno na S2 uključeno");
    }

    @Override
    public void iskljuciDalekovodnoSpojenoNaS1() {
        // TODO: provjera je li već isključeno
        // TODO: da li može biti spojeno i na s1 i na s2? treba li provjera?
        if (Postrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            Postrojenje.dalekovodnoPolje.prekidac.iskljuci();
            Postrojenje.dalekovodnoPolje.rastavljacIzlazni.iskljuci();
            Postrojenje.dalekovodnoPolje.rastavljacS1.iskljuci();
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();

            labelMain.setText("Dalekovodno polje spojeno na S1 isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje spojeno na S1 isključeno");
        } else {
            labelMain.setText("Dalekovodno polje nije spojeno na S1 i ne može biti isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje nije spojeno na S1 i ne može biti isključeno");
        }
    }

    @Override
    public void iskljuciDalekovodnoSpojenoNaS2() {
        if (Postrojenje.dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            Postrojenje.dalekovodnoPolje.prekidac.iskljuci();
            Postrojenje.dalekovodnoPolje.rastavljacIzlazni.iskljuci();
            Postrojenje.dalekovodnoPolje.rastavljacS2.iskljuci();
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();

            labelMain.setText("Dalekovodno polje spojeno na S2 isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje spojeno na S2 isključeno");
        } else {
            labelMain.setText("Dalekovodno polje nije spojeno na S2 i ne može biti isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje nije spojeno na S2 i ne može biti isključeno");
        }
    }

    @Override
    public void prespojiUkljucenoDalekovodnoNaS1() {
        // TODO: što točno treba u provjeri? krivo rade funkcije
        if (Postrojenje.dalekovodnoPolje.rastavljacS1.ukljuceno) {
            labelMain.setText("Dalekovodno polje je već spojeno na S1");
            System.out.println("PRESPAJANJE: Dalekovodno polje je već spojeno na S1");
        } else if (Postrojenje.dalekovodnoPolje.ukljuceno) {
            Postrojenje.spojnoPolje.ukljuci();

            Postrojenje.dalekovodnoPolje.rastavljacS2.ukljuci();
            Postrojenje.dalekovodnoPolje.rastavljacS1.iskljuci();

            Postrojenje.spojnoPolje.iskljuci();

            labelMain.setText("Dalekovodno polje prespojeno na S1");
            System.out.println("PRESPAJANJE: Dalekovodno polje prespojeno na S1");
        } else {
            labelMain.setText("Nemoguće prespojiti, dalekovodno polje je isključeno");
            System.out.println("PRESPAJANJE: Nemoguće prespojiti, dalekovodno polje je isključeno");
        }

    }

    @Override
    public void prespojiUkljucenoDalekovodnoNaS2() {
        if (Postrojenje.dalekovodnoPolje.rastavljacS2.ukljuceno) {
            Postrojenje.spojnoPolje.ukljuci();

            Postrojenje.dalekovodnoPolje.rastavljacS1.ukljuci();
            Postrojenje.dalekovodnoPolje.rastavljacS2.iskljuci();

            Postrojenje.spojnoPolje.iskljuci();

            labelMain.setText("Dalekovodno polje prespojeno na S2");
            System.out.println("PRESPAJANJE: Dalekovodno polje prespojeno na S2");
        } else {
            labelMain.setText("Nemoguće prespojiti, dalekovodno polje je isključeno");
            System.out.println("PRESPAJANJE: Nemoguće prespojiti, dalekovodno polje je isključeno");
        }
    }

    public static void main(String[] args) {
        new Postrojenje();
    }
}
