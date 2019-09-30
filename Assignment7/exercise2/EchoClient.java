import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * EchoClient 客户端。
 *
 * @author paul
 * @since 2019/9/30
 */
public class EchoClient extends JFrame implements Runnable {
    private JLabel label;
    private JTextField lineQuantity;
    private JButton sendBtn;
    private JTextArea message;
    /**
     * 用来连接服务器。
     */
    private Socket socket;
    /**
     * 用来向socket的流中写入数据。
     */
    private PrintStream printer;
    /**
     * 用来读取socket流中的数据。
     */
    private BufferedReader reader;
    /**
     * 判断是否到达服务器文件末尾，如果是，就置为true。
     */
    private boolean flag = false;

    public EchoClient() {
    }

    public static void main(String[] args) {
        new EchoClient().run();
    }

    /**
     * 创建GUI
     */
    private void createGUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        label = new JLabel("Please input the number of string lines to get from server: ");
        c.gridwidth = 3;
        add(label, c);

        lineQuantity = new JTextField(10);
        c.weightx = 1;
        c.gridwidth = 1;
        add(lineQuantity, c);

        sendBtn = new JButton("send to server");
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(lineQuantity.getText());
                // 发送需要获得的行数
                printer.println(number);
                lineQuantity.setText("");
                try {
                    String tmp = reader.readLine();
                    // 如果还未到达末尾（flag为true）
                    if (!flag && !tmp.contains("no more lines")) {
                        message.append("get " + number + " line(s) from the server\n");
                    }
                    message.append(tmp + "\n");
                    if (tmp.contains("no more lines")) {
                        message.append("can not take lines anymore\n");
                        flag = true;
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        c.weighty = 0.1;
        c.gridwidth = 0;
        c.weightx = 0;
        add(sendBtn, c);

        message = new JTextArea(40, 20);
        message.setEditable(false);
        c.weighty = 1;
        c.weightx = 1;
        add(message, c);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 400));

        setVisible(true);


    }

    @Override
    public void run() {
        try {
            socket = new Socket("localhost", 4448);
            printer = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            createGUI();

        } catch (IOException e) {
            // 如果连接失败，弹error
            JOptionPane.showMessageDialog(null, "Cannot connect to server!", "error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
