package writtenExam.touTiao.main5;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        for (int k = 0; k < count; k ++) {
            String a = br.readLine().trim();
            String b = br.readLine().trim();
            List<Integer> alist = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                if (b.charAt(i) == a.charAt(0)) {
                    alist.add(i);
                }
            }
            if (alist.isEmpty() || a.length() != b.length()) {
                System.out.println("No");
            } else {
                List<Integer> blist = new ArrayList<>();
                for (int i = 0; i < alist.size(); i++) {
                    int pos = alist.get(i);
                    for (int j = 0; j < a.length(); j++, pos = (pos + 1) % b.length()) {
                        if (a.charAt(j) != b.charAt(pos)) {
                            blist.add(0);
                            break;
                        }
                    }
                }
                if (alist.size() == blist.size()) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            }
        }
    }
}



