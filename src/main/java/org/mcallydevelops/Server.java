package org.mcallydevelops;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private final Context context;
    private boolean running;

    public Server(Context context) {
        this.context = context;
        this.running = true;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(context.getConfiguration().getPort());
            ExecutorService threadPool = Executors.newFixedThreadPool(context.getConfiguration().getNumberOfThreads());
            while (running) {
                Runnable task = new NetworkQueryRequestHandler(serverSocket.accept(), context.getIntegerDataEngine(), context.getAuthenticationHandler());
                threadPool.submit(task);

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
