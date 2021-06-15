import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FrameDalekovodno extends JFrame {

    private static JButton rastavljacS1Button;
    private static JButton rastavljacS2Button;
    private static JButton rastavljacIzlazniButton;
    private static JButton rastavljacUzemljenjaButton;
    private static JButton prekidacButton;

    public FrameDalekovodno(DalekovodnoPolje dalekovodnoPolje) {
        setLayout(null);
        setSize(700, 1000);
        setVisible(true);

        JPanel panel = new JPanel();
        this.add(panel);
        Graphics g = panel.getGraphics();
        panel.paint(g);

        this.initButtons();
        this.initButtonTexts(dalekovodnoPolje);
        this.addButtonClickListeners(dalekovodnoPolje);
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

        prekidacButton = new JButton();
        prekidacButton.setText("Prekidač: ");
        prekidacButton.setBounds(250, 300, 200, 50);
        add(prekidacButton);

        rastavljacIzlazniButton = new JButton();
        rastavljacIzlazniButton.setText("Izlazni rast.: ");
        rastavljacIzlazniButton.setBounds(250, 375, 200, 50);
        add(rastavljacIzlazniButton);

        rastavljacUzemljenjaButton = new JButton();
        rastavljacUzemljenjaButton.setText("Rast. uzemljenja: ");
        rastavljacUzemljenjaButton.setBounds(50, 433, 200, 50);
        add(rastavljacUzemljenjaButton);

    }

    private static void addButtonClickListeners(DalekovodnoPolje dalekovodnoPolje){
        prekidacButton.addActionListener(actionEvent -> {
            // isključivanje prekidača
            if(dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN){
                dalekovodnoPolje.prekidac.iskljuci();
            } else if(dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN) { // uključivanje prekidača - provjere
                if((dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN
                || dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN )
                && dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN
                && dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN){
                    dalekovodnoPolje.prekidac.ukljuci();
                }
            }
            initButtonTexts(dalekovodnoPolje);
        });

        rastavljacS1Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if(dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                dalekovodnoPolje.rastavljacS1.ukljuci();
            } else if(dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // ili da S2 radi, ili da je prekidač isljučen
                if((dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN)
                || (dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN)){
                    dalekovodnoPolje.rastavljacS1.iskljuci();
                }
            }
            initButtonTexts(dalekovodnoPolje);
        });

        rastavljacS2Button.addActionListener(actionEvent -> {
            // isključen - uključi
            if(dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                dalekovodnoPolje.rastavljacS2.ukljuci();
            } else if(dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // ili da S1 radi, ili da je prekidač isljučen
                if((dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN)
                        || (dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN)){
                    dalekovodnoPolje.rastavljacS2.iskljuci();
                }
            }
            initButtonTexts(dalekovodnoPolje);
        });

        // TODO: koji rastavljač ovisi o kojem
        rastavljacUzemljenjaButton.addActionListener(actionEvent -> {
            // isključen - uključi
            if(dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                if(dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                    dalekovodnoPolje.rastavljacUzemljenja.ukljuci();
                }
            } else if(dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // prekidač mora biti isključen
                if(dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                    dalekovodnoPolje.rastavljacUzemljenja.iskljuci();
                }
            }
            initButtonTexts(dalekovodnoPolje);
        });

        rastavljacIzlazniButton.addActionListener(actionEvent -> {
            // isključen - uključi
            if(dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                dalekovodnoPolje.rastavljacIzlazni.ukljuci();
            } else if(dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN) { // uključen - provjera
                // prekidač mora biti isključen
                if(dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.ISKLJUCEN){
                    dalekovodnoPolje.rastavljacIzlazni.iskljuci();
                }
            }
            initButtonTexts(dalekovodnoPolje);
        });
    }

    private static void initButtonTexts(DalekovodnoPolje dalekovodnoPolje) {
        if (dalekovodnoPolje.rastavljacS1.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacS1Button.setText("Rastavljač S1: 1");
        } else {
            rastavljacS1Button.setText("Rastavljač S1: 0");
        }

        if (dalekovodnoPolje.rastavljacS2.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacS2Button.setText("Rastavljač S2: 1");
        } else {
            rastavljacS2Button.setText("Rastavljač S2: 0");
        }

        if (dalekovodnoPolje.rastavljacIzlazni.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 1");
        } else {
            rastavljacIzlazniButton.setText("Izlazni rastavljač: 0");
        }

        if (dalekovodnoPolje.rastavljacUzemljenja.stanje == StanjePrekidacRastavljac.UKLJUCEN){
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 1");
        } else {
            rastavljacUzemljenjaButton.setText("Rast. uzemljenja: 0");
        }

        if (dalekovodnoPolje.prekidac.stanje == StanjePrekidacRastavljac.UKLJUCEN){
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
