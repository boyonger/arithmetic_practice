package binaryTree;

import java.util.Stack;

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


    public void insertTree(BinaryNode root, int[] pre, int[] in, int prePos, int start, int inPos, int end) {
        BinaryNode p = new BinaryNode(pre[prePos]);
        boolean flag = false;
        for (int i = start; i < inPos; i++) {
            if (in[i] == pre[prePos]) {
                flag = true;
                root.leftChild = p;
                insertTree(root.leftChild, in, pre, prePos++, start, i, end);
            }
        }
        if (flag == false) {
            for (int i = inPos + 1; i < end; i++) {
                if (in[i] == pre[prePos]) {
                    root.rightChild = p;
                    insertTree(root.leftChild, in, pre, prePos++, start, i, end);
                }
            }
        }

    }
}

public class ConstructTreeByPreAndIn {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertTree(binaryTree.root,a,b,0,0, );
    }
}
