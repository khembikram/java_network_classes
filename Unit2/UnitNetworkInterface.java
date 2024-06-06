import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class UnitNetworkInterface {
    public static void main(String[] args) {
        Enumeration<NetworkInterface> interface = NetworkInterface.getNetworkInterfaces();
    }
}
