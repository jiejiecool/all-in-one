package org.example;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Data
public class MyServer {
    private int port;

    public MyServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            Socket client = serverSocket.accept();
            InputStream inputStream = client.getInputStream();
            byte[] arr = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(arr)) != -1) {

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
