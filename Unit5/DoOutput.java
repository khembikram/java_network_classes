
import java.io.*;
import java.net.*;

public class DoOutput {

    public static void main(String[] args) {
        try {
            URI uri = new URI("http://example.com"); // Use a valid URI
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);

            try (OutputStream raw = conn.getOutputStream(); OutputStream buffered = new BufferedOutputStream(raw); Writer out = new OutputStreamWriter(buffered, "8859_1")) {
                out.write("name=Khememail");
                out.flush();
            }
        } catch (URISyntaxException ex) {
            System.out.println("Invalid URI: " + ex.getMessage());
        } catch (MalformedURLException ex1) {
            System.out.println("Invalid URL: " + ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println("I/O Error: " + ex2.getMessage());
        }
    }
}
