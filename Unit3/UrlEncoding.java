
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoding {
    public static void main(String[] args) {
        try {
            String encoded = URLEncoder.encode("What:is:Computer:Network?", "UTF-8");
            System.out.println("Encoded String :" +encoded);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }
}
