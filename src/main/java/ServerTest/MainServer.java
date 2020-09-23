package ServerTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("Start Server");
        try {
            ServerSocket serverSocket = new ServerSocket(9000);

            while (true){
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new ClientSocket(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
