package design.strategy;

public class LoaderKV {

}

interface MyLoader<K,V>{
    V load(K key);
}

class MyCache<K,V>{
    private MyLoader<K,V> myLoader;

    public MyCache(MyLoader<K, V> myLoader) {
        this.myLoader = myLoader;
    }

    public V get(K k){
        return myLoader.load(k);
    }

    public static void main(String[] args) {
        MyCache<String, String> stringStringMyCache = new MyCache<>(new MyLoader<String, String>() {
            @Override
            public String load(String key) {
                return "abc";
            }
        });
        String d = stringStringMyCache.get("d");
        System.out.println(d);

        MyCache<Integer, Integer> stringStringMyCach2e =
                new MyCache<>(new MyLoader<Integer, Integer>() {
            @Override
            public Integer load(Integer key) {
                return 123;
            }
        });
        Integer de = stringStringMyCach2e.get(1);
        System.out.println(de);
    }
}
