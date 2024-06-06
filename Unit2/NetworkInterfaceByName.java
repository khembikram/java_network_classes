
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceByName {

    public static void main(String[] args) throws SocketException {
        NetworkInterface eth0 = NetworkInterface.getByName("ethernet_0");
        Enumeration addresses = eth0.getInetAddresses();
        while (addresses.hasMoreElements()) {
            System.err.println(addresses.nextElement());
        }
    }
}
