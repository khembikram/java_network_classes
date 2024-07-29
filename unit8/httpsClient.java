// Implement secure client socket using secure socket factory
package unit8;

import java.io.*;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class httpsClient {
    public static void main(String[] args) {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = null;
        try {
            socket = (SSLSocket) factory.createSocket("www.usps.com", 443);
            String[] Suites = socket.getEnabledCipherSuites();
            for (String string : Suites) {
                System.out.println(string);
            }
            System.out.println("Supported Cipher Suites");
            String[] supportedSuites = socket.getSupportedCipherSuites();
            for (String suite : supportedSuites) {
                System.out.println(suite);
            }

            socket.setEnabledCipherSuites(supportedSuites);
            InputStream reader = socket.getInputStream();
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
