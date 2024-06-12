import java.net.*;

public class GetAllByName {
    public static void main(String[] args) {
        try {
            InetAddress []addresses = InetAddress.getAllByName("www.geeksforgeeks.org");
            for(InetAddress address:addresses){
                System.err.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}
