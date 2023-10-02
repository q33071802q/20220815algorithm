package tomcat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端 模拟接收请求
 * 对于tomcat而言 并不知道我们会有什么方法，只有部署到webapp下面才确定，由此分析，必然使用了Java的反射来
 * 实现类的动态加载、实例化、获取方法、调用方法。所以部署进Tomcat的web项目必须是按照规定好的接口进行便携才能调用
 * 决定调用什么方法 确定于客户端的请求
 */
public class TomcatTest {
    private static int port = 5228;
    private static UrlUtil urlUtil = new UrlUtil();

    public static void main(String[] args) {
        System.out.println("my Tomcat is Running");
        try {
            ServerSocket server = new ServerSocket(port);
            //服务端开始死循环接收请求
            while (true) {
                //服务器每接收一个请求，就创建一个socket对象
                Socket socket = server.accept();
                //读取请求写入的信息
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String info = "";
                String infoLine = br.readLine();
                while (infoLine != null) {
                    info += infoLine;
                    infoLine = br.readLine();
                }
                UrlBean url = urlUtil.readString(info);
                if (url != null) {
                    String path = url.getPath();
                    String className = url.getFileName();
                    String methodName = url.getParameter().trim();
                    //先获取类加载器 再通过反射调用某个类的某个方法
                    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                    try {
                        classLoader.loadClass(path+"."+className);
                        Class<?> getClass = Class.forName(path + "." + className);
                        try {
                            Method method = getClass.getMethod(methodName, null);
                            try {
                                method.invoke(getClass.newInstance(),null);
                            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                                throw new RuntimeException(e);
                            }
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
