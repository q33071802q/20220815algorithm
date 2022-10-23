package design.chainresponsibility.application;

public class Client {
    public static void main(String[] args) {
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        String test1 = h3.handleFeeRequest("张三", 300);
        System.out.println("test1="+test1);

        String test2 = h3.handleFeeRequest("李四", 300);
        System.out.println("test2="+test2);

        String test3 = h3.handleFeeRequest("张三", 800);
        System.out.println("test3="+test3);

        String test4 = h3.handleFeeRequest("李四", 800);
        System.out.println("test4="+test4);
    }
}
