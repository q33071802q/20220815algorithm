package design.strategy;

public class TestRobot{
    public static void main(String[] args) {
        Robot robot = new H5WechatRobot();
        robot.setChatBehavior(new StreamChat());
        robot.chat();
    }

}

abstract class Robot {
    ChatBehavior chatBehavior;
    abstract void chat();

    public void setChatBehavior(ChatBehavior chatBehavior) {
        this.chatBehavior = chatBehavior;
    }
}

class WechatRobot extends Robot{
    @Override
    void chat() {
        chatBehavior.perform();
    }
}

class H5WechatRobot extends Robot{
    @Override
    void chat() {
        chatBehavior.perform();
    }
}

interface ChatBehavior{
    void perform();
}

class BlockChat implements ChatBehavior{
    @Override
    public void perform() {
        System.out.println("block chat");
    }
}

class StreamChat implements ChatBehavior{
    @Override
    public void perform() {
        System.out.println("stream chat");
    }
}


