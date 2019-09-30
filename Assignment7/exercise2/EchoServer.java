import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * EchoServer 服务端。
 *
 * @author paul
 * @since 2019/9/30
 */
public class EchoServer implements Runnable {
    ServerSocket serverSocket;
    BufferedReader fileReader;

    public EchoServer() {
        try {
            fileReader = new BufferedReader(new FileReader("multiLines.txt"));
            serverSocket = new ServerSocket(4448);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new EchoServer().run();
    }

    private String getLine(int number) {
        StringBuilder result = new StringBuilder();
        try {
            for (int i = 0; i < number; i++) {
                String tmp;
                if ((tmp = fileReader.readLine()) != null) {
                    result.append(tmp).append(" ## ");
                } else {
                    result.append("no more lines ##");
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("wait for client request");
            try {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    int number = Integer.parseInt(reader.readLine());
                    String result = getLine(number);
                    PrintStream printer = new PrintStream(socket.getOutputStream());
                    printer.println(result);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
