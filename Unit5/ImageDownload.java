import java.io.*;
import java.net.*;

public class ImageDownload {

    public static void downloadImage(URL url) {
        try {
            URLConnection conn = url.openConnection(); 
            conn.connect(); 

            if (conn.getContentLength() == -1) {
                throw new IOException("Content not found");
            } else {
                System.out.println("Content Length: " + conn.getContentLength());

                try (InputStream in = conn.getInputStream();
                     FileOutputStream out = new FileOutputStream("downloaded_image.webp")) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Image downloaded successfully.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://t4.ftcdn.net/jpg/00/82/84/73/360_F_82847366_8q84TVJVOYpTvGx4wrD3lbSwWlIrMseK.webp");
            URL url = uri.toURL();
            downloadImage(url);
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception: " + e.getMessage());
        }
    }
}
