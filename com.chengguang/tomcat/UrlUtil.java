package tomcat;

/**
 * http://127.0.0.1:8080/Test/Manage/index.jsp
 * 从请求中获取相关信息
 */
public class UrlUtil {
    public UrlBean readString(String info){
        UrlBean url = null;
        String protocol = info.substring(0,info.indexOf(":"));
        String host = info.substring(info.indexOf(":")+3,info.lastIndexOf(":"));
        String port = info.substring(info.lastIndexOf(":")+1,info.indexOf("/",info.lastIndexOf(":")));
        String path = info.substring(info.indexOf("/",info.lastIndexOf(":"))+1,info.lastIndexOf("/"));
        String fileName = info.substring(info.lastIndexOf("/")+1,info.lastIndexOf("."));
        String parameter = info.substring(info.indexOf("?")+1,info.trim().length());
        if (host!=null && path!=null && fileName!=null){
            if (protocol == null){
                protocol = "http";
            }
            if (port == null){
                port = "8080";
            }
            url = new UrlBean(protocol,host,port,path,fileName,parameter);
        }
        return url;
    }
}
