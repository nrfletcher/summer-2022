import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static final int port = 9090;
    // We create a thread pool of 4 threads max which we can use to terminate our loop
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(port);

        // Create our Server Socket which will be accepted by our client socket
        // We can then get input and send output streams via our client socket
        // Wrap our grabber in a try catch and break once we receive the right message
        // Remember to close out of all resources

        while (true) {
            System.out.println("Waiting for connection...");
            Socket client = server.accept();
            System.out.println("Connected");

            // Using our client handler to create a new thread (client) each time we connect
            // Add our client to our client list
            // Execute our thread (client) using our executor service
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);
            pool.execute(clientThread);
        }


    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private Socket socket;
    private BufferedReader reader;

    public ServerConnection(Socket socket1) throws IOException {
        socket = socket1;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        while(true) {
            String response = null;
            try {
                response = reader.readLine();
                System.out.println("Server says: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    // Let us use Runnable to create multithreading which is the solution to multiple clients
    // By using the implemented run() we will run this when a new thread (client) is created

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                if (request.contains("name")) {
                    out.println("Success");
                    break;
                } else if (request.startsWith("say")) {
                    int firstSpace = request.indexOf(" ");
                    if(firstSpace != -1) {
                        outToAll(request.substring(firstSpace + 1));
                    }
                } else {
                    out.println("Try again, type 'name'");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void outToAll(String string) {
        for(ClientHandler aClient : clients) {
            aClient.out.println(string);
        }
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
