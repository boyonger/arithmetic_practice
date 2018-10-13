package touTiao1008.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int a = 0;
    public static int b = 0;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        a = Integer.parseInt(words[0]);
        b = Integer.parseInt(words[1]);
        int k = Integer.parseInt(words[2]);
        int[] number = new int[k];
        dfs(number, 0);
        System.out.print(count % 1000000007);
    }

    public static void dfs(int[] number, int pos) {
        for (int i = 0; i < 2; i++) {
            number[pos] = returnAOrB(i);
            if (pos == number.length - 1) {
                int score = 0;
                for (int j = 0; j < number.length; j++) {
                    score += number[j];
                }
                boolean flag = true;
                String scoreString = score + "";
                for (int j = 0; j < scoreString.length(); j++) {
                    if (Character.digit(scoreString.charAt(j), 10) != a && Character.digit(scoreString.charAt(j), 10) != b) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            } else {
                dfs(number, pos + 1);
            }
        }
    }

    public static int returnAOrB(int count) {
        switch (count) {
            case 0:
                return a;
            case 1:
                return b;
            default:
                return a;
        }
    }
}
