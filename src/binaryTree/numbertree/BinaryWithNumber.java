package binaryTree.numbertree;

class BinaryNode {
    public Character data;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode() {

    }

    public BinaryNode(Character data) {
        this.data = data;
    }
}

public class BinaryWithNumber {

    private BinaryNode root;

    public BinaryWithNumber() {
        root = new BinaryNode();
    }

    /**
     * 按照字母顺序插入
     */
    public void insert(Character a, BinaryNode p) {
        // 判断重复
        if (p != null) {
            if (p.data > a) {
                if (p.left != null) {
                    insert(a, p.left);
                } else {
                    p.left = new BinaryNode(a);
                }
            } else if (p.data < a) {
                if (p.right != null) {
                    insert(a, p.right);
                } else {
                    p.right = new BinaryNode(a);
                }
            }
        } else {
            this.root = new BinaryNode(a);
        }
    }

}
