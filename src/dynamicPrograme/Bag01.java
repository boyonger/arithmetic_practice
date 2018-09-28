package dynamicPrograme;

import java.util.Collections;

//01背包问题，物品每个有且只有一个
public class Bag01 {
    public static void main(String[] args) {
        int[] w = {2, 1, 6, 4, 3}; //重量
        int[] v = {4, 3, 5, 1, 2}; //体积
        int maxValue = 12;
        int[][] fMatrix = new int[v.length + 1][maxValue + 1]; //行是体积，列是背包容量
        for (int i = 1; i < fMatrix.length; i++) {
            for (int j = 1; i < fMatrix[0].length; j++) {
                if (w[i] < j) {
                    if (fMatrix[i - 1][j - w[i]] + v[j] > fMatrix[i - 1][j]) {
                        fMatrix[i][j] = fMatrix[i - 1][j - w[i]] + v[j];
                    } else {
                        fMatrix[i][j] = fMatrix[i - 1][j];
                    }
                }
            }
        }
    }
}
