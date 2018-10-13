package writtenExam.huawei.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//abbcccdddd
class Forest {
    List<BinaryTree> binaries;
    Map<String,String> otherMap;
    List<Character> charList;

    public Forest(Map<Character, Integer> map) {
        binaries=new ArrayList<>();
        otherMap = new HashMap<>();
        charList = new ArrayList<>();
        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            BinaryTree binaryTree = new BinaryTree(c.getKey(), c.getValue());
            binaries.add(binaryTree);
        }
    }


    public void haCode() {
        while (binaries.size() > 1) {
            Collections.sort(binaries);
            BinaryTree binaryTree = binaries.get(0);
            BinaryTree binaryTree1 = binaries.get(1);
            binaries.remove(0);
            binaries.remove(0);
            BinaryTree binaryTree2 = new BinaryTree('0', binaryTree.root.count + binaryTree1.root.count);
            binaryTree2.root.leftChild = binaryTree.root;
            binaryTree2.root.rightChild = binaryTree1.root;
            binaries.add(binaryTree2);
        }
    }

    public void getCode() {
        this.haCode();
        this.getCode(binaries.get(0).root, charList);
    }

    public void getCode(Binary sub, List<Character> charList) {
        if (sub.leftChild == null && sub.rightChild == null) {
            List<String> newList=new ArrayList<>();
            newList.add(sub.data+"");
            StringBuilder stringBuilder=new StringBuilder();
            for (Character a:charList){
                stringBuilder.append(a);
            }
            newList.add(stringBuilder.toString());
            otherMap.put(sub.data+"",stringBuilder.toString());
            //charList.remove(charList.size() - 1);
        } else {
            if (sub.leftChild != null) {
                charList.add('0');
                getCode(sub.leftChild, charList);
            }
            charList.remove(charList.size() - 1);
            if (sub.rightChild != null) {
                charList.add('1');
                getCode(sub.rightChild, charList);
            }
            charList.remove(charList.size() - 1);
        }
    }
}

class Binary { // 二叉树节点类
    public Character data;
    public int count;
    public Binary leftChild, rightChild;

    public Binary() {
        // TODO Auto-generated constructor stub
    }

    public Binary(Character data, int count) {
        // TODO Auto-generated constructor stub
        this.data = data;
        this.count = count;
    }
}

class BinaryTree implements Comparable<BinaryTree> { // 二叉树类
    public Binary root = null;

    public BinaryTree(Character data, int count) {
        root = new Binary(data, count);
    }

    @Override
    public int compareTo(BinaryTree o) {
        return this.root.count >= o.root.count ? 1 : -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine().trim();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            } else {
                map.put(a.charAt(i), 1);
            }
        }
        Forest forest = new Forest(map);
        forest.getCode();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<a.length();i++){
            stringBuilder.append(forest.otherMap.get(a.charAt(i)+""));
        }
        System.out.println(stringBuilder.toString());
    }
}
