import java.io.*;
import java.net.*;

public class ServerSide {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6667);
            Socket server = ss.accept();
            DataInputStream din = new DataInputStream(server.getInputStream());
            String msg = din.readUTF();
            System.out.println("Client says: " + (String) msg);
            ss.close();
            System.out.println("Connection Established");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
