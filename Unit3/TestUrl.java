
import java.net.*;

//  Write a java program to test working of URL class
public class TestUrl {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.nagarjunacollege.edu.np/");
            URL url = uri.toURL();
            System.out.println("port : " + url.getPort());
            System.out.println("protocol :" + url.getProtocol());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
