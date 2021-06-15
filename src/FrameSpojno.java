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
        setVisible(true);

        JPanel panel = new JPanel();
        this.add(panel);
        Graphics g = panel.getGraphics();
        panel.paint(g);

        this.initButtons();
        initButtonTexts();
        addButtonClickListeners();
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

    private static void addButtonClickListeners(){
        prekidacButton.addActionListener(actionEvent -> {
            // isključivanje prekidača
            if(Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN){
                Postrojenje.spojnoPolje.prekidac.iskljuci();
            } else if(Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) { // uključivanje prekidača - provjere
                if((Postrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN
                        || Postrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN )
                        && Postrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN
                        && Postrojenje.spojnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN){
                    Postrojenje.spojnoPolje.prekidac.ukljuci();
                }
            }
            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(Postrojenje.postrojenje); // TODO: ovo valja?
        });

        rastavljacS1Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if(Postrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                Postrojenje.spojnoPolje.rastavljacS1.ukljuci();
            } else if(Postrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // ili da S2 radi, ili da je prekidač isljučen
                if((Postrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN)
                        || (Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN)){
                    Postrojenje.spojnoPolje.rastavljacS1.iskljuci();
                }
            }
            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(Postrojenje.postrojenje);
        });

        rastavljacS2Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if(Postrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                Postrojenje.spojnoPolje.rastavljacS2.ukljuci();
            } else if(Postrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // ili da S1 radi, ili da je prekidač isljučen
                if((Postrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN)
                        || (Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN)){
                    Postrojenje.spojnoPolje.rastavljacS2.iskljuci();
                }
            }
            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(Postrojenje.postrojenje);
        });

        // TODO: koji rastavljač ovisi o kojem
        rastavljacUzemljenjaButton.addActionListener(actionEvent -> {
            // isključen - uključi
            if(Postrojenje.spojnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                if(Postrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                    Postrojenje.spojnoPolje.rastavljacUzemljenja.ukljuci();
                }
            } else if(Postrojenje.spojnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // prekidač mora biti isključen
                if(Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                    Postrojenje.spojnoPolje.rastavljacUzemljenja.iskljuci();
                }
            }
            initButtonTexts();
            SwingUtilities.updateComponentTreeUI(Postrojenje.postrojenje);
        });

        rastavljacIzlazniButton.addActionListener(actionEvent -> {
            // isključen - uključi
            if(Postrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                Postrojenje.spojnoPolje.rastavljacIzlazni.ukljuci();
            } else if(Postrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // prekidač mora biti isključen
                if(Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                    Postrojenje.spojnoPolje.rastavljacIzlazni.iskljuci();
                }
            }
            initButtonTexts();
        });
    }

    private static void initButtonTexts() {
        if (Postrojenje.spojnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacS1Button.setText("Rastavljač S1: 1");
        } else {
            rastavljacS1Button.setText("Rastavljač S1: 0");
        }

        if (Postrojenje.spojnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacS2Button.setText("Rastavljač S2: 1");
        } else {
            rastavljacS2Button.setText("Rastavljač S2: 0");
        }

        if (Postrojenje.spojnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 1");
        } else {
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 0");
        }

        if (Postrojenje.spojnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 1");
        } else {
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 0");
        }

        if (Postrojenje.spojnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN){
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
