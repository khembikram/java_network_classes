import java.io.*;
import java.net.*;

public class ServerSide {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6667);
            ss.accept();
            System.out.println("Connection Established");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
