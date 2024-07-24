package unit7;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;

public class ClientLog {
    public static void main(String[] args) {
        int ch;
        try {
            Socket socket = new Socket("localhost", 13);
            socket.setSoTimeout(15000);
            System.out.println(socket.toString());
            InputStream in = socket.getInputStream();
            // InputStreamReader reader = new InputStreamReader(in, 'ASCII');
            while ((ch = in.read()) != -1) {
                System.out.println((char) ch);
            }
            in.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
