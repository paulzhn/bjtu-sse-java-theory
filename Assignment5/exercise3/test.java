import javax.swing.*;
import java.awt.*;

public class test {
    static private int WIDTH = 420;

    /** Window height in pixels */
    static private int HEIGHT = 320;
    public static void main(String[] args) {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        panel.add(new JLabel("Code: "), c);

        JTextField textField;
        textField = new JTextField(50);
        c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 0.2;
        c.fill = GridBagConstraints.BOTH;

        JTextField code = new JTextField();
        c.weightx = 1;
        c.gridwidth = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(code, c);





        /*
        JButton resultButton = new JButton("0");
        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(4,4);
        panel.setLayout(gridLayout);

        //add buttons
        String [] buttonNames = new String []{"7", "8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        for (String string : buttonNames) {
            panel.add(new JButton(string));
        }
        //config resultButton
        resultButton.setSize(200, 50);
        resultButton.setHorizontalAlignment(SwingConstants.RIGHT);
        resultButton.setEnabled(false);
        */
        JFrame frame = new JFrame("Catalog Gourmet Coffee");

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
