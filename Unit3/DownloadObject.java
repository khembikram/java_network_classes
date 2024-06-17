
import java.io.IOException;
import java.net.*;

public class DownloadObject {
    public static void main(String[] args) {
        try {
            URI uri = new  URI(args[0]);
            URL url = uri.toURL();
            Object ob = url.getContent();
            System.out.println(ob.getClass());
            System.out.println(ob.toString());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch(MalformedURLException e1){
            System.out.println(e1.getMessage());
        } catch(IOException e2){
            System.out.println(e2.getMessage());
        }
    }
}
