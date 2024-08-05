package unit10;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServer {
    public static void main(String[] args) {
        try {
            // Create a DatagramChannel and bind it to port 9999
            DatagramChannel serverChannel = DatagramChannel.open();
            serverChannel.bind(new InetSocketAddress(9999));

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            System.out.println("Server is listening on port 9999...");

            while (true) {
                buffer.clear();
                InetSocketAddress clientAddress = (InetSocketAddress) serverChannel.receive(buffer);
                buffer.flip();

                String message = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Received from client: " + message);

                String response = "Server response: " + message;
                buffer.clear();
                buffer.put(response.getBytes());
                buffer.flip();

                serverChannel.send(buffer, clientAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
