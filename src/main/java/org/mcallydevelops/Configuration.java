package org.mcallydevelops;

public class Configuration {

    private final int port;
    private final int numberOfThreads;

    public Configuration(int port, int numberOfThreads) {
        this.port = port;
        this.numberOfThreads = numberOfThreads;
    }

    public static Configuration loadDefaultConfiguration() {
        return new Configuration(8080, 5);
    }

    public int getPort() {
        return port;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }
}
