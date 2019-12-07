package Part2;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BobServer {
    private static int port = 8000;

    public static void main(String[] args) throws Exception {
        try (ServerSocket listener = new ServerSocket(port)) {
            System.out.println("The Searcher server is running...");
            ExecutorService pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Searcher(listener.accept()));
            }
        }
    }
}
