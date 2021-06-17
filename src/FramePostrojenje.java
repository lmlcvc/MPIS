import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Objects;

public class FramePostrojenje extends JFrame implements IScenariji {
    public static FramePostrojenje postrojenje;
    public static FrameDalekovodno frameDalekovodno;
    public static FrameSpojno frameSpojno;

    static DalekovodnoPolje dalekovodnoPolje;
    static SpojnoPolje spojnoPolje;

    private static JLabel labelMain;

    private JButton buttonDV;
    private JButton buttonSP;
    private JButton buttonSignali;

    private JComboBox<String> dalekovodnoCombo;
    private JComboBox<String> signaliCombo;


    public FramePostrojenje() {
        dalekovodnoPolje = new DalekovodnoPolje();
        spojnoPolje = new SpojnoPolje();

        setLayout(null);
        setSize(1000, 1000);
        this.setTitle("Postrojenje");
        setVisible(true);

        initTexts();
        initButtons();
        initCombos();
    }


    @Override
    public void ukljuciDalekovodnoS1() {
   if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == EnumStanjePrekidacRastavljac.UKLJUCEN) {
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

        if (FramePostrojenje.dalekovodnoPolje.rastavljacS2.stanje == EnumStanjePrekidacRastavljac.UKLJUCEN) {
            labelMain.setText("Dalekovodno polje je već uključeno na S2");
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
        if (FramePostrojenje.dalekovodnoPolje.rastavljacS1.stanje == EnumStanjePrekidacRastavljac.UKLJUCEN) {
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
        if (FramePostrojenje.dalekovodnoPolje.rastavljacS2.stanje == EnumStanjePrekidacRastavljac.UKLJUCEN) {
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
            dalekovodnoPolje.prekidac.iskljuci();
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
    }

    @Override
    public void prespojiNaS2() {
        if (FramePostrojenje.dalekovodnoPolje.ukljuceno) {
            spojnoPolje.ukljuci(spojnoPolje);
            dalekovodnoPolje.prekidac.iskljuci();
            dalekovodnoPolje.rastavljacS2.ukljuci(dalekovodnoPolje);
            dalekovodnoPolje.rastavljacS1.iskljuci(dalekovodnoPolje);
            dalekovodnoPolje.prekidac.ukljuci(dalekovodnoPolje);
            spojnoPolje.iskljuci();

            labelMain.setText("Dalekovodno polje prespojeno na S2");
            System.out.println("PRESPAJANJE: Dalekovodno polje prespojeno na S1");
        } else {
            labelMain.setText("Nemoguće prespojiti, dalekovodno polje je isključeno");
            System.out.println("PRESPAJANJE: Nemoguće prespojiti, dalekovodno polje je isključeno");
        }
    }

    private void initCombos() {
        String[] naredbe = {"Uključi sistem sabirnica 1", "Uključi sistem sabirnica 2",
                "Prespoji na S1", "Prespoji na S2",
                "Isključi sistem sabirnica 1", "Isključi sistem sabirnica 2", "Prikaz"};
        String[] signaliOdabir = {"Svi trenutni signali", "Signali DV", "Signali SP",
                "Signali prekidača", "Signali rastavljača na S1", "Signali rastavljača na S2",
                "Signali izlaznog rastavljača", "Signali rastavljača uzemljenja"};

        dalekovodnoCombo = new JComboBox<>(naredbe);
        dalekovodnoCombo.setBounds(225, 500, 200, 30);
        dalekovodnoCombo.setVisible(false);
        add(dalekovodnoCombo);
        dalekovodnoCombo.addActionListener(actionEvent -> dalekovodnoComboActions(dalekovodnoCombo, naredbe));

        signaliCombo = new JComboBox<>(signaliOdabir);
        signaliCombo.setSize(250, 30);
        signaliCombo.setLocation(50, 630);
        add(signaliCombo);
        signaliCombo.addActionListener(actionEvent -> signaliComboActions(signaliCombo, signaliOdabir));
    }

    private void initTexts() {
        labelMain = new JLabel();
        labelMain.setBounds(50, 550, 500, 20);
        add(labelMain);

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

        buttonSignali = new JButton();
        buttonSignali.setText("Prikaz signala");
        buttonSignali.setSize(250, 30);
        buttonSignali.setLocation(50, 600);
        add(buttonSignali);

        addButtonClickListeners();
    }

    private void addButtonClickListeners() {
        buttonDV.addActionListener(actionEvent ->
                dalekovodnoCombo.setVisible(!dalekovodnoCombo.isVisible()));

        buttonSP.addActionListener(actionEvent -> frameSpojno = new FrameSpojno());

        buttonSignali.addActionListener(actionEvent -> signaliCombo.setVisible(true));
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
            if(frameDalekovodno != null){
                SwingUtilities.updateComponentTreeUI(frameDalekovodno);
                FrameDalekovodno.initButtonTexts();
            }
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[1])) {
            ukljuciDalekovodnoS2();
            if(frameDalekovodno != null){
                SwingUtilities.updateComponentTreeUI(frameDalekovodno);
                FrameDalekovodno.initButtonTexts();
            }
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[2])) {
            prespojiNaS1();
            if(frameDalekovodno != null){
                SwingUtilities.updateComponentTreeUI(frameDalekovodno);
                FrameDalekovodno.initButtonTexts();
            }
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[3])) {
            prespojiNaS2();
            if(frameDalekovodno != null){
                SwingUtilities.updateComponentTreeUI(frameDalekovodno);
                FrameDalekovodno.initButtonTexts();
            }
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[4])) {
            iskljuciDalekovodnoSpojenoNaS1();
            if(frameDalekovodno != null){
                SwingUtilities.updateComponentTreeUI(frameDalekovodno);
                FrameDalekovodno.initButtonTexts();
            }
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[5])) {
            iskljuciDalekovodnoSpojenoNaS2();
            if(frameDalekovodno != null){
                SwingUtilities.updateComponentTreeUI(frameDalekovodno);
                FrameDalekovodno.initButtonTexts();
            }
        }
        if (dalekovodnoCombo.getSelectedItem().toString().equals(naredbe[6])) {
            frameDalekovodno = new FrameDalekovodno();
        }
    }

    private String getSviTrenutniSignali() {
        return dalekovodnoPolje.prekidac.posaljiTrenutneSignalePrekidaca() +
                dalekovodnoPolje.rastavljacS1.posaljiTrenutneSignaleRastavljaca() +
                dalekovodnoPolje.rastavljacS2.posaljiTrenutneSignaleRastavljaca() +
                dalekovodnoPolje.rastavljacIzlazni.posaljiTrenutneSignaleRastavljaca() +
                dalekovodnoPolje.rastavljacUzemljenja.posaljiTrenutneSignaleRastavljaca() +
                dalekovodnoPolje.distantnaZastita.posaljiTrenutneSignaleDistantne() +
                dalekovodnoPolje.nadstrujnaZastita.posaljiTrenutneSignaleNadstrujne() +
                dalekovodnoPolje.apu.posaljiTrenutneSignaleAPU() +
                dalekovodnoPolje.mprs.posaljiTrenutniSignalMPRS() +
                dalekovodnoPolje.mpn.posaljiTrenutniSignalMPN() +
                dalekovodnoPolje.brojilo.posaljiTrenutneSignaleBrojila() +
                System.lineSeparator() +
                spojnoPolje.prekidac.posaljiTrenutneSignalePrekidaca() +
                spojnoPolje.rastavljacS1.posaljiTrenutneSignaleRastavljaca() +
                spojnoPolje.rastavljacS2.posaljiTrenutneSignaleRastavljaca() +
                spojnoPolje.rastavljacIzlazni.posaljiTrenutneSignaleRastavljaca() +
                spojnoPolje.rastavljacUzemljenja.posaljiTrenutneSignaleRastavljaca();
    }

    private void signaliComboActions(JComboBox<String> signaliCombo, String[] odabir) {
        String selection = Objects.requireNonNull(signaliCombo.getSelectedItem()).toString();

        StringBuilder listSignali = new StringBuilder();

        if (selection.equals(odabir[0])) {
            listSignali.setLength(0);
            listSignali.append(getSviTrenutniSignali());
            new FrameSignali(listSignali.toString(), "Svi trenutni signali");

        } else if (selection.equals(odabir[1])) {

            listSignali.setLength(0);
            listSignali.append(dalekovodnoPolje.prekidac.posaljiSignalePrekidaca());
            listSignali.append(dalekovodnoPolje.rastavljacS1.posaljiSignaleRastavljaca());
            listSignali.append(dalekovodnoPolje.rastavljacS2.posaljiSignaleRastavljaca());
            listSignali.append(dalekovodnoPolje.rastavljacIzlazni.posaljiSignaleRastavljaca());
            listSignali.append(dalekovodnoPolje.rastavljacUzemljenja.posaljiSignaleRastavljaca());
            listSignali.append(dalekovodnoPolje.distantnaZastita.posaljiSignaleDistantne());
            listSignali.append(dalekovodnoPolje.nadstrujnaZastita.posaljiSignaleNadstrujne());
            listSignali.append(dalekovodnoPolje.apu.posaljiSignaleAPU());

            listSignali.append(dalekovodnoPolje.mprs.posaljiSignaleMPRS());
            listSignali.append(dalekovodnoPolje.mpn.posaljiSignaleMPN());
            listSignali.append(dalekovodnoPolje.brojilo.posaljiSignaleBrojila());

            new FrameSignali(listSignali.toString(), "Signali dalekovodnog polja");

        } else if (selection.equals(odabir[2])) {
            // signali sp
            listSignali.setLength(0);
            listSignali.append(spojnoPolje.prekidac.posaljiSignalePrekidaca());
            listSignali.append(spojnoPolje.rastavljacS1.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacS2.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacIzlazni.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacUzemljenja.posaljiSignaleRastavljaca());

            new FrameSignali(listSignali.toString(), "Signali spojnog polja");

        } else if (selection.equals(odabir[3])) {
            listSignali.setLength(0);

            listSignali.append(dalekovodnoPolje.prekidac.posaljiSignalePrekidaca());
            listSignali.append(spojnoPolje.prekidac.posaljiSignalePrekidaca());

            new FrameSignali(listSignali.toString(), "Signali prekidača");

        } else if (selection.equals(odabir[4])) {
            listSignali.setLength(0);

            listSignali.append(dalekovodnoPolje.rastavljacS1.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacS1.posaljiSignaleRastavljaca());

            new FrameSignali(listSignali.toString(), "Signali rastavljača S1");

        } else if (selection.equals(odabir[5])) {
            listSignali.setLength(0);

            listSignali.append(dalekovodnoPolje.rastavljacS2.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacS2.posaljiSignaleRastavljaca());

            new FrameSignali(listSignali.toString(), "Signali rastavljača S2");

        } else if (selection.equals(odabir[6])) {
            listSignali.setLength(0);

            listSignali.append(dalekovodnoPolje.rastavljacIzlazni.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacIzlazni.posaljiSignaleRastavljaca());

            new FrameSignali(listSignali.toString(), "Signali izlaznog rastavljača");

        } else if (selection.equals(odabir[7])) {
            listSignali.setLength(0);

            listSignali.append(dalekovodnoPolje.rastavljacUzemljenja.posaljiSignaleRastavljaca());
            listSignali.append(spojnoPolje.rastavljacUzemljenja.posaljiSignaleRastavljaca());

            new FrameSignali(listSignali.toString(), "Signali rastavljača uzemljenja");

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
