package design.template.thinkjava;

public abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();
}

class X{}

class Creator extends GenericWithCreate<X>{

    @Override
    X create() {
        return new X();
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

class CreatorGeneric{
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
