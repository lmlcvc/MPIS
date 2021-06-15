import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FrameSpojno extends JFrame {

    private static JButton rastavljacS1Button;
    private static JButton rastavljacS2Button;
    private static JButton rastavljacIzlazniButton;
    private static JButton rastavljacUzemljenjaButton;
    private static JButton prekidacButton;

    public FrameSpojno(SpojnoPolje spojnoPolje) {
        setLayout(null);
        setSize(700, 1000);
        setVisible(true);

        JPanel panel = new JPanel();
        this.add(panel);
        Graphics g = panel.getGraphics();
        panel.paint(g);

        this.initButtons();
    }

    public void initButtons() {
        rastavljacS1Button = new JButton();
        rastavljacS1Button.setText("Rastavljač S1: ");
        rastavljacS1Button.setBounds(125, 200, 150, 50);
        add(rastavljacS1Button);

        rastavljacS2Button = new JButton();
        rastavljacS2Button.setText("Rastavljač S2: ");
        rastavljacS2Button.setBounds(425, 200, 150, 50);
        add(rastavljacS2Button);

        rastavljacIzlazniButton = new JButton();
        rastavljacIzlazniButton.setText("Rastavljač izlazni: ");
        rastavljacIzlazniButton.setBounds(250, 300, 200, 50);
        add(rastavljacIzlazniButton);

        rastavljacUzemljenjaButton = new JButton();
        rastavljacUzemljenjaButton.setText("Rastavljač uzemljenja: ");
        rastavljacUzemljenjaButton.setBounds(250, 375, 200, 50);
        add(rastavljacUzemljenjaButton);

        prekidacButton = new JButton();
        prekidacButton.setText("Prekidač: ");
        prekidacButton.setBounds(50, 433, 150, 50);
        add(prekidacButton);

        // TODO: initButtonTexts
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
