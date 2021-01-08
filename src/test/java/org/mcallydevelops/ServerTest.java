package org.mcallydevelops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    static Thread serverThread;
    McallyKeyClient mcallyKeyClient;

    @BeforeAll
    static void beforeAll() throws IOException {
        serverThread = new Thread(new Server(Context.createDefaultContext()));
        serverThread.start();
    }

    @BeforeEach
    void setup() throws IOException {
        mcallyKeyClient = new McallyKeyClient();
    }

    @Test
    void run() throws IOException {
        Result result = mcallyKeyClient.retrieveRecord("localhost", 8080, 20);
        assertNotNull(result.getItem());
    }

    @AfterAll
    static void afterAll() {
        serverThread.stop();
    }

}