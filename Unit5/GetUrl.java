
import java.io.IOException;
import java.net.*;

// java program to print url  string in urlconnection
public class GetUrl {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://en.wikipedia.org/wiki/Nepal");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            System.out.println("Configured URL: " + conn.getURL().toString());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
}
