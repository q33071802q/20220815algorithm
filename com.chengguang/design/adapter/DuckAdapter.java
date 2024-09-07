package design.adapter;

public class DuckAdapter{
    public static void main(String[] args) {
//        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(wildTurkey);

        wildTurkey.gobble();
        turkeyAdapter.quack();
    }
}

class TurkeyAdapter implements Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}

interface Duck {
    public void quack();
    public void fly();
}

class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("WildTurkey gobble");
    }

    @Override
    public void fly() {

    }
}

class MallardDuck implements Duck{

    @Override
    public void quack() {
        System.out.println("MallardDuck quack");
    }

    @Override
    public void fly() {

    }
}

interface Turkey{
    void gobble();
    void fly();
}
