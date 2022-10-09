package algorithm.sort;

import java.util.Iterator;

public class NodeTest {

    public static void main(String[] args) {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();

        first.item = "to";
        second.item = "be";
        third.item = "or";

        first.next = second;
        second.next = third;

        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.item);
        }
    }



    public class Stack<Item> implements Iterable<Item> {

        private Node first;
        private int N;

        private class Node {
            Item item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }

        public void push(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            N++;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return new LinkedStackIterator();
        }

        private class LinkedStackIterator implements Iterator<Item> {
            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return pop();
            }
        }
    }

    public static class Queue<Item> implements Iterable<Item> {

        private Node first;
        private Node last;
        private int N;

        private class Node {
            Item item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }

        public void enqueue(Item item) {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            N++;
        }

        public Item dequeue() {
            Item item = first.item;
            first = first.next;
            if (isEmpty()) {
                last = null;
            }
            N--;
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return null;
        }
    }

    public static class Bag<Item> implements Iterable<Item> {
        private Node first;

        private class Node {
            Item item;
            Node next;
        }

        public void add(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item> {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    public static class Test19{
        public static void main(String[] args) {

        }
    }

}
