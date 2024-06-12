
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class ProtocolTester {


    public static void tester(String url_raw){
        try {
            URI uri = new URI(url_raw);
            URL url = uri.toURL();
            System.out.println(url.getProtocol()+" is supported");
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (URISyntaxException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] urls = {
            "http://adc.com",
            "https://example.com",
            "file:///C:/Users/sujan/OneDrive/Pictures/Screenshots/Screenshot%202024-06-09%20224649.png"
        };
        for (String url : urls) {
            tester(url);
        }
    }
}
