package dynamicPrograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
题目描述
有n个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，
使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？能吧
输入描述:
每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，
按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
输出描述:
输出一行表示最大的乘积。
输入
3
7 4 7
2 50
输出
49
测试用例:
36
7 -15 31 49 -44 35 44 -47 -23 15 -11 10 -21 10 -13 0 -20 -36 22 -13 -39 -39 -31 -13 -27 -43 -6 40 5 -47 35 -8 24 -31 -24 -1
3 31
 */
public class StudentStandRight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        int[] ai = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ai[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        Integer k = Integer.parseInt(str[0]);
        Integer d = Integer.parseInt(str[1]);

        long[][] max = new long[k][n];
        long[][] min = new long[k][n];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    max[i][j] = ai[j];
                    min[i][j] = ai[j];
                } else {
                    min[i][j] = 1;
                    max[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 1; m <= d; m++) {
                    if (j - m >= 0) {
                        if (ai[j] > 0) {
                            max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * ai[j]);
                            min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * ai[j]);
                        } else {
                            max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * ai[j]);
                            min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * ai[j]);
                        }
                    }
                }
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k - 1) {
                res = Math.max(res, max[k - 1][i]);
            }
        }
        System.out.println(res);


    }
}
