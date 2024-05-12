package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyHttpServer {
    public static void main(String[] args) throws IOException {
        int port = 8000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("启动服务，绑定端口：" + port);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(30);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("新的连接"
                    + clientSocket.getInetAddress() + ":" +
                    clientSocket.getPort());
            try {
                fixedThreadPool.execute(new SocketHandler(clientSocket));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
