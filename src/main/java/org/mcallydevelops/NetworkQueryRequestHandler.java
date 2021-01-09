package org.mcallydevelops;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkQueryRequestHandler implements Runnable {

    private Socket socket;
    private String connectionPhase;
    private boolean running;
    private final IntegerDataEngine integerDataEngine;
    private final AuthenticationHandler authenticationHandler;
    private final ObjectMapper objectMapper;

    public NetworkQueryRequestHandler(Socket socket, IntegerDataEngine integerDataEngine, AuthenticationHandler authenticationHandler) {
        this.socket = socket;
        this.integerDataEngine = integerDataEngine;
        this.authenticationHandler = authenticationHandler;
        this.objectMapper = new ObjectMapper();
        this.running = true;
        this.connectionPhase = "init";
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            while(running) {
                String nextPhase = null;
                if("init".equals(connectionPhase)) {
                    String request = bufferedReader.readLine();
                    AuthResponse authResponse = authenticationHandler.handleAuthentication(request);
                    printWriter.println(objectMapper.writeValueAsString(authResponse));
                    if(!"success".equals(authResponse.getResponse())) {
                        cleanup();
                    } else {
                        nextPhase = "queryRequest";
                    }
                } else if("queryRequest".equals(connectionPhase)){
                    String request = bufferedReader.readLine();
                    Result result = integerDataEngine.query(request);
                    String response = objectMapper.writeValueAsString(result);
                    printWriter.println(response);
                    nextPhase = "close";
                } else if("close".equals(connectionPhase)) {
                    cleanup();
                }
                this.connectionPhase = nextPhase;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void cleanup() throws IOException {
        this.running = false;
        socket.close();
    }
}
