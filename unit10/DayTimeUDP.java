package unit10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DayTimeUDP {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket
            DatagramSocket socket = new DatagramSocket(0);
            socket.setSoTimeout(10000);

            // Create a DatagramPacket to send the request
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, 13);

            // Create a DatagramPacket to receive the response
            DatagramPacket response = new DatagramPacket(new byte[4], 4); // Time protocol uses 4 bytes for response

            // Send the request
            socket.send(request);

            // Receive the response
            socket.receive(response);

            // Extract the time from the response (4 bytes)
            byte[] data = response.getData();

            // Convert the byte array to a 32-bit unsigned integer
            ByteBuffer buffer = ByteBuffer.wrap(data);
            buffer.order(ByteOrder.BIG_ENDIAN); // Ensure big-endian order
            long secondsSince1900 = buffer.getInt() & 0xFFFFFFFFL; // Convert to unsigned

            // Calculate the time since January 1, 1900 (Unix time starts from 1970)
            long secondsSince1970 = secondsSince1900 - 2208988800L; // 70 years in seconds
            Instant instant = Instant.ofEpochSecond(secondsSince1970);

            // Convert to LocalDateTime and format it
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Print the results
            System.out.println("Received date and time (UTC): " + dateTime.format(formatter));
            System.out.println("Current date and time (UTC): " + LocalDateTime.now(ZoneId.of("UTC")).format(formatter));
            
            // Close the socket
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
