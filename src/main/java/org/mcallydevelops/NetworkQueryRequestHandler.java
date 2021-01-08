package org.mcallydevelops;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkQueryRequestHandler implements Runnable {

    private Socket socket;
    private final IntegerDataEngine integerDataEngine;
    private final ObjectMapper objectMapper;

    public NetworkQueryRequestHandler(Socket socket, IntegerDataEngine integerDataEngine) {
        this.socket = socket;
        this.integerDataEngine = integerDataEngine;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            String query = bufferedReader.readLine();
            Result resultObject = integerDataEngine.query(query);
            printWriter.println(objectMapper.writeValueAsString(resultObject));
            socket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
