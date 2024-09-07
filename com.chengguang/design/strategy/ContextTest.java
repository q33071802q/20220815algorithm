package design.strategy;

public class ContextTest{
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyAdd());
//        int result = context.executeStrategy(1, 2);
        context.setStrategy(new ConcreteStrategyMultiply());
        context.setStrategy(new ConcreteStrategySubtract());
        int result = context.executeStrategy(1, 2);
        System.out.println(result);
    }
}

class Context{
    private Strategy strategy;
    public int executeStrategy(int a,int b){
        return strategy.execute(a,b);
    }
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

interface Strategy {
    int execute(int a,int b);
}

class ConcreteStrategyAdd implements Strategy{
    @Override
    public int execute(int a, int b) {
        return a+b;
    }
}

class ConcreteStrategySubtract implements Strategy{
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}


class ConcreteStrategyMultiply implements Strategy{
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
