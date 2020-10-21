package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        char[] a={0,0,0,0};
        a[3]=3;
    }

    public void test(int b) {
        int a = 10;
        new Thread() {
            public void run() {
                System.out.println(a);
                System.out.println(b);
            }

            ;
        }.start();
    }
}
