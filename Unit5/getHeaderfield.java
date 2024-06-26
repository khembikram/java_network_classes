import java.io.*;
import java.net.*;

public class getHeaderfield {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://annapurnapost.com");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            System.out.println("Content-ecoding" + conn.getHeaderField("content-encoding"));
            System.out.println("Content-length" + conn.getHeaderField("Content-length"));
            System.out.println("Content-Type" + conn.getHeaderField("content-type"));
            System.out.println("Expires: " + conn.getHeaderField("expires"));
            System.out.println("Date: " + conn.getHeaderField("date"));
            
            
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch(URISyntaxException ex){
            System.out.println(ex.getMessage());
        } catch(IOException ex1) {
            System.out.println(ex1.getMessage());
        }
    }    
}
