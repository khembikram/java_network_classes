import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ComponentParts {
    public static void main(String[] args) {
        try {
            // URI uri = new URI("http://www.testingmcafeesites.com/index.html");
            // http://www.testingmcafeesites.com/testcat_al.html
            URI uri = new URI("http", "www.testingmcafeesites.com", "/testcat_al.html", null);
            URL url = uri.toURL();
            System.out.println("HOST: " + url.getHost());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
