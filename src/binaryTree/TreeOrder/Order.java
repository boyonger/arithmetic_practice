package binaryTree.TreeOrder;

import java.util.Scanner;
import java.util.Stack;

class BinaryNode { // 二叉树节点类
    public String data;
    public BinaryNode leftChild, rightChild;

    public BinaryNode() {
        data = "";
    }

    public BinaryNode(String data) {
        this.data = data;
    }
}

class BinaryTree { // 二叉树类
    public BinaryNode root;

    public BinaryTree(String data) {
        root = new BinaryNode(data);
    }

    public BinaryTree(String[] a, int i) {
        //root=insert(a,i);
    }

    //根据数组构造链表二叉树并且*表示为空
    public BinaryNode insert(String[] binaryArray, int i) {
        if (i < binaryArray.length && !binaryArray[i].equals("#")) {
            BinaryNode root = new BinaryNode(binaryArray[i]);
            root.leftChild = insert(binaryArray, 2 * i + 1);
            root.rightChild = insert(binaryArray, 2 * i + 2);
            return root;
        } else {
            return null;
        }
    }

    //递归
    public void preOrder(BinaryNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void inOrder(BinaryNode root) {
        if (root != null) {
            inOrder(root.leftChild);
            System.out.println(root.data);
            inOrder(root.rightChild);
        }
    }

    public void backOrder(BinaryNode root) {
        if (root != null) {
            backOrder(root.leftChild);
            backOrder(root.rightChild);
            System.out.println(root.data);
        }
    }

    //非递归前序
    public void preOrderNotRecur(BinaryNode root) {
        Stack<BinaryNode> binaryStack = new Stack<>();
        BinaryNode p = root;
        binaryStack.push(p);
        while (!binaryStack.isEmpty()) {
            p = binaryStack.pop();
            if ((p.rightChild != null)) {
                p = p.rightChild;
                binaryStack.push(p);
            }
            System.out.println(p.data);
            if (p.leftChild != null) {
                p = p.leftChild;
                binaryStack.push(p);
            }
        }
    }

    //非递归中序
    public void inOrderNotRecur(BinaryNode root) {

    }

}

public class Order {
    //数组二叉树前序遍历
    public static void order(String[] a) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        //0是root
        int index = 0;
        while (index < a.length || !stack.isEmpty()) {
            while (index < a.length && !a[index].equals("#")) {
                stringBuilder.append(a[index]);
                stack.push(index);
                index = index * 2 + 1;
            }
            if (!stack.isEmpty()) {
                index = stack.pop() * 2 + 2;
            }
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {

        //String[] a = parseSampleInput();
        //order(a);
    }

    public static String[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            return in.nextLine().split(" ");
        }
        return null;
    }
}

/*
    BinaryTree binaryTree=new BinaryTree(a,0);
    StringBuilder stringBuilder = new StringBuilder();
    Stack<Binary> anotherStack = new Stack<>();
    Binary node=binaryTree.root;
    while (node!=null || !anotherStack.isEmpty()) {
        while (node!=null && !node.data.equals("#")) {
            stringBuilder.append(node.data);
            anotherStack.push(node);
            node = node.leftChild;
        }
        if (!anotherStack.isEmpty()) {
            node=anotherStack.pop();
            node=node.rightChild;
        }
    }
*/