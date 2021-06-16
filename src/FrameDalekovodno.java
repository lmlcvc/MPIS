import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FrameDalekovodno extends JFrame {

    private static JButton rastavljacS1Button;
    private static JButton rastavljacS2Button;
    private static JButton rastavljacIzlazniButton;
    private static JButton rastavljacUzemljenjaButton;
    private static JButton prekidacButton;

    public FrameDalekovodno() {
        setLayout(null);
        setSize(700, 1000);
        this.setTitle("Dalekovodno polje");
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

    private void initLabels() {
        StringBuilder sb = new StringBuilder();
        sb.append("MPRS: ")
                .append(FramePostrojenje.dalekovodnoPolje.mprs.radnaSnaga)
                .append("MV");

        JLabel mprsLabel = new JLabel();
        mprsLabel.setText(sb.toString());
        mprsLabel.setBounds(300, 605, 175, 35);
        add(mprsLabel);

        sb.setLength(0);

        sb.append("MPN: ")
                .append(FramePostrojenje.dalekovodnoPolje.mpn.napon)
                .append("kVarh");

        JLabel mpnLabel = new JLabel();
        mpnLabel.setText(sb.toString());
        mpnLabel.setBounds(300, 645, 175, 35);
        add(mpnLabel);

        sb.setLength(0);

        sb.append("Brojilo: ")
                .append(FramePostrojenje.dalekovodnoPolje.brojilo.jalovaEnergija)
                .append("kV");

        JLabel brojiloLabel = new JLabel();
        brojiloLabel.setText(sb.toString());
        brojiloLabel.setBounds(300, 685, 175, 35);
        add(brojiloLabel);

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

        prekidacButton = new JButton();
        prekidacButton.setBounds(250, 300, 200, 50);
        add(prekidacButton);

        rastavljacIzlazniButton = new JButton();
        rastavljacIzlazniButton.setBounds(250, 375, 200, 50);
        add(rastavljacIzlazniButton);

        rastavljacUzemljenjaButton = new JButton();
        rastavljacUzemljenjaButton.setBounds(50, 433, 200, 50);
        add(rastavljacUzemljenjaButton);

        JButton zastitaDistantnaButton = new JButton();
        zastitaDistantnaButton.setText("Distantna zaštita");
        zastitaDistantnaButton.setBounds(50, 600, 175, 50);
        add(zastitaDistantnaButton);

        JButton zastitaNadstrujnaButton = new JButton();
        zastitaNadstrujnaButton.setText("Nadstrujna zaštita");
        zastitaNadstrujnaButton.setBounds(50, 675, 175, 50);
        add(zastitaNadstrujnaButton);

        JButton apuButton = new JButton();
        apuButton.setText("APU");
        apuButton.setBounds(50, 750, 175, 50);
        add(apuButton);
    }

    private static void addButtonClickListeners() {
        prekidacButton.addActionListener(actionEvent -> {
            if (FramePostrojenje.dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
                FramePostrojenje.dalekovodnoPolje.prekidac.iskljuci();
            } else if (FramePostrojenje.dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.dalekovodnoPolje.prekidac.ukljuci(FramePostrojenje.dalekovodnoPolje);
            }

            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });

        rastavljacS1Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.dalekovodnoPolje.rastavljacS1.ukljuci(FramePostrojenje.dalekovodnoPolje);
            } else if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                FramePostrojenje.dalekovodnoPolje.rastavljacS1.iskljuci(FramePostrojenje.dalekovodnoPolje);
            }

            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });

        rastavljacS2Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if (FramePostrojenje.dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.dalekovodnoPolje.rastavljacS2.ukljuci(FramePostrojenje.dalekovodnoPolje);
            } else if (FramePostrojenje.dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                FramePostrojenje.dalekovodnoPolje.rastavljacS2.iskljuci(FramePostrojenje.dalekovodnoPolje);
            }

            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });

        rastavljacIzlazniButton.addActionListener(actionEvent -> {
            // isključen - uključi
            if (FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.ukljuci(FramePostrojenje.dalekovodnoPolje);
            } else if (FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // prekidač mora biti isključen
                if (FramePostrojenje.dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) {
                    FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.iskljuci(FramePostrojenje.dalekovodnoPolje);
                }
            }
            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(FramePostrojenje.postrojenje);
        });
    }

    private static void initButtonTexts() {
        if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacS1Button.setText("Rastavljač S1: 1");
        } else {
            rastavljacS1Button.setText("Rastavljač S1: 0");
        }

        if (FramePostrojenje.dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacS2Button.setText("Rastavljač S2: 1");
        } else {
            rastavljacS2Button.setText("Rastavljač S2: 0");
        }

        if (FramePostrojenje.dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 1");
        } else {
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 0");
        }

        if (FramePostrojenje.dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 1");
        } else {
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 0");
        }

        if (FramePostrojenje.dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN) {
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
