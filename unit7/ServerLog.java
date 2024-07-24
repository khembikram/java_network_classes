package unit7;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerLog {
    public static Logger infoLogger = Logger.getLogger("BasicInfo");
    public static Logger errorLogger = Logger.getLogger("Error Message");

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(13);
            Socket connection = server.accept();
            infoLogger.log(Level.INFO, "Connection Established with a client");
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() + "\r\n");
            out.flush();

            infoLogger.log(Level.INFO, "Date Written to stream");
            // System.out.println("Connection established");
            connection.close();
            server.close();
        } catch (IOException e) {
            errorLogger.log(Level.SEVERE, e.getMessage());
        }
    }
}
