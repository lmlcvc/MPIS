import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FrameSpojno extends JFrame {

    private static JButton rastavljacS1Button;
    private static JButton rastavljacS2Button;
    private static JButton rastavljacIzlazniButton;
    private static JButton rastavljacUzemljenjaButton;
    private static JButton prekidacButton;

    public FrameSpojno() {
        setLayout(null);
        setSize(700, 1000);
        this.setTitle("Spojno polje");
        setVisible(true);

        JPanel panel = new JPanel();
        this.add(panel);
        Graphics g = panel.getGraphics();
        panel.paint(g);

        this.initButtons();
        initButtonTexts();
        addButtonClickListeners();

        this.initLabels();
    }

    public void initLabels(){
        JLabel labelS2 = new JLabel();
        labelS2.setText("Sistem II");
        labelS2.setBounds(15, 50, 85, 15);
        add(labelS2);

        JLabel labelS1 = new JLabel();
        labelS1.setText("Sistem I");
        labelS1.setBounds(15, 100, 85, 15);
        add(labelS1);
    }

    public void initButtons() {
        rastavljacS1Button = new JButton();
        rastavljacS1Button.setBounds(125, 200, 150, 50);
        add(rastavljacS1Button);

        rastavljacS2Button = new JButton();
        rastavljacS2Button.setBounds(425, 200, 150, 50);
        add(rastavljacS2Button);

        rastavljacIzlazniButton = new JButton();
        rastavljacIzlazniButton.setBounds(250, 375, 200, 50);
        add(rastavljacIzlazniButton);

        rastavljacUzemljenjaButton = new JButton();
        rastavljacUzemljenjaButton.setBounds(50, 433, 200, 50);
        add(rastavljacUzemljenjaButton);

        prekidacButton = new JButton();
        prekidacButton.setBounds(250, 300, 200, 50);
        add(prekidacButton);
    }

    private static void addButtonClickListeners() {
        prekidacButton.addActionListener(actionEvent -> {
            // isključivanje prekidača
            if (FramePostrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
                FramePostrojenje.spojnoPolje.prekidac.iskljuci();
            } else if (FramePostrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) { // uključivanje prekidača - provjere
                FramePostrojenje.spojnoPolje.prekidac.ukljuci(FramePostrojenje.spojnoPolje);
            }

            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });

        rastavljacS1Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if (FramePostrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.spojnoPolje.rastavljacS1.ukljuci(FramePostrojenje.spojnoPolje);
            } else if (FramePostrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                FramePostrojenje.spojnoPolje.rastavljacS1.iskljuci(FramePostrojenje.spojnoPolje);
            }

            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });

        rastavljacS2Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if (FramePostrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.spojnoPolje.rastavljacS2.ukljuci(FramePostrojenje.spojnoPolje);
            } else if (FramePostrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                FramePostrojenje.spojnoPolje.rastavljacS2.iskljuci(FramePostrojenje.spojnoPolje);
            }

            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });

        rastavljacIzlazniButton.addActionListener(actionEvent -> {
            // isključen - uključi
            if (FramePostrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.spojnoPolje.rastavljacIzlazni.ukljuci(FramePostrojenje.spojnoPolje);
            } else if (FramePostrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                FramePostrojenje.spojnoPolje.rastavljacIzlazni.iskljuci(FramePostrojenje.spojnoPolje);
            }
            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });
    }

    private static void initButtonTexts() {
        if (FramePostrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacS1Button.setText("Rastavljač S1: 1");
        } else {
            rastavljacS1Button.setText("Rastavljač S1: 0");
        }

        if (FramePostrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacS2Button.setText("Rastavljač S2: 1");
        } else {
            rastavljacS2Button.setText("Rastavljač S2: 0");
        }

        if (FramePostrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 1");
        } else {
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 0");
        }

        if (FramePostrojenje.spojnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 1");
        } else {
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 0");
        }

        if (FramePostrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            prekidacButton.setText("Prekidač: 1");
        } else {
            prekidacButton.setText("Prekidač: 0");
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        Line2D lineSistem2 = new Line2D.Float(100, 100, 600, 100);
        g2.draw(lineSistem2);

        Line2D lineSistem1 = new Line2D.Float(100, 150, 600, 150);
        g2.draw(lineSistem1);

        Line2D lineRastavljacS1 = new Line2D.Float(200, 150, 200, 300);
        g2.draw(lineRastavljacS1);

        Line2D lineRastavljacS2 = new Line2D.Float(500, 100, 500, 300);
        g2.draw(lineRastavljacS2);

        Line2D spojnicaHor = new Line2D.Float(200, 300, 500, 300);
        g2.draw(spojnicaHor);

        Line2D spojnicaVer = new Line2D.Float(350, 300, 350, 600);
        g2.draw(spojnicaVer);

        Line2D spojnicaLeft = new Line2D.Float(150, 500, 350, 500);
        g2.draw(spojnicaLeft);
    }
}
