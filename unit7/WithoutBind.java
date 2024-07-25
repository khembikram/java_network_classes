// java program to create server socket without binding
package unit7;

import java.net.*;
import java.io.*;

public class WithoutBind {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket();
            SocketAddress http = new InetSocketAddress(80);
            ss.bind(http);
            System.out.println("Connected to port 80");
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
