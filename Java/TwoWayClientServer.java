import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {

    private static final int port = 9090;

    public static void main(String[] args) throws IOException {

        // Create our Server Socket which will be accepted by our client socket
        // We can then get input and send output streams via our client socket
        // Wrap our grabber in a try catch and break once we receive the right message
        // Remember to close out of all resources

        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for connection...");

        Socket client = server.accept();
        System.out.println("Connected");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        try {
            while (true) {
                String request = in.readLine();
                if (request.contains("name")) {
                    out.println("Success");
                    break;
                } else {
                    out.println("Try again, type 'name'");
                }
            }
        } finally {
            out.close();
            in.close();
        }

        System.out.println("Disconnected");
        client.close();
        server.close();

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocket {

    public static void main(String[] args) throws IOException {

        // Client opens TCP/IP connection to a server, which opens communication
        // When client is finished, we close the connection
        // A socket is the combination of an IP address and a port number (device + specific app)
        // Use 127.0.0.1 default IP

        String ip = "127.0.0.1";
        int port = 9090;
        Socket socket = new Socket(ip, port);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while(true) {
            System.out.println("> ");
            String command = keyboard.readLine();

            if(command.equalsIgnoreCase("quit")) break;
            out.println(command);

            String response = input.readLine();
            System.out.println("Server: " + response);
        }

        socket.close();
        System.exit(0);
    }
}
