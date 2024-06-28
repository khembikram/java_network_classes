// check if read operation is allowed in url

import java.io.*;
import java.net.*;

public class CheckDooutput {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://en.wikipedia.org/wiki/Nepal");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            if (conn.getDoOutput()) {
                System.out.println("Write Operation is allowed");
            } else {
                System.out.println("Write Operation is not allowed");
                conn.setDoOutput(true);
            }

            if (conn.getDoOutput()) {
                System.out.println("Write Operation is allowed");
            }
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
}
