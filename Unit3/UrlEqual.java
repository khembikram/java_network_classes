
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlEqual {

    public static void main(String[] args) {
        try {
            URI uri = new URI("http://www.testingmcafeesites.com/index.html");
            URL url = uri.toURL();

            uri = new URI("http:///www.testingmcafeesites.com");
            URL url2 = uri.toURL();

            if (url.equals(url2)) {
                System.out.println("They both are equal");
            } else {
                System.out.println("They are different URL");
            }
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
