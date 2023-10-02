package tomcat;

public class UrlBean {
    private String protocol;
    private String host;
    private String port;
    private String path;
    private String fileName;
    private String parameter;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public UrlBean(String protocol, String host, String port, String path, String fileName, String parameter) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.path = path;
        this.fileName = fileName;
        this.parameter = parameter;
    }

    public UrlBean() {
    }
}
