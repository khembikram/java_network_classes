// java program to get basic server information 
package unit7;
import java.net.*;
import java.io.*;

public class ServerInfo {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(0);
            System.out.println("Assigned Port no. : " + ss);
            System.out.println("Running on IP Address : " + ss.getInetAddress() );
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
