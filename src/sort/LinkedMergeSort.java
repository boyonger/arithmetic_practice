package sort;

import java.lang.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedMergeSort {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() >= 2) {
            ListNode c = mergeTwo(lists.get(0), lists.get(1));
            for (int i = 2; i < lists.size(); i++) {
                c = mergeTwo(c, lists.get(i));
            }
            return c;
        } else {
            return lists.get(0);
        }

    }

    public ListNode mergeTwo(ListNode a, ListNode b) {
        // 归并排序
        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        ListNode finalNode;
        if (a.val <= b.val) {
            finalNode = new ListNode(a.val);
            a = a.next;
        } else {
            finalNode = new ListNode(b.val);
            b = b.next;
        }
        ListNode midNode = finalNode;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                midNode.next = new ListNode(a.val);
                a = a.next;
            } else {
                midNode.next = new ListNode(b.val);
                b = b.next;
            }
            midNode = midNode.next;
        }
        if (a != null) {
            midNode.next = a;
        }
        if (b != null) {
            midNode.next = b;
        }
        return finalNode;
    }
}

