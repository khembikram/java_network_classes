
import java.net.URI;

public class URLdemo {

    public static void main(String[] args) {
        String[] urls = {"tel: +1-800-9988-9938", "http://www.xml.com/pub/a/2003/09/17/stax.html#if=_hbc", "urn:isbn:1-565-92870-9"};

        try {
            for (String raw_url : urls) {
                URI uri = new URI(raw_url);
                System.out.println(uri.getHost());
                System.out.println(uri.getPath());
                System.out.println(uri.getScheme());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
