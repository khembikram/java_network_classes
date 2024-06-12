import java.net.*;

public class IpByDomain {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.khembikram.com.np");
            // prints ipaddress of the domain
            System.out.println(address);
            // Address IP
            System.out.println("Address:" + address.getHostAddress());
            // Host Ip
            System.out.println("Name:" + address.getHostAddress() );
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
