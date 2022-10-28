package thinkjava;

import java.util.Arrays;

class Particle<K,V>{}

public class LostInformation {
    public static void main(String[] args) {
        Particle<String, Long> particle = new Particle<String, Long>();
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
    }
}
