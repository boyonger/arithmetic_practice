package dynamicPrograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
动态规划计算组合可能
5 20
15 10 32 7 16
23
5个数据，20满减，找出下列和大于20的最小组合。
建一个数组为可能的金额，用动态规划填满所需要的金额
若考虑不重复计算，可考虑从后往前计算
 */
public class FullReduction {

    public static List<Integer> sumList = new ArrayList<>();
    public static int b = 0;
    public static int count = 0;

    public static void swap(int[] numberList, int i, int index) {
        int temp = numberList[i];
        numberList[i] = numberList[index];
        numberList[index] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        int n = Integer.parseInt(words[0]);
        int x = Integer.parseInt(words[1]);
        b = x;
        int[] aList = new int[n];
        words = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            aList[i] = Integer.parseInt(words[i]);
        }
        int[] possibleNumber = new int[10000];
        possibleNumber[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = possibleNumber.length - 1; j >= aList[i]; --j) {
                if (possibleNumber[j - aList[i]] == 1) {
                    possibleNumber[j] = 1;
                }
            }
        }
        for (int i = 0; i < possibleNumber.length; i++) {
            if (possibleNumber[i] == 1 && i >= x) {
                System.out.print(i);
                break;
            }
        }
        /*for (int i = 0; i < aList.length; i++) {
            int sum = 0;
            for (int j = 0; j < aList.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    sum += aList[j];
                    if (sum >= b) {
                        sumList.add(sum);
                        break;
                    }
                }
            }
        }*/
        //fullArrangeByRecur(aList, 0);
        //System.out.print(Collections.min(sumList));
    }

    public static void fullArrangeByRecur(int numberList[], int index) {
        if (index >= numberList.length - 1) {
            int sum = 0;
            /*for (int i = 0; i < numberList.length; i++) {
                sum += numberList[i];
                if (sum >= b) {
                    sumList.add(sum);
                    break;
                }
            }*/
        } else {
            for (int i = index; i < numberList.length; i++) {
                swap(numberList, i, index);
                count += numberList[index];
                if (count >= b) {
                    sumList.add(count);
                } else {
                    fullArrangeByRecur(numberList, index + 1);
                }
                count -= numberList[index];
                swap(numberList, i, index);
            }
        }
    }
}
