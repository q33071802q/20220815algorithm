package design.adapter;

public class IteratorTest{
    public static void main(String[] args) {
        MyEnumerationIterator myEnumerationIterator = new MyEnumerationIterator(new IteratorMe());
        System.out.println(myEnumerationIterator.hasMoreElements());
    }
}

interface MyIterator {
    boolean hasNext();
    Object nextOne();
    boolean removeOne();
}

class IteratorMe implements MyIterator{
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object nextOne() {
        return null;
    }

    @Override
    public boolean removeOne() {
        return false;
    }
}



interface MyEnumeration{
    boolean hasMoreElements();
    Object nextElement();
}

class MyEnumerationIterator implements MyEnumeration{
    MyIterator myIterator;

    public MyEnumerationIterator(MyIterator myIterator) {
        this.myIterator = myIterator;
    }

    @Override
    public boolean hasMoreElements() {
        System.out.println("1");
        return myIterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return myIterator.nextOne();
    }
    public boolean removeOne() {
        throw new UnsupportedOperationException();
    }

}
