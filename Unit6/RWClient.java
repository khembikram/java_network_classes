import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RWClient {
    public static void main(String[] args) {
          try {
            Socket client = new Socket("localhost",6667);
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
