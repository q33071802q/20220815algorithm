package thinkjava;

public class Teller {
    private static long counter = 1;
    private final long id = counter++;

    private Teller() {
    }

    public String toString() {
        return "Teller" + id;
    }

    public Generator<Teller> generator =
            new Generator<Teller>() {
                @Override
                public Teller next() {
                    return new Teller();
                }
            };

    public static void main(String[] args) {
        thinkjava.Teller teller = new Teller();
        System.out.println(teller.generator);
        System.out.println(teller.generator);
    }

}
