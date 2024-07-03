import java.io.*;
import java.net.Socket;

public class RWClient {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 6667);
             DataOutputStream dout = new DataOutputStream(client.getOutputStream());
             DataInputStream din = new DataInputStream(client.getInputStream());
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String s1 = "", s2 = "";

            while (!s1.equals("q")) {
                System.out.print("Enter message for server: ");
                s2 = reader.readLine();
                dout.writeUTF(s2);
                dout.flush();

                s1 = din.readUTF();
                System.out.println("Server says: " + s1);
            }
            dout.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
