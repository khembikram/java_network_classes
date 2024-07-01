
import java.io.*;
import java.net.*;

public class DoOutput {

    public static void main(String[] args) {
        try {
            URI uri = new URI("");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStream raw = conn.getOutputStream();
            OutputStream buffered = new BufferedOutputStream(raw);
        } catch (MalformedURLException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
}
