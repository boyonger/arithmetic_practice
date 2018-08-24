package leetcode;

import java.util.ArrayList;
import java.util.List;

class LinkNode {
    public int value;
    public LinkNode next;

    public LinkNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class Link {
    public LinkNode first;

    public Link(int value) {
        first = new LinkNode(value);
    }

    public boolean addLinkNote(LinkNode p) {
        p.next = first;
        first = p;
        return true;
    }


}

public class RelatedNumber {

    public LinkNode addTwoNumbers(LinkNode l1, LinkNode l2) {  //传入两个first
        int addPosition = 0;
        Link newLink = new Link(0);
        while (l1 != null && l2 != null) {
            if (l1.value + l2.value + addPosition >= 10) {
                addPosition = 1;
            } else {
                addPosition = 0;
            }
            int addNumber = (l1.value + l2.value + addPosition) % 10;
            newLink.addLinkNote(new LinkNode(addNumber));
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1==null && l2!=null){
            if (l2.value+addPosition>=10){
                newLink.addLinkNote(new LinkNode((l2.value+addPosition)%10));
                newLink.addLinkNote(new LinkNode(1));
            }
        }else if (l2==null && l1!=null){
            if (l1.value+addPosition>=10){
                    newLink.addLinkNote(new LinkNode((l2.value+addPosition)%10));
                    newLink.addLinkNote(new LinkNode(1));
            }
        }
        return newLink.first;
    }

    //LeetCode 30
    /*
    String[]需要用map ，否则顺序引用跳过就不好了
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        int[] flag = new int[words.length];
        List<Integer> list = new ArrayList<>();
        boolean isContinue = true;
        int position = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean ishHit = false;
            if (isContinue == false) {
                position = i;
            }
            isContinue = true;
            for (int j = 0; j < words.length; j++) {
                if (i + words[j].length() < s.length() && flag[j] == 0) {
                    String mid = s.substring(i, i + words[j].length());
                    if (mid.equals(words[j])) {
                        flag[j] = 1;
                        i += words[j].length() - 1;
                        ishHit = true;
                        boolean allHit = true;
                        for (int t : flag) {
                            if (t == 0) {
                                allHit = false;
                                break;
                            }
                        }
                        if (allHit == true) {
                            list.add(position);
                            isContinue = false;
                            break;
                        }
                    }
                }
            }
            if (ishHit == false) {
                isContinue = false;
            }
            if (isContinue == false) {
                for (int t = 0; t < flag.length; t++) {
                    flag[t] = 0;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
/*        String words = "wordgoodstudentgoodword";
        List<Integer> list = new ArrayList<>();
        String[] s = {"word", "student"};
        list = findSubstring(words, s);
        System.out.println(list.toString());*/

    }
}
