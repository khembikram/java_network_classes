
import java.net.*;

//  Write a java program to test working of URL class
public class TestUrl {

    public static void main(String[] args) {
        try {
            String test_url = args[0]; // get the command line URL 
            URI uri = new URI(test_url);
            // URI uri = new URI("https://www.nagarjunacollege.edu.np/");
            URL url = uri.toURL();
            System.out.println("port : " + url.getPort());
            System.out.println("protocol :" + url.getProtocol());
            System.out.println("path :" + url.getPath());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
