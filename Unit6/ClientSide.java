
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSide {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 6667);
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            DataInputStream din = new DataInputStream(client.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String s1 = "", s2 = "";
            while (!s1.equals(s2)) {
                s1 = din.readUTF();
                System.out.println("Server says: " + s1);

                s2 = reader.readLine();
                dout.writeUTF(s2);
                dout.flush();
            }

            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
