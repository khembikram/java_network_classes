import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class StreamTester {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            URI uri = new URI("https://example.com/");
            URL url = uri.toURL();
            in = url.openStream();
            int data = in.read();
            while (data != -1) {
                System.out.print((char) data);
                data = in.read();
            }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
