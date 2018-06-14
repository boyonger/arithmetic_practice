package deleteNumber;

import com.sun.deploy.util.SyncAccess;

import java.io.IOException;

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
    Link(LinkNote p) {
        firstLink.next = p;
    }


    //在链表头插入新的元素
    public boolean addLink(LinkNote link) {
        /*LinkNote p=firstLink.next;
        firstLink.next=link;
        link.next=p;*/
        link.next = firstLink.next;
        firstLink.next = link;
        return true;
    }

    //删除第n个结点，从1开始算起
    public boolean remove(int position) {
        LinkNote p = firstLink;
        for (int i = 0; i < position - 1; i++) {
            if (p.next == null) {
                return false;
            } else {
                p = p.next;
            }
        }
        //delete p
        if (p.next == null) {
            return false;
        } else {
            p.next = p.next.next;
            return true;
        }
    }

    public boolean removeByDistance(int distance) {
        LinkNote p = firstLink;
        LinkNote q;
        while (statement) {
            for (int i = 0; i < distance; i++) {
                if (p == firstLink && p.next == firstLink) {

                }
            }
        }
    }


}

public class DeleteNumber {
    public static void main(String[] args) throws IOException {

    }
}
