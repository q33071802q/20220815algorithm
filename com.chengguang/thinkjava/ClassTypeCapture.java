package thinkjava;

import javafx.util.Builder;

import java.util.HashMap;
import java.util.Map;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    Map<String, Class<?>> mapType;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Map<String, Class<?>> mapType) {
        this.mapType = mapType;
    }

    public boolean addType(String typename, Class<?> kind) {
        return mapType.put(typename, kind) != null;
    }

    public Class<?> createNew(String typename) {
        return mapType.get(typename);
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> htt1 = new ClassTypeCapture<>(House.class);
        System.out.println(htt1.f(new Building()));
        System.out.println(htt1.f(new House()));

        Map<String, Class<?>> map = new HashMap<>();
        ClassTypeCapture<Map<String, Class<?>>> mapClassTypeCapture = new ClassTypeCapture<Map<String, Class<?>>>(map);
        mapClassTypeCapture.addType("gou",House.class);
        Class<?> gou = mapClassTypeCapture.createNew("gou");
        System.out.println(gou);
        System.out.println(mapClassTypeCapture.f(new HashMap<String, Class<?>>()));
    }
}
