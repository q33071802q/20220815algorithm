package http;

import java.io.*;
import java.net.Socket;

public class SocketHandler implements Runnable{
    final static String CRLF = "\r\n"; //空行 区分请求行和请求数据之间
    private Socket clientSocket;

    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void handleSocket(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
        String requestHeader = "";
        String s;
        while ((s = in.readLine())!=null){
            s+=CRLF;
            requestHeader+=s;
            if (s.equals(CRLF)){ //结束
                break;
            }
        }
        System.out.println("客户端请求头：");
        System.out.println(requestHeader);

        String responseBody = "客户端的请求头是："+requestHeader;
        String responseHeader = "HTTP/1.0 200 OK\r\n" +
                "Content-Type:text/plain;charset=UTF-8\r\n" +
                "Content-Length:" +responseBody.getBytes().length+"\r\n"+
                "\r\n";
        System.out.println("响应头：");
        System.out.println(responseHeader);

        out.write(responseHeader);
        out.write(responseBody);
        out.flush();

        out.close();
        in.close();
        clientSocket.close();
    }

    @Override
    public void run() {
        try {
            handleSocket(clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
