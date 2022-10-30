package thinkjava;

class BasicCoffee {
    private static long counter = 0;
    private final long id = counter++;
    private String value;
    public void set(String value){
        this.value = value;
    }
    public String get(){
        return value;
    }
    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }
}

class Decorator extends BasicCoffee{
    protected BasicCoffee basicCoffee;
    public Decorator(BasicCoffee basicCoffee) {
        this.basicCoffee = basicCoffee;
    }
    public void set(String val) { basicCoffee.set(val); }
    public String get() { return basicCoffee.get(); }
}

class SteamedMilk extends Decorator {
    private final String steamedMilk = "steamedMilk";
    public SteamedMilk(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getSteamedMilk() { return steamedMilk; }
}


class Foam extends Decorator {
    private final String foam = "foam";
    public Foam(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getFoam() { return foam; }
}

class Chocolate extends Decorator {
    private final String chocolate = "chocolate";
    public Chocolate(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getChocolate() { return chocolate; }
}

class Caramel extends Decorator {
    private final String caramel = "caramel";
    public Caramel(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getCaramel() { return caramel; }
}

class WhippedCream extends Decorator {
    private final String whippedCream = "whippedCream";
    public WhippedCream(BasicCoffee basicCoffee) {
        super(basicCoffee);
    }
    public String getWhippedCream() { return whippedCream; }
}

public class CoffeeDecoration{
    public static void main(String[] args) {
        new SteamedMilk(new BasicCoffee());
    }
}