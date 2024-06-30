// check if read operation is allowed in url

import java.io.*;
import java.net.*;

public class ifmofified {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://vipleague.im/football/argentina-vs-peru-streaming-link-1");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            System.out.println("if mofified since " + conn.getIfModifiedSince());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
}
