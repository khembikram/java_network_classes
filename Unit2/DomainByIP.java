package Unit2;

import java.net.*;

public class DomainByIP {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("195.35.10.213");
            System.out.println("Name: " + address.getHostName()); 
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        }
    }

}
