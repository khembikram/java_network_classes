import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressType {
    public static void main(String[] args) {
        String test_address = args[0];
        try {
            InetAddress address  = InetAddress.getByName(test_address);
            if (address.isLoopbackAddress()) {
                System.err.println(test_address + "Is Loop Back Address");
            }
            if(address.isAnyLocalAddress()) {
                System.err.println(test_address + "Is wild Card Address");
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}
