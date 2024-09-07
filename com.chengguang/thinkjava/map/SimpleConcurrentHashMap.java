package thinkjava.map;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.ReentrantLock;  
  
public class SimpleConcurrentHashMap<K, V> {  
    private final Node<K, V>[] table;  
    private final int capacity;  
    private final float loadFactor;  
    private final AtomicIntegerArray countArray;  
    private int size;  
  
    private static class Node<K, V> {  
        final K key;  
        V value;  
        Node<K, V> next;  
  
        Node(K key, V value, Node<K, V> next) {  
            this.key = key;  
            this.value = value;  
            this.next = next;  
        }  
    }  
  
    public SimpleConcurrentHashMap(int capacity, float loadFactor) {  
        this.capacity = capacity;  
        this.loadFactor = loadFactor;  
        this.table = new Node[capacity];  
        this.countArray = new AtomicIntegerArray(capacity);  
        this.size = 0;  
    }  
  
    public V put(K key, V value) {  
        int index = hash(key) % capacity;  
        Node<K, V> newNode = new Node<>(key, value, null);  
        Node<K, V> oldHead = table[index];  
        Node<K, V> prev = null;  
        Node<K, V> current = oldHead;  
  
        while (current != null) {  
            if (current.key.equals(key)) {  
                V oldValue = current.value;  
                current.value = value;  
                return oldValue;  
            }  
            prev = current;  
            current = current.next;  
        }  
  
        if (prev == null) {  
            // Insert at head  
            newNode.next = oldHead;  
            table[index] = newNode;  
        } else {  
            // Insert at tail  
            prev.next = newNode;  
        }  
  
        countArray.incrementAndGet(index);  
        size++;  
  
        // Optionally resize the table if load factor exceeds  
        if ((float) size / capacity > loadFactor) {  
            resize();  
        }  
  
        return null;  
    }  
  
    public V get(K key) {  
        int index = hash(key) % capacity;  
        Node<K, V> head = table[index];  
  
        while (head != null) {  
            if (head.key.equals(key)) {  
                return head.value;  
            }  
            head = head.next;  
        }  
  
        return null;  
    }  
  
    public V remove(K key) {  
        int index = hash(key) % capacity;  
        Node<K, V> head = table[index];  
        Node<K, V> prev = null;  
  
        while (head != null) {  
            if (head.key.equals(key)) {  
                if (prev == null) {  
                    table[index] = head.next;  
                } else {  
                    prev.next = head.next;  
                }  
                countArray.decrementAndGet(index);  
                size--;  
                return head.value;  
            }  
            prev = head;  
            head = head.next;  
        }  
  
        return null;  
    }  
  
    private void resize() {  
        // Implement resizing logic here, which is complex and involves creating a new table  
        // and rehashing all existing entries into the new table.  
        // This implementation is omitted for simplicity.  
    }  
  
    private int hash(K key) {  
        // Implement a hash function here. This is simplified for demonstration.  
        return System.identityHashCode(key);  
    }  
  
    // Additional methods like containsKey, size, etc. can be implemented similarly.  
}