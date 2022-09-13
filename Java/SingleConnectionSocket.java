import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {

    private static final int port = 9090;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(port);

        System.out.println("Waiting for connection...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Message:");
        String text = sc.nextLine();

        Socket client = server.accept();
        System.out.println("Connected");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println(text);


        System.out.println("Disconnected");
        client.close();
        server.close();

    }
}

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocket {

    public static void main(String[] args) throws IOException {

        // Client opens TCP/IP connection to a server, which opens communication
        // When client is finished, we close the connection
        // A socket is the combination of an IP address and a port number (device + specific app)

        String ip = "127.0.0.1";
        int port = 9090;
        Socket socket = new Socket(ip, port);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = input.readLine();
        JOptionPane.showMessageDialog(null, response);

        socket.close();
        System.exit(0);
    }
}
