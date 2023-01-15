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
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree;  //p指向要删除的节点 初始化指向根节点
        Node pp = null; //p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return; //没有找到

        //要删除的节点有两个子节点
        /**
         * 1.我的思路：找到要删除的节点右子树最小节点 就是一直right
         * 然后在right的下一个没有的时候 拿到right的父节点的left就可以了 ❌
         * 根据二叉搜索树的性质 第一个左子树的节点数据一定是最小的
         * 2.作者的思路：先拿到要删除节点的右子树 当该节点的左子树存在的时候
         * 则该左子树的叶子节点一定就是最小的 找到之后 将最小节点的数据覆盖掉要删除的节点
         *
         */
        if (p.left != null && p.right != null) { //查找右子树的最小节点
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        //删除节点是叶子节点或者仅有一个字节点
        /**
         * 找到要删除节点的子节点
         */
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        /**
         * 将要删除节点的父节点与要删除节点的子节点连接上
         */
        if (pp == null) {  //删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public Node findMin(){
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left!=null){
            p = p.left;
        }
        return p;
    }

    public Node findMax(){
        if (tree==null){
            return null;
        }
        Node p = tree;
        while (p.right!=null){
            p = p.right;
        }
        return p;
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
