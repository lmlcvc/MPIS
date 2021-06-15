import sun.java2d.x11.X11SurfaceDataProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Postrojenje extends JFrame implements IScenariji {
    public static Postrojenje postrojenje;

    static DalekovodnoPolje dalekovodnoPolje;
    static SpojnoPolje spojnoPolje;


    private static JLabel labelMain;
    private static JLabel labelSignaliDV;
    private static JLabel labelSignaliSP;

    private JButton button1;
    private JButton button2;
    private JButton buttonSignaliDV;
    private JButton buttonSignaliSP;
    private final JComboBox<String> dalekovodnoCombo;
    private final JComboBox<String> spojnoCombo;


    public Postrojenje() {
        // postavljanje prozora
        // setLayout(new GridLayout(0, 2));
        setLayout(null);
        setSize(1000, 1000);
        setVisible(true);

        // instanciranje spojnog i dalekovodnog polja
        dalekovodnoPolje = new DalekovodnoPolje();
        spojnoPolje = new SpojnoPolje();

        // postavljanje kućica s tekstom
        initJLabels();
        initButtons();

        String naredbe[] = {"Uključi sistem sabirnica 1", "Uključi sistem sabirnica 2",
                "Uključi sistem 1 na sistem 2", "Uključi sistem 2 na sistem 1",
                "Isključi sistem sabirnica 1", "Isključi sistem sabirnica 2", "Prikaz"};
        dalekovodnoCombo = new JComboBox(naredbe);
        dalekovodnoCombo.setBounds(225, 500, 200, 50);
        dalekovodnoCombo.setVisible(false);
        add(dalekovodnoCombo);

        spojnoCombo = new JComboBox(naredbe);
        spojnoCombo.setBounds(525, 500, 200, 50);
        spojnoCombo.setVisible(false);
        add(spojnoCombo);


        dalekovodnoCombo.addActionListener(actionEvent -> dalekovodnoComboActions(dalekovodnoCombo, naredbe));
        spojnoCombo.addActionListener(actionEvent -> spojnoComboActions(spojnoCombo, naredbe));
    }


    // metode za rukovanje scenarijima
    // TODO: pametnije napraviti provjere?

    @Override
    public void ukljuciDalekovodnoS1() {
        // TODO: treba li provjera je li već uključeno?

        if (Postrojenje.dalekovodnoPolje.ukljuceno) {
            labelMain.setText("Dalekovodno polje je već uključeno");
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
            Postrojenje.dalekovodnoPolje.rastavljacS2.ukljuci();
            Postrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci();
            Postrojenje.dalekovodnoPolje.prekidac.ukljuci();
            labelMain.setText("Dalekovodno polje spojeno na S1 uključeno");
        }

        System.out.println("UKLJUČIVANJE: Dalekovodno polje spojeno na S1 uključeno");
    }

    @Override
    public void ukljuciDalekovodnoS2() {

        if (Postrojenje.dalekovodnoPolje.ukljuceno) {
            labelMain.setText("Dalekovodno polje je već uključeno");
        } else {
            Postrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
            Postrojenje.dalekovodnoPolje.rastavljacS1.ukljuci();
            Postrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci();
            Postrojenje.dalekovodnoPolje.prekidac.ukljuci();
            labelMain.setText("Dalekovodno polje spojeno na S2 uključeno");
        }
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

    private void initJLabels(){
        // TODO: prozirno ili n bolje mjesto
        labelMain = new JLabel();
        labelMain.setBounds(100, 30, 400, 20);
        add(labelMain);

        labelSignaliDV = new JLabel();
        labelSignaliDV.setBounds(50, 575, 500, 150);
        add(labelSignaliDV);

        labelSignaliSP = new JLabel();
        labelSignaliSP.setBounds(50, 725, 500, 150);
        add(labelSignaliSP);
    }

    private void initButtons(){
        button1.setText("Dalekovodno polje");
        button1.setBounds(225, 400, 200, 100);
        add(button1);

        button2.setText("Spojno polje");
        button2.setBounds(525, 400, 200, 100);
        add(button2);

        buttonSignaliDV = new JButton();
        buttonSignaliDV.setText("Signali DV");
        buttonSignaliDV.setBounds(50, 550, 150, 50);
        add(buttonSignaliDV);

        buttonSignaliSP = new JButton();
        buttonSignaliSP.setText("Signali SP");
        buttonSignaliSP.setBounds(50, 700, 150, 50);
        add(buttonSignaliSP);

        addButtonClickListeners();
    }

    private void addButtonClickListeners(){
        button1.addActionListener(actionEvent ->
                dalekovodnoCombo.setVisible(!dalekovodnoCombo.isVisible()));
        button2.addActionListener(actionEvent -> spojnoCombo.setVisible(!spojnoCombo.isVisible()));

        buttonSignaliDV.addActionListener(actionEvent -> {
            labelSignaliDV.setText(getAllSignali(dalekovodnoPolje));
        });
        buttonSignaliSP.addActionListener(actionEvent -> {
            labelSignaliSP.setText(getAllSignali(spojnoPolje));
        });    }

    private String getAllSignali(Polje polje){
        StringBuilder sb = new StringBuilder();

        sb.append("<html><body><p>");
        sb.append(polje.rastavljacS1.posaljiSignal());
        sb.append("</br></br>");
        sb.append(polje.rastavljacS2.posaljiSignal());
        sb.append("</br></br>");
        sb.append(polje.rastavljacIzlazni.posaljiSignal());
        sb.append("</br></br>");
        sb.append(polje.rastavljacUzemljenja.posaljiSignal());
        sb.append("</br></br>");
        sb.append(polje.prekidac.posaljiSignal());
        sb.append("</p></body></html>");

        return sb.toString();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        Line2D lineSistem2 = new Line2D.Float(100, 100, 900, 100);
        g2.draw(lineSistem2);

        Line2D lineSistem1 = new Line2D.Float(100, 150, 900, 150);
        g2.draw(lineSistem1);

        Line2D lineDalekovodnoSistem2 = new Line2D.Float(300, 100, 300, 450);
        g2.draw(lineDalekovodnoSistem2);

        Line2D lineDalekovodnoSistem1 = new Line2D.Float(350, 150, 350, 450);
        g2.draw(lineDalekovodnoSistem1);

        Line2D lineSpojnoSistem2 = new Line2D.Float(600, 100, 600, 450);
        g2.draw(lineSpojnoSistem2);

        Line2D lineSpojnoSistem1 = new Line2D.Float(650, 150, 650, 450);
        g2.draw(lineSpojnoSistem1);
    }

    private void dalekovodnoComboActions(JComboBox dalekovodnoCombo, String[] naredbe) {
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[0]) {
            ukljuciDalekovodnoS1();
        }
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[1]) {
            ukljuciDalekovodnoS2();
        }
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[2]) {
            prespojiUkljucenoDalekovodnoNaS1();
        }
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[3]) {
            prespojiUkljucenoDalekovodnoNaS2();
        }
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[4]) {
            iskljuciDalekovodnoSpojenoNaS1();
        }
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[5]) {
            iskljuciDalekovodnoSpojenoNaS2();
        }
        if (dalekovodnoCombo.getSelectedItem().toString() == naredbe[6]) {
            FrameDalekovodno frameDalekovodno = new FrameDalekovodno();
        }
    }

    private void spojnoComboActions(JComboBox spojnoCombo, String[] naredbe) {
        if (spojnoCombo.getSelectedItem().toString() == naredbe[0]) {
            ukljuciDalekovodnoS1();
        }
        if (spojnoCombo.getSelectedItem().toString() == naredbe[1]) {
            ukljuciDalekovodnoS2();
        }
        if (spojnoCombo.getSelectedItem().toString() == naredbe[2]) {
            prespojiUkljucenoDalekovodnoNaS1();
        }
        if (spojnoCombo.getSelectedItem().toString() == naredbe[3]) {
            prespojiUkljucenoDalekovodnoNaS2();
        }
        if (spojnoCombo.getSelectedItem().toString() == naredbe[4]) {
            iskljuciDalekovodnoSpojenoNaS1();
        }
        if (spojnoCombo.getSelectedItem().toString() == naredbe[5]) {
            iskljuciDalekovodnoSpojenoNaS2();
        }
        if (spojnoCombo.getSelectedItem().toString() == naredbe[6]) {
            FrameSpojno frameSpojno = new FrameSpojno();
        }
    }

    public static void main(String[] args) {
        postrojenje = new Postrojenje();
        JPanel panel = new JPanel();
        postrojenje.add(panel);

        Graphics g = panel.getGraphics();
        panel.paint(g);
    }
}
