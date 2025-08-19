package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

@Slf4j
public class MyClient {

    private String host;
    private int port;

    private Socket socket;

    public MyClient setRemoteServer(String remoteIp, int remotePort) {
       this.host = remoteIp;
       this.port = remotePort;
       return this;
    }

    public static void main(String[] args) throws IOException {
        MyClient client = new MyClient().setRemoteServer("localhost", 8888);
        client.connect();
        client.sendMsg("你好啊");

    }
    public void connect() throws IOException {
        this.socket = new Socket(host, port);
    }

    public void sendMsg(String msg) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(msg+"\n");
        bufferedWriter.flush();
        log.info("发送数据到服务端:{}",msg);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = bufferedReader.readLine();
        log.info("接收到服务端的响应:{}",result);
    }


}
