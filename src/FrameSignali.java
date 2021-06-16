import javax.swing.*;

public class FrameSignali extends JFrame {

    public FrameSignali(String signali, String naslov){
        setLayout(null);
        setSize(700, 700);
        this.setTitle(naslov);
        setVisible(true);

        JPanel panel = new JPanel();
        this.add(panel);

        JTextArea signaliArea = new JTextArea();
        signaliArea.setText(signali);
        signaliArea.setEditable(false);

        JScrollPane signaliScroll = new JScrollPane(signaliArea);
        signaliScroll.setSize(600, 550);
        signaliScroll.setLocation(50, 50);

        add(signaliScroll);
    }

}