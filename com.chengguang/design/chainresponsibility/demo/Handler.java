package design.chainresponsibility.demo;

/**
 * 抽象处理者
 */
public abstract class Handler {
    protected Handler successor;

    abstract void handleRequest();

    Handler getSuccessor(){
        return successor;
    }

    void setSuccessor(Handler successor){
        this.successor = successor;
    }
}
