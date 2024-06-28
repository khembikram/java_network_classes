// check if read operation is allowed in url

import java.io.*;
import java.net.*;

public class CheckDoinput {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://en.wikipedia.org/wiki/Nepal");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            if (conn.getDoInput()) {
                System.out.println("Read Operation is allowed");
            } else {
                System.out.println("Read Operation is not allowed");
                conn.setDoInput(true);
            }

            if (conn.getDoInput()) {
                System.out.println("Read Operation is allowed");
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
