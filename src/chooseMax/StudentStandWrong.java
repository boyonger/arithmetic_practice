package chooseMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
*/
public class StudentStandWrong {
    public static int[] max(int[] list) {
        //0为max，1位位置
        int[] maxAndPos = new int[2];
        maxAndPos[0] = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] >= maxAndPos[0]) {
                maxAndPos[0] = list[i];
                maxAndPos[1] = i;
            }
        }
        return maxAndPos;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        int[] ai = new int[n];
        int[] smallDai = new int[n];
        for (int i = 0; i < smallDai.length; i++) {
            smallDai[i] = Integer.MIN_VALUE;
        }
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ai[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        Integer k = Integer.parseInt(str[0]);
        Integer d = Integer.parseInt(str[1]);

        //开始
        int sumMul = 1;
        int maxAllMul = 1;
        int minAllMul=1;
        int valueCount = 0;
        List<Integer> maxValue = new ArrayList<>();
        //i为当前的位置
        for (int maxPos = 0; maxPos < ai.length; maxPos++) {
            int pos = maxPos;
            while (valueCount < k) {
                for (int i = pos; i < Integer.min(d, smallDai.length); i++) {
                    if (i < smallDai.length)
                        smallDai[i] = ai[i];
                }
                int[] maxAndPos = max(smallDai);
                if (maxAndPos[1] > pos) {
                    pos = maxAndPos[1] + 1;
                }else{
                    pos++;
                }
                smallDai[maxAndPos[1]] = Integer.MIN_VALUE;
                if (maxAndPos[0] > Integer.MIN_VALUE) {
                    maxValue.add(maxAndPos[0]);
                    sumMul *= maxAndPos[0];
                }
                valueCount++;
            }
            if (sumMul > maxAllMul && maxValue.size() == k) {
                maxAllMul = sumMul;
            }
            sumMul = 1;
            valueCount = 0;
            maxValue.clear();
        }
        System.out.println(maxValue.toString());
        System.out.println(maxAllMul);
    }
}
