package unit7;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class ServerLog {
    public static Logger infoLogger = Logger.getLogger("BasicInfo");
    public static Logger errorLogger = Logger.getLogger("Error Message");
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(13);
            Socket connection = server.accept();
            connection.close();
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
