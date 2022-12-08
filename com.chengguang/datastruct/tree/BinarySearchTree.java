package datastruct.tree;

public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right==null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else {
                if (p.left==null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }



    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
