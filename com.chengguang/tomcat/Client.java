package tomcat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端 模拟请求
 */
public class Client {
    private static int port = 5228;
    private static String host = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("请输入URL地址：");
            Scanner scanner = new Scanner(System.in);
            String info = scanner.nextLine().trim();
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(info);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
