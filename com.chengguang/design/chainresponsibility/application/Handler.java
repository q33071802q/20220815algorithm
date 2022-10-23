package design.chainresponsibility.application;

public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    abstract String handleFeeRequest(String user, double fee);
}
