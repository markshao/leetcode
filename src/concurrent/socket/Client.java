package concurrent.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by mark on 2/19/14.
 */
public class Client {

    private ServerSocket serverSocket = null;
    private Socket socket;
    private int port;

    public Client(int port) {
        try {
            this.port = port;
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.exit(1);
        }
    }

    public void service() {
        while (true) {
            try {
                System.out.println("Client is listening on the " + this.port);
                socket = serverSocket.accept();
                ObjectInputStream is = new ObjectInputStream((socket.getInputStream()));
                List<String> strList = (List<String>) is.readObject();
                for (String str : strList) {
                    System.out.println(str);
                    Thread.sleep(2000);
                }

                socket.getOutputStream().write(10);
                socket.getOutputStream().flush();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client(5151);
        client.service();
    }

}
