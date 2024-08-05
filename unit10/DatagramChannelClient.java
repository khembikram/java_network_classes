package unit10;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
    public static void main(String[] args) {
        try {
            // Create a DatagramChannel and connect it to the server
            DatagramChannel clientChannel = DatagramChannel.open();
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", 9999);

            String message = "Hello, server!";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(message.getBytes());
            buffer.flip();

            // Send message to the server
            clientChannel.send(buffer, serverAddress);
            System.out.println("Message sent to the server: " + message);

            // Receive response from the server
            buffer.clear();
            clientChannel.receive(buffer);
            buffer.flip();

            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Response from server: " + response);

            clientChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
