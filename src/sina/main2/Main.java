package sina.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        Integer a = Integer.valueOf(words[0], 2);
        Integer b = Integer.valueOf(words[1], 2);
        /*Long a = Long.parseLong(words[0]);
        Long b = Long.parseLong(words[0]);*/
        int changeInt = changeTo(a, b);
        System.out.println(Integer.toBinaryString(changeInt));
    }

    public static int changeTo(int x, int y) {
        if (y == 0) return x;
        int score, push;
        score = x ^ y;
        push = (x & y) << 1;
        return changeTo(score, push);
    }
}
