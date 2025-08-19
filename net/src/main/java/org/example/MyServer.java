package org.example;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Data
public class MyServer {
    private int port;

    public MyServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new MyServer(8888).start();
    }

    public void start() {
        try {
            log.info("开启服务器....");
            ServerSocket serverSocket = new ServerSocket(port);
            Socket client = serverSocket.accept();
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                log.info("读取到数据:{}", s);
                OutputStream outputStream = client.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write("我已经收到你的消息了\n");
                bufferedWriter.flush();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
