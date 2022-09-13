import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 9090);

        // We are sending (writing) our data into the output stream of our socket
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        // We are taking in (reading) data into our input stream using a stream reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Successfully connected");

        Scanner scanner = new Scanner(System.in);

        Thread sender = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                try {
                    while(true) {
                        message = scanner.nextLine();
                        if(checkIfClosed(message)) {
                            System.out.println("You have disconnected");
                            scanner.close();
                            writer.close();
                            reader.close();
                            socket.close();
                            System.exit(0);
                        }
                        writer.println(message);
                        writer.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
                        if(checkIfClosed(message)) {
                            System.out.println("Server is disconnecting you");
                            scanner.close();
                            writer.close();
                            reader.close();
                            socket.close();
                            System.exit(0);
                        }
                        System.out.println("Server: " + message);
                        message = reader.readLine();
                        if(checkIfClosed(message)) {
                            System.out.println("Server is disconnecting you");
                            scanner.close();
                            writer.close();
                            reader.close();
                            socket.close();
                            System.exit(0);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        receiver.start();

    }

    public static boolean checkIfClosed(String message) {
        if(message.equalsIgnoreCase("quit")) return true;
        return false;
    }
}
