import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

// Download a webpage using URLConnection

public class DownloadPage {
    public static void main(String[] args) {
        try {
            int ch;
            URI uri = new URI("https://example.com");
            URL url = uri.toURL();
            URLConnection conn =  url.openConnection();
            InputStream in = conn.getInputStream();
            while((ch = in.read()) != -1) {
                System.out.println((char)ch);
            }
            System.out.println();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex){
            System.out.println(ex.getMessage());
        } catch (IOException ex2){
            System.out.println(ex2.getMessage());
        }
    }
}
