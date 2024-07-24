package unit7;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

public class ClientLog {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 13);
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
