import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket;
        System.out.println("Server is up and running, waiting to connect...");
        socket = serverSocket.accept();
        System.out.println("Successfully connected to client");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        Thread sender = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                while(true) {
                    message = scanner.nextLine();
                    if(message.equalsIgnoreCase("quit")) {
                        System.out.println("You have disconnected");
                        writer.println(message);
                        scanner.close();
                        writer.close();
                        scanner.close();
                        System.exit(0);
                    }
                    writer.println(message);
                    writer.flush();
                }
            }
        });
        sender.start();

        Thread receiver = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                try {
                    message = reader.readLine();
                    while(message != null) {
                        System.out.println("Client: " + message);
                        message = reader.readLine();
                        if(message.equalsIgnoreCase("quit")) {
                            System.out.println("Manually disconnecting client.");
                            writer.close();
                            reader.close();
                            scanner.close();
                            socket.close();
                            serverSocket.close();
                            System.exit(0);
                        }
                    }
                    System.out.println("Client has disconnected");
                    writer.close();
                    reader.close();
                    scanner.close();
                    socket.close();
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        receiver.start();

    }
}
