package jing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        exchange(a, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    //s==3
    //1,2,3  4,5 -> 4,5,1,2,3
    public static void exchange(int[] a, int s) {
        int pos = 0;
        int other = s;
        while (s <= a.length - 1) {
            int temp = a[pos];
            a[pos] = a[s];
            a[s] = temp;
            pos++;
            s++;
        }
        s--;
        while (pos < s) {
            int temp = a[pos];
            a[pos] = a[s];
            a[s] = temp;
            pos++;
            s--;
        }
        if (pos == s) {
            int temp = a[pos - 1];
            a[pos - 1] = a[s];
            a[s] = temp;
        }
    }
}
