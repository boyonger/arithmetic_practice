package writtenExam.huawei.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new LinkedHashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine().replace(" ", "");
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) > 'a' && a.charAt(i) < 'z')) {
                if (map.containsKey(a.charAt(i)))
                    map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
                else {
                    map.put(a.charAt(i), 1);
                }
            } else if (a.charAt(i) > 'A' && a.charAt(i) < 'Z') {
                Character b = (char) (a.charAt(i) + 32);
                if (map.containsKey(b))
                    map.put(b, map.get(b) + 1);
                else {
                    map.put(b, 1);
                }
            }
        }
        Character d = '0';
        Integer e = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            if (c.getValue() > e) {
                e = c.getValue();
                d = c.getKey();
            }
        }
        d = (char) (d - 32);
        System.out.println(d + "" + e);
    }
}
