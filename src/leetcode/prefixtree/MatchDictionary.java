package leetcode.prefixtree;

import java.util.HashMap;
import java.util.Map;

class DicTreeNode {
    // 第几个单词
    public int count;
    // 在属性中定义时 先执行 再执行构造函数
    public Map<Character, DicTreeNode> node = new HashMap<>();
    public boolean end;

    public DicTreeNode() {

    }

    public DicTreeNode(int count, Character a) {
        this.count = count;
        this.end = false;
        node.put(a, new DicTreeNode());
    }

    public DicTreeNode(int count) {
        this.count = count;
    }
}

class DicTree {
    // root is empty
    public DicTreeNode root;

    public DicTree() {
        root = new DicTreeNode();
    }

    public void insert(String words) {
        DicTreeNode current = root;
        for (int i = 0; i < words.length(); i++) {
            Character a = words.charAt(i);
            if (current.node.get(a) == null) {
                current.node.put(a, new DicTreeNode(i + 1));
            }
            current = current.node.get(a);
        }
        current.end = true;
    }

    public boolean get(String words) {
        DicTreeNode current = root;
        boolean inDic = true;
        for (int i = 0; i < words.length(); i++) {
            current = current.node.get(words.charAt(i));
            if (current == null) {
                inDic = false;
                break;
            }
        }
        return inDic && current.end;
    }
}

public class MatchDictionary {

    public int respace(String[] dictionary, String sentence) {
        //生成字典树
        DicTree dicTree = new DicTree();
        for (String a : dictionary) {
            dicTree.insert(a);
        }
        // 动态规划
        int[] matchDic = new int[sentence.length() + 1];
        String[] matchString = new String[sentence.length() + 1];
        matchDic[0] = 0;
        matchString[0] = "";
        // 对于每一个单词计算其在之前match dic的数量 
        for (int i = 0; i < sentence.length(); i++) {
            matchDic[i + 1] = matchDic[i];
            matchString[i + 1] = matchString[i];
            for (int j = i; j >= 0; j--) {
                String subWord = sentence.substring(j, i + 1);
                if (dicTree.get(subWord)) {
                    String midString = matchString[j] + subWord;
                    if (midString.length() > matchString[i + 1].length()) {
                        matchDic[i + 1] = matchDic[j] + 1;
                        matchString[i + 1] = midString;
                    }
                }
            }
        }
        return sentence.length() - matchString[matchDic.length - 1].length();
    }

    public static void main(String[] args) {
        
        /*DicTree dicTree=new DicTree();
        dicTree.insert("looked");
        dicTree.insert("just");
        dicTree.insert("like");
        dicTree.insert("her");
        dicTree.insert("brother");
        System.out.println(dicTree.get("brother"));*/

        MatchDictionary matchDictionary = new MatchDictionary();
        System.out.println(matchDictionary.respace(
                new String[]{"vprkj", "sqvuzjz", "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp", "spqzqtrqs", "rkktkruzsjkrzqq", "rk", "k", "zkvdzqrzpkrukdqrqjzkrqrzzkkrr", "pzpstvqzrzprqkkkd", "jvutvjtktqvvdkzujkq", "r", "pspkr", "tdkkktdsrkzpzpuzvszzzzdjj", "zk", "pqkjkzpvdpktzskdkvzjkkj", "sr", "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"},
                "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr"));

    }

}
