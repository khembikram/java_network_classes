
import java.io.*;
import java.net.*;

public class RwServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6667);
            Socket server = ss.accept();
            // din and dout for socket read and write
            DataInputStream din = new DataInputStream(server.getInputStream());
            DataOutputStream dout = new DataOutputStream(server.getOutputStream());
            // read from standard input device
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String s1="" ,s2="";
            while(!s1.equals("q")){
                s1 = din.readUTF();
                System.out.println("Client says: " + (String) s1 );

                s2 = reader.readLine();
                dout.writeUTF(s2);
            }

            // din close
            ss.close();
            System.out.println("Connection Established");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
