package writtenExam.touTiao1008.main5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
3
1
1
0
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        int a = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int[] step = new int[m];
        for (int i = 0; i < n; i++) {
            step[Integer.parseInt(br.readLine())] = Integer.MAX_VALUE;
        }
        int begin = Integer.MAX_VALUE;
        for (int i = a - 1; i < step.length && i < b; i++) {
            if (step[i] != Integer.MAX_VALUE) {
                step[i] = 1;
                begin = i;
                break;
            }
        }
        if (begin != Integer.MAX_VALUE) {
            for (int i = a, t = 1; i <= b; i++, t++) {
                if (judge(step, begin + t)) {
                    int score = 0;
                    for (int j = begin; j < begin + t; j++) {
                        if (judge(step, j) && t - j >= a && t - j <= b)
                            score += step[j];
                    }
                    step[begin + t] = score;
                }
            }
        }
        for (int i = begin + b; i < step.length; i++) {
            if (judge(step, i)) {
                int score = 0;
                for (int j = i - b + 1; j <= i + b - a; j++) {
                    if (judge(step, j)) {
                        score += step[j];
                    }
                }
                step[i] = score;
            }
        }
        System.out.print(step[m - 1]);
    }

    public static boolean judge(int[] step, int k) {
        if (step[k] != Integer.MAX_VALUE) {
            return true;
        } else return false;
    }
}



