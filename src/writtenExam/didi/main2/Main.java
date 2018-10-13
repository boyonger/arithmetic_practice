package writtenExam.didi.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        int np = Integer.parseInt(words[0]);
        int nq = Integer.parseInt(words[1]);
        int nr = Integer.parseInt(words[2]);
        int[] color = {np, nq, nr};
        dfs(color, '0', 0,np + nq + nr);
        System.out.println(sum);
    }

    //P Q R
    public static void dfs(int[] color, Character k, int n, int len) {
        for (int i = 0; i < 3; i++) {
            if (color[i] - 1 >= 0) {
                Character p = add(i);
                color[i]--;
                if (n == 0 || p != k) {
                    if (n == len - 1) {
                        sum++;
                    } else {
                        dfs(color, p, n + 1, len);
                    }
                }
                color[i]++;
            }
        }
    }

    public static Character add(int number) {
        switch (number) {
            case 0:
                return 'P';
            case 1:
                return 'Q';
            case 2:
                return 'R';
        }
        return 'N';
    }

}
