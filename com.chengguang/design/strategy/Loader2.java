package design.strategy;

public class Loader2 {
}

interface Loader{
    Object load(String key);
}

class Cache{
    private Loader loader;

    public Cache(Loader loader) {
        this.loader = loader;
    }

    public Object get(String key){
        return loader.load(key);
    }

    public static void main(String[] args) {
        Cache cache = new Cache(new Loader() {
            @Override
            public Object load(String key) {
                return "load";
            }
        });
        Object abc = cache.get("abc");
        System.out.println(abc);
    }
}
