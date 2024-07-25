package unit7;

import java.net.*;

public class TimeOut {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(0);
            ss.setSoTimeout(100);
            int timeout = ss.getSoTimeout();
            if (timeout == 0) {
                System.out.println("Server wait infitely");
            } else {
                System.out.println("Server wait for " + timeout + "ms");
            }
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
