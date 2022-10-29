package thinkjava;

interface FactoryIS<T> {
    T create();
}

 class Foo2<T> {
    private T x;

    public <F extends FactoryIS<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryIS<Integer>{

    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget{
    public static class Factory implements FactoryIS<Widget>{

        @Override
        public thinkjava.Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint{
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
