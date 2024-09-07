package design.strategy;


public class MiniDuck{
    public static void main(String[] args) {
        Duck mallDuck = new MallDuck();
        mallDuck.performFly();
        mallDuck.setFlyBehavior(new FlyWithWings());
        mallDuck.performFly();
    }

}

abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    void swim(){}
    abstract void display();
    void performQuack(){
        quackBehavior.quack();
    }
    void performFly(){
        flyBehavior.fly();
    }
    void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }
}

class MallDuck extends Duck{

    public MallDuck() {
        this.setFlyBehavior(new FlyNoWay());
        this.setQuackBehavior(new MuteQuack());
    }

    @Override
    void display() {

    }

    @Override
    void performQuack() {

    }

    @Override
    void performFly() {
        this.getFlyBehavior().fly();
    }
}


class RedDuck extends Duck{

    @Override
    void display() {

    }

    @Override
    void performQuack() {

    }

    @Override
    void performFly() {

    }
}


class RubberDuck extends Duck{

    @Override
    void display() {

    }

    @Override
    void performQuack() {

    }

    @Override
    void performFly() {

    }
}


class DecoyDuck extends Duck{

    @Override
    void display() {

    }

    @Override
    void performQuack() {

    }

    @Override
    void performFly() {

    }
}

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("FlyWithWings");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("flyNoWay");
    }
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quack");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("MuteQuack");
    }
}

interface QuackBehavior {
    void quack();
}


