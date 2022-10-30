package datastruct.list;

public class MyLinkedList<T> implements MyList<T> {

    Node firstNode = null;
    Node currentNode = null;
    int size = 0;

    class Node {
        /**
         * 下一个节点
         */
        Node nextNode = null;
        /**
         * 节点的数据
         */
        T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node(T t) {
            this.data = t;
        }
    }

    @Override
    public void add(T t) {
        Node node = new Node(t);
        if (size == 0) {
            firstNode = node;
            currentNode = node;
        } else {
            currentNode.nextNode = node;
            currentNode = node;
        }
        size++;
    }

    /**
     * 遍历链表到该索引位置
     * @param index
     * @return
     */
    public Node getNode(int index) {
        if (index == 0) {
            return firstNode;
        } else {
            Node node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
            return node;
        }
    }

    @Override
    public T get(int index) {
        //获取到index对应的结点
        Node node = getNode(index);
        return node.getData();
    }

    @Override
    public T remove(int index) throws Exception {
        //获取要删除的节点的上一个
        Node node = getNode(index-1);
        Node removedNode = node.nextNode;
        node.nextNode = removedNode.nextNode;
        this.size--;
        return removedNode.getData();
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        if (this.size == 0) {
            sb.append(firstNode.getData() + ",");
        } else {
            Node node = firstNode;
            for (int i = 0; i < this.size; i++) {
                sb.append(node.getData() + ",");
                node = node.nextNode;
            }
        }
        String s = sb.substring(0, sb.length() - 1);
        System.out.println(s + "]");
    }

    @Override
    public T update(int index, T o) {
        Node node = getNode(index);
        T buff = node.getData();
        node.setData(o);
        return buff;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.size());
        linkedList.add(1);
        linkedList.add(2);
        linkedList.print();
        System.out.println(linkedList.get(1));
//        linkedList.remove(1);
        linkedList.print();

        linkedList.update(1,5);
        linkedList.print();

        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.size());

    }
}
