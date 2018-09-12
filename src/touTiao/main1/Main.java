package touTiao.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    abcabcdd
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine().trim();
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < words.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < words.length(); j++) {
                if (set.contains(words.charAt(j))) {
                    break;
                }
                set.add(words.charAt(j));
            }
            number.add(set.size());
        }
        System.out.println(Collections.max(number));
    }
}
