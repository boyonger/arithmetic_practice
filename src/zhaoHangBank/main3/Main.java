package zhaoHangBank.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, Integer> change = new HashMap<>();

    public static void main(String[] args) throws IOException {
        change.put(0, 0);
        change.put(1, 1);
        change.put(8, 8);
        change.put(2, 5);
        change.put(5, 2);
        change.put(6, 9);
        change.put(9, 6);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        System.out.println(judge(number));
    }

    public static int judge(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            String a = i + "";
            String three = "";
            boolean flag = true;
            for (int j = 0; j < a.length(); j++) {
                int numIn = a.charAt(j) - '0';
                //System.out.println(numIn);
                if (!change.containsKey(numIn)) {
                    flag = false;
                    break;
                } else {
                    three += change.get(numIn);
                }
            }
            if (flag) {
                if (i != Integer.parseInt(three)) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
