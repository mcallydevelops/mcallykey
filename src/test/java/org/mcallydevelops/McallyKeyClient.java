package org.mcallydevelops;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class McallyKeyClient {

    private final ObjectMapper objectMapper;
    public McallyKeyClient() {
        this.objectMapper = new ObjectMapper();
    }

    public Result retrieveRecord(String ip, int port, int key) throws IOException {
        Socket socket = new Socket(ip, port);
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println(objectMapper.writeValueAsString(new AuthRequest("username", "password")));
        clientIn.readLine();
        printWriter.println(objectMapper.writeValueAsString(new IntegerQuery(key, Operation.RETRIEVE)));
        String result = clientIn.readLine();
        socket.close();
        return objectMapper.readValue(result, Result.class);
    }

}
