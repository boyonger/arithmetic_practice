package binaryTree.TreeOrder;

import java.util.Scanner;
import java.util.Stack;

class Binary { // 二叉树节点类
    public String data;
    public Binary leftChild, rightChild;

    public Binary() {
        // TODO Auto-generated constructor stub
        data="";
    }

    public Binary(String data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }
}

class BinaryTree { // 二叉树类
    public Binary root = null;

    public BinaryTree(String[] a,int i) {
        // TODO Auto-generated constructor stub
        root=insert(a,i);
    }

    public Binary insert(String[] a,int i){
        Binary root=new Binary();
        if (i<a.length){
            root.data=a[i];
            root.leftChild=insert(a,2*i+1);
            root.rightChild=insert(a,2*i+2);
            return root;
        }else{
            return null;
        }
    }
}

public class Order {
    public static void order(String[] a) {
        /*
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
        */
        BinaryTree binaryTree=new BinaryTree(a,0);
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Binary> anotherStack = new Stack<>();
        //0是root
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
        System.out.println(stringBuilder);
    }

    public static String[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            return in.nextLine().split(" ");
        }
        return null;
    }

    public static void main(String[] args) {
        String[] a = parseSampleInput();
        order(a);
    }
}
