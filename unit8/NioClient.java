package unit8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClient {
    public static void main(String[] args) throws IOException {
        // Open a non-blocking socket channel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        // Connect to the server
        socketChannel.connect(new InetSocketAddress("localhost", 5000));

        // Wait until the connection is complete
        while (!socketChannel.finishConnect()) {
            // Wait for the connection to be established
        }

        System.out.println("Connected to the server. Type messages to send:");

        // Allocate a buffer for reading/writing data
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Read input from the user and send it to the server
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            // Write the message to the server
            buffer.clear();
            buffer.put(message.getBytes());
            buffer.flip();
            socketChannel.write(buffer);

            // Read the response from the server
            buffer.clear();
            int bytesRead = socketChannel.read(buffer);
            if (bytesRead > 0) {
                buffer.flip();
                System.out.println("Received from server: " + new String(buffer.array(), 0, bytesRead));
            }
        }

        // Close the channel and exit
        socketChannel.close();
        System.out.println("Client closed.");
    }
}
