import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Objects;

public class FramePostrojenje extends JFrame implements IScenariji {
    public static FramePostrojenje postrojenje;

    static DalekovodnoPolje dalekovodnoPolje;
    static SpojnoPolje spojnoPolje;


    private static JLabel labelMain;
    private static JLabel labelSignaliDV;
    private static JLabel labelSignaliSP;

    private JButton buttonDV;
    private JButton buttonSP;
    private JButton buttonSignaliDV;
    private JButton buttonSignaliSP;
    private final JComboBox<String> dalekovodnoCombo;


    public FramePostrojenje() {
        dalekovodnoPolje = new DalekovodnoPolje();
        spojnoPolje = new SpojnoPolje();

        setLayout(null);
        setSize(1000, 1000);
        setVisible(true);

        initJLabels();
        initButtons();

        String[] naredbe = {"Uključi sistem sabirnica 1", "Uključi sistem sabirnica 2",
                "Prespoji na S1", "Prespoji na S2",
                "Isključi sistem sabirnica 1", "Isključi sistem sabirnica 2", "Prikaz"};
        dalekovodnoCombo = new JComboBox<>(naredbe);
        dalekovodnoCombo.setBounds(225, 500, 200, 50);
        dalekovodnoCombo.setVisible(false);
        add(dalekovodnoCombo);

        dalekovodnoCombo.addActionListener(actionEvent -> dalekovodnoComboActions(dalekovodnoCombo, naredbe));
    }


    // metode za rukovanje scenarijima
    // TODO: pametnije napraviti provjere?

    @Override
    public void ukljuciDalekovodnoS1() {
        // TODO: treba li provjera je li već uključeno?

        if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            labelMain.setText("Dalekovodno polje je već uključeno na S1");
        } else {
            FramePostrojenje.dalekovodnoPolje.prekidac.iskljuci();
            FramePostrojenje.dalekovodnoPolje.rastavljacUzemljenja.iskljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacS1.ukljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.prekidac.ukljuci(dalekovodnoPolje);
            labelMain.setText("Dalekovodno polje spojeno na S1 uključeno");
        }

        System.out.println("UKLJUČIVANJE: Dalekovodno polje spojeno na S1 uključeno");
    }

    @Override
    public void ukljuciDalekovodnoS2() {

        if (FramePostrojenje.dalekovodnoPolje.ukljuceno) {
            labelMain.setText("Dalekovodno polje je već uključeno");
        } else {
            FramePostrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacS2.ukljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.prekidac.ukljuci(dalekovodnoPolje);
            labelMain.setText("Dalekovodno polje spojeno na S2 uključeno");
        }
        System.out.println("UKLJUČIVANJE: Dalekovodno polje spojeno na S2 uključeno");
    }

    @Override
    public void iskljuciDalekovodnoSpojenoNaS1() {
        // TODO: provjera je li već isključeno
        // TODO: da li može biti spojeno i na s1 i na s2? treba li provjera?
        if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            FramePostrojenje.dalekovodnoPolje.prekidac.iskljuci();
            FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.iskljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacS1.iskljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci(dalekovodnoPolje);

            labelMain.setText("Dalekovodno polje spojeno na S1 isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje spojeno na S1 isključeno");
        } else {
            labelMain.setText("Dalekovodno polje nije spojeno na S1 i ne može biti isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje nije spojeno na S1 i ne može biti isključeno");
        }
    }

    @Override
    public void iskljuciDalekovodnoSpojenoNaS2() {
        if (FramePostrojenje.dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            FramePostrojenje.dalekovodnoPolje.prekidac.iskljuci();
            FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.iskljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacS2.iskljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacUzemljenja.ukljuci(dalekovodnoPolje);

            dalekovodnoPolje.prekidac.ukljuci(dalekovodnoPolje);

            labelMain.setText("Dalekovodno polje spojeno na S2 isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje spojeno na S2 isključeno");
        } else {
            labelMain.setText("Dalekovodno polje nije spojeno na S2 i ne može biti isključeno");
            System.out.println("ISKLJUČIVANJE: Dalekovodno polje nije spojeno na S2 i ne može biti isključeno");
        }
    }

    @Override
    public void prespojiNaS1() {
        if (FramePostrojenje.dalekovodnoPolje.ukljuceno) {
            spojnoPolje.ukljuci(spojnoPolje);
            dalekovodnoPolje.rastavljacS1.ukljuci(dalekovodnoPolje);
            dalekovodnoPolje.rastavljacS2.iskljuci(dalekovodnoPolje);
            dalekovodnoPolje.prekidac.ukljuci(dalekovodnoPolje);
            spojnoPolje.iskljuci();

            labelMain.setText("Dalekovodno polje prespojeno na S1");
            System.out.println("PRESPAJANJE: Dalekovodno polje prespojeno na S1");
        } else {
            labelMain.setText("Nemoguće prespojiti, dalekovodno polje je isključeno");
            System.out.println("PRESPAJANJE: Nemoguće prespojiti, dalekovodno polje je isključeno");
        }

        // TODO: što točno treba u provjeri?
    }

    @Override
    public void prespojiNaS2() {
        if (FramePostrojenje.dalekovodnoPolje.ukljuceno) {
            FramePostrojenje.spojnoPolje.ukljuci(spojnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacS2.ukljuci(dalekovodnoPolje);
            FramePostrojenje.dalekovodnoPolje.rastavljacS1.iskljuci(dalekovodnoPolje);
            dalekovodnoPolje.prekidac.ukljuci(dalekovodnoPolje);
            spojnoPolje.iskljuci();

            labelMain.setText("Dalekovodno polje prespojeno na S2");
            System.out.println("PRESPAJANJE: Dalekovodno polje prespojeno na S1");
        } else {
            labelMain.setText("Nemoguće prespojiti, dalekovodno polje je isključeno");
            System.out.println("PRESPAJANJE: Nemoguće prespojiti, dalekovodno polje je isključeno");
        }
    }

    private void initJLabels() {
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

        JLabel labelS2 = new JLabel();
        labelS2.setText("Sistem II");
        labelS2.setBounds(15, 50, 85, 15);
        add(labelS2);

        JLabel labelS1 = new JLabel();
        labelS1.setText("Sistem I");
        labelS1.setBounds(15, 100, 85, 15);
        add(labelS1);
    }

    private void initButtons() {
        buttonDV.setText("Dalekovodno polje");
        buttonDV.setBounds(225, 400, 200, 100);
        add(buttonDV);

        buttonSP.setText("Spojno polje");
        buttonSP.setBounds(525, 400, 200, 100);
        add(buttonSP);

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

    private void addButtonClickListeners() {
        buttonDV.addActionListener(actionEvent ->
                dalekovodnoCombo.setVisible(!dalekovodnoCombo.isVisible()));

        buttonSP.addActionListener(actionEvent -> new FrameSpojno());

        buttonSignaliDV.addActionListener(actionEvent -> labelSignaliDV.setText(getAllSignali(dalekovodnoPolje)));

        buttonSignaliSP.addActionListener(actionEvent -> labelSignaliSP.setText(getAllSignali(spojnoPolje)));
    }

    private String getAllSignali(Polje polje) {
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

    private void dalekovodnoComboActions(JComboBox<String> dalekovodnoCombo, String[] naredbe) {
        if (Objects.requireNonNull(dalekovodnoCombo.getSelectedItem()).toString().equals(naredbe[0])) {
            ukljuciDalekovodnoS1();
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[1])) {
            ukljuciDalekovodnoS2();
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[2])) {
            prespojiNaS1();
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[3])) {
            prespojiNaS2();
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[4])) {
            iskljuciDalekovodnoSpojenoNaS1();
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[5])) {
            iskljuciDalekovodnoSpojenoNaS2();
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[6])) {
            new FrameDalekovodno();
        }
    }

    public static void main(String[] args) {
        postrojenje = new FramePostrojenje();

        JPanel panel = new JPanel();
        postrojenje.add(panel);

        Graphics g = panel.getGraphics();
        panel.paint(g);
    }
}
