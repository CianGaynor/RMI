package Part2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String [] args) throws IOException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), 8000);
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
        String[] arr = sentence.split(" ");
        String firstWord = arr[0];

        if (firstWord.equals("Bob")) {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        }else {
            System.out.println("Question must start with BOB");
        }
    }
}
