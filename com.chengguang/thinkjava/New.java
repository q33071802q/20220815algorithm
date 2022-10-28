package thinkjava;

import java.util.*;

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<String> list = New.list();
        LinkedList<String> lls = New.lList();
        Set<String> set = New.set();
        Queue<String> qs = New.queue();
    }
}
