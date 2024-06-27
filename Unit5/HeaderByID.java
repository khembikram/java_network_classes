
import java.io.*;
import java.net.*;

public class HeaderByID {

    public static void main(String[] args) {
        int i = 1;
        try {
            URI uri = new URI("https://www.geeksforgeeks.org/");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            
            while (true) {
                String header = conn.getHeaderField(i);
                if(header == null) 
                    break; 
                System.out.println(conn.getHeaderFieldKey(i) + " : " + header);
                i = i + 1;
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex1) {
            System.out.println(ex1.getMessage());
        }
    }
}
