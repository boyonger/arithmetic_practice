package link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//附加头结点（有一个空的结点）的双向链表
class LinkNote {
    int data;
    LinkNote next;

    LinkNote() {

    }

    LinkNote(int data) {
        this.data = data;
    }
}

class Link {
    private LinkNote firstLink;

    Link() {
        this.firstLink = new LinkNote();
        this.firstLink.next = firstLink;
    }

    //由于有附加头结点，所以第一个结点插在之后
    //考虑后觉得约瑟夫问题不用附加头结点
    Link(LinkNote p) {
        firstLink.next = p;
    }


    //在链表头插入新的元素
    public boolean addLinkFront(LinkNote link) {
        link.next = firstLink.next;
        firstLink.next = link;
        return true;
    }

    //删除第n个结点，firstLink->one为1
    public boolean remove(int position) {
        LinkNote p = firstLink;
        for (int i = 0; i < position - 1; i++) {
            if (p.next == firstLink) {
                return false;
            } else {
                p = p.next;
            }
        }
        //delete p
        if (p.next == firstLink) {
            return false;
        } else {
            p.next = p.next.next;
            return true;
        }
    }

    public int removeByDistance(int distance) {
        LinkNote p = firstLink;
        while (firstLink.next.next != firstLink && firstLink.next != firstLink) {
            //到达前一个结点
            for (int i = 0; i < distance; i++) {
                if (p.next == firstLink) {
                    p = firstLink;
                }
                p = p.next;
            }
            if (p.next == firstLink) {
                p = firstLink;
            }
            p.next = p.next.next;
        }
        return firstLink.next.data;
    }

    //first->one 其中one的位置是1
    public LinkNote located(int position) {
        LinkNote p = firstLink;
        for (int i = 0; i < position; i++) {
            if (p.next == firstLink) {
                return null;
            } else {
                p = p.next;
            }
        }
        return p;
    }

    //first->one 其中one的位置是1
    public boolean insert(int position, LinkNote value) {
        LinkNote p = firstLink;
        //到达前一个结点
        for (int i = 0; i < position - 1; i++) {
            if (p.next == firstLink) {
                return false;
            } else {
                p = p.next;
            }
        }
        value.next = p.next;
        p.next = value;
        return true;
    }

    public void display() {
        LinkNote p = firstLink;
        while (p.next != firstLink) {
            p = p.next;
            System.out.println(p.data);
        }
    }

    //翻转链表
    public boolean reverse() {
        LinkNote pre = firstLink;
        LinkNote now = firstLink.next;
        while (now.next != firstLink) {
            LinkNote next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return true;
    }
}

public class DeleteNumber {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while ((str = bf.readLine()) != null) {
            Link link = new Link();
            int number = Integer.parseInt(str);
            if (number > 1000) {
                number = 1000;
            }
            for (int i = 0; i < number; i++) {
                LinkNote q = new LinkNote(number - 1 - i);
                link.addLinkFront(q);
            }

           /* link.display();
            LinkNote newNode = new LinkNote(20000);
            link.insert(2, newNode);
            System.out.println("下一条");
            link.display();*/

            System.out.println(link.removeByDistance(2));
        }
        bf.close();
    }
}
