
import java.io.*;
import java.net.*;

public class UserInteraction {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://en.wikipedia.org/wiki/Nepal");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            if (conn.getAllowUserInteraction()) {
                System.out.println("User Interaction is allowed");
            } else {
                System.out.println("User interaction is not allowed");
                conn.setAllowUserInteraction(true);
            }

            if (conn.getAllowUserInteraction()) {
                System.out.println("User Interaction is allowed");
            } else {
                System.out.println("User interaction is not allowed");
                conn.setAllowUserInteraction(true);
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
