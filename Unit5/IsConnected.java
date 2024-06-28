import java.io.*;
import java.net.*;

public class IsConnected {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://en.wikipedia.org/wiki/Nepal");
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            if (isConnected(conn)) {
                System.out.println("Connected");
            } else {
                System.out.println("Not connected");
            }
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException ex1) {
            System.out.println(ex1.getMessage());
        } catch (IOException ex2) {
            System.out.println(ex2.getMessage());
        }
    }

    public static boolean isConnected(URLConnection conn) {
        try {
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            if (inputStream != null) {
                inputStream.close();
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
