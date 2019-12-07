package Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Searcher implements Runnable {
    private Socket socket;

    Searcher(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Connected: " + socket);
        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (in.hasNextLine()) {
                out.println(searchFile());
            }
        } catch (Exception e) {
            System.out.println("Error:" + socket);
        } finally {
            try { socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Closed: " + socket);
        }
    }

    public String searchFile(){
        try {
            File myObj = new File("Part2/answers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                return myReader.nextLine();
            }

    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

