package unit7;

import java.net.ServerSocket;

public class LocalPort {
    public static void main(String[] args) {
        int i;
        for (i = 1; i < 65535; i++) {
            try {
                ServerSocket socket = new ServerSocket(i);
                System.out.println("Connection extablished on port: " + i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
