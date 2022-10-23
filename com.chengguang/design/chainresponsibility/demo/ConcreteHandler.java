package design.chainresponsibility.demo;

/**
 * 具体处理者
 */
public class ConcreteHandler extends Handler {

    @Override
    void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println("放过请求");
            getSuccessor().handleRequest();
        }
        else {
            System.out.println("处理请求");
        }
    }
}
