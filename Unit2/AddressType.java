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
            if(address.isMulticastAddress()){
                System.err.println(test_address + "Is a multi-cast Address");
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}



// Loop Back Address :- AddressType 127.0.0.1
// Wild Card Address :- AddressType 0.0.0.0
// Wild Card Address :- AddressType 224.0.0.0