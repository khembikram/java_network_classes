
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {

    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        for (String arg : args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known Spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String arg) throws UnknownHostException {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            System.err.println(query);
            InetAddress.getByName(query);
            return true;
        } catch(UnknownHostException e)  {
            return false;
        }

    }
}
