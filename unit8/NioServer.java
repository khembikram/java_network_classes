package unit8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
    public static void main(String[] args) throws IOException {
        // Open a selector
        Selector selector = Selector.open();

        // Open a non-blocking server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        // Bind the channel's socket to a local address
        serverSocketChannel.socket().bind(new InetSocketAddress(5000));

        // Register the channel with the selector for accepting connections
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port 5000...");

        while (true) {
            // Select the keys for channels that are ready for I/O operations
            selector.select();

            // Get the selected keys
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                // Check if the key is acceptable (a connection is ready to be accepted)
                if (key.isAcceptable()) {
                    // Accept the connection and make it non-blocking
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);

                    // Register the new SocketChannel with the selector for reading
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    System.out.println("Accepted new connection from " + socketChannel.getRemoteAddress());
                }

                // Check if the key is readable (data is available to read)
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = socketChannel.read(buffer);

                    if (bytesRead > 0) {
                        buffer.flip();
                        System.out.println("Received: " + new String(buffer.array(), 0, bytesRead));

                        // Echo the received message back to the client
                        socketChannel.write(buffer);
                    } else if (bytesRead == -1) {
                        // Client closed the connection
                        System.out.println("Client disconnected: " + socketChannel.getRemoteAddress());
                        socketChannel.close();
                    }
                }

                keyIterator.remove(); // Remove the current key to avoid processing it again
            }
        }
    }
}
