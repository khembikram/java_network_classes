
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncoding {
    public static void main(String[] args) {
        try {
            String encoded = URLEncoder.encode("What:is:Computer:Network?", "UTF-8");
            System.out.println("Encoded String :" +encoded);
            String decoved = URLDecoder.decode(encoded, "UTF-8");
            System.out.println("Original String" + decoved);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }
}
