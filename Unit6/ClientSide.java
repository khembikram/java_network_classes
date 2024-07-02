
import java.io.IOException;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",6667);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
