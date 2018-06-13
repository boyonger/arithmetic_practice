package deleteNumber;

import java.io.IOException;

class LinkNote {
    private int data;
    private LinkNote next;

    LinkNote() {

    }

    LinkNote(int data) {
        this.data = data;
    }
}

class Link {
    private LinkNote firstLink;

    Link(LinkNote p) {
        firstLink = p;
    }


    //删除第n个结点，从1开始算起
    public boolean remove(int position){
        LinkNote p=firstLink;
        for (int i=1;i<=position;i++){

        }
    }


}

public class DeleteNumber {
    public static void main(String[] args) throws IOException {

    }
}
