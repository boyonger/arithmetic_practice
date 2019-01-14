package writtenExam.toutiao1021.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();
        Stack<Integer> c = new Stack<>(); // 1 input 2 delete 3 redo
        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == 'i') {
                c.push(2);
                if (!a.isEmpty()) {
                    b.push(a.pop());
                }
            } else if (words.charAt(i) == 'o') {
                if (!c.isEmpty()) {
                    int d = c.pop();
                    if (d == 1) {
                        if (!a.isEmpty())
                        a.pop();
                    } else if (d == 2) {
                        if (!b.isEmpty())
                        a.push(b.pop());
                    }
                }
            } else {
                c.push(1);
                a.push(words.charAt(i));
            }
        }
        List<Character> list = new ArrayList<>();
        while (!a.isEmpty()) {
            list.add(0, a.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character p : list) {
            stringBuilder.append(p);
        }
        System.out.println(stringBuilder.toString());
    }
}
