package binaryTree;

class BinaryNode {
    public int value;
    public BinaryNode leftChild;
    public BinaryNode rightChild;

    public BinaryNode(int value) {
        this.value = value;
    }
}

class BinaryTree {
    public BinaryNode root;

    public BinaryTree() {
    }


    public BinaryNode insertTreeByPreAndIn(int[] pre, int[] in, int prePos, int start, int end) {
        if (prePos > pre.length - 1 || start > end) return null;
        BinaryNode node = new BinaryNode(pre[prePos]);
        int i;
        for (i = start; i <= end; i++) {
            if (in[i] == pre[prePos]) {
                break;
                /*在java中这么写会指向null
                insertTreeByPreAndIn(root.leftChild, in, pre, prePos++, start, i);
                insertTreeByPreAndIn(root.rightChild, in, pre, prePos++, i + 1, end);*/
            }
        }
        node.leftChild = insertTreeByPreAndIn(in, pre, prePos + 1, start, i - 1);
        node.rightChild = insertTreeByPreAndIn(in, pre, prePos + i - start + 1, i + 1, end);
        return node;
    }

    //递归
    public void preOrder(BinaryNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void inOrder(BinaryNode root) {
        if (root != null) {
            inOrder(root.leftChild);
            System.out.println(root.value);
            inOrder(root.rightChild);
        }
    }

    public void backOrder(BinaryNode root) {
        if (root != null) {
            backOrder(root.leftChild);
            backOrder(root.rightChild);
            System.out.println(root.value);
        }
    }
}

public class ConstructTreeByPreAndIn {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.insertTreeByPreAndIn(a, b, 0, 0, b.length - 1);
        binaryTree.preOrder(binaryTree.root);
    }
}
