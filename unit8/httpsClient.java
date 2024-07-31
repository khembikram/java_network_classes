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
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream());
                
                String s;
                while (!(s = in.readLine()).equals("")) {
                    System.out.println(s);
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
