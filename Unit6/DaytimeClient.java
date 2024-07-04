import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        int ch;
        try {
            // Use the correct hostname and port for the daytime service
            Socket socket = new Socket("time.nist.gov", 13);
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            InputStream in = socket.getInputStream();
            while((ch = in.read()) != -1) {
                System.out.print((char) ch);
            }
            in.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
