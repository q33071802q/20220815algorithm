package thinkjava;

import com.sun.glass.ui.Size;

/**
 * 泛型类型擦除
 * @param <T>
 */
public class Erased<T> {
    private final int SIZE = 100;
//    public static void f(Object arg){
//        if (arg instanceof T){}
//        T var = new T();
//        T[] array = new T[SIZE];
//        T[] array = (T)new Object[SIZE];
//    }
}
