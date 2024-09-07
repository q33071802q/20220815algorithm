package thinkjava.map;

import java.util.concurrent.locks.ReentrantLock;

import static java.util.Objects.hash;

public class EnhancedConcurrentHashMap<K, V> {  
    private final Node<K, V>[] table;  
    private final int capacity;  
    private final float loadFactor;  
    private final int[] lockMap; // 用于存储每个槽位的锁对象索引  
    private final ReentrantLock[] locks; // 细粒度的锁数组  
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
  
    public EnhancedConcurrentHashMap(int capacity, float loadFactor) {  
        this.capacity = capacity;  
        this.loadFactor = loadFactor;  
        this.table = new Node[capacity];  
        this.lockMap = new int[capacity];  
        this.locks = new ReentrantLock[capacity];  
        for (int i = 0; i < capacity; i++) {  
            lockMap[i] = i;  
            locks[i] = new ReentrantLock();  
        }  
        this.size = 0;  
    }  
  
    public V put(K key, V value) {  
        int index = hash(key) % capacity;  
        locks[index].lock();  
        try {  
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
                // 插入到头部  
                newNode.next = oldHead;  
                table[index] = newNode;  
            } else {  
                // 插入到尾部  
                prev.next = newNode;  
            }  
  
            size++;  
  
            // 可选：如果超过负载因子则进行扩容  
            if ((float) size / capacity > loadFactor) {  
                resize();  
            }  
  
            return null;  
        } finally {  
            locks[index].unlock();  
        }  
    }

    private void resize() {
        // Implement resizing logic here, which is complex and involves creating a new table
        // and rehashing all existing entries into the new table.
        // This implementation is omitted for simplicity.
    }

    public V get(K key) {  
        int index = hash(key) % capacity;  
        locks[index].lock();  
        try {  
            Node<K, V> head = table[index];  
  
            while (head != null) {  
                if (head.key.equals(key)) {  
                    return head.value;  
                }  
                head = head.next;  
            }  
  
            return null;  
        } finally {  
            locks[index].unlock();  
        }  
    }  
  
    public V remove(K key) {  
        int index = hash(key) % capacity;  
        locks[index].lock();  
        try {  
            Node<K, V> head = table[index];  
            Node<K, V> prev = null;  
  
            while (head != null) {  
                if (head.key.equals(key)) {  
                    if (prev == null) {  
                        table[index] = head.next;  
                    } else {  
                        prev.next = head.next;  
                    }  
                    size--;  
                    return head.value;  
                }  
                prev = head;  
                head = head.next;  
            }  
  
            return null;  
        } finally {  
            locks[index].unlock();  
        }  
    }  
  
    // 省略了resize方法和hash方法，它们与之前相同  
  
    // 可以添加其他方法，如containsKey、size等，它们都需要获取相应的锁  
}