package thinkjava;

import algorithm.sort.In;

class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind){
        try {
            x = kind.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee{}

public class InstantiateGenericType{
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        //报错了
    }
}
