package dynamicPrograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String palindrome;
        while ((palindrome = bf.readLine()) != null) {
            int length = palindrome.length();
            int[][] dynamicDis = new int[length + 1][length + 1];
            for (int i = 0; i <= length; i++) {
                for (int j = 0; j <= length; j++) {
                    if (i == 0 || j == 0) {
                        dynamicDis[i][j] = 0;
                    } else if (palindrome.charAt(i - 1) == palindrome.charAt(length - j)) {
                        dynamicDis[i][j] = dynamicDis[i - 1][j - 1] + 1;
                    } else {
                        dynamicDis[i][j] = Math.max(dynamicDis[i - 1][j], dynamicDis[i][j - 1]);
                    }
                }
            }
            if (dynamicDis[length][length] >= length - 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
