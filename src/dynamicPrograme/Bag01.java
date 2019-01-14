package dynamicPrograme;

import java.util.Collections;

//01背包问题，物品每个有且只有一个,求体积(或者说价值)最大
public class Bag01 {
    public static void main(String[] args) {
        int[] w = {2, 1, 6, 4, 3}; //重量
        int[] v = {4, 3, 5, 1, 2}; //体积
        int maxValue = 12;
        int[][] fMatrix = new int[v.length + 1][maxValue + 1]; //行是对应的物品标号，列是背包容量，里面值代表目前容量最大体积
        for (int i = 1; i < fMatrix.length; i++) {
            for (int j = 1; j < fMatrix[0].length; j++) {
                if (w[i - 1] <= j) {
                    //因为体积下标从0开始，所以w[i-1]
                    if (fMatrix[i - 1][j - w[i - 1]] + v[i - 1] > fMatrix[i - 1][j]) {
                        fMatrix[i][j] = fMatrix[i - 1][j - w[i - 1]] + v[i - 1];
                    } else {
                        fMatrix[i][j] = fMatrix[i - 1][j];
                    }
                } else {
                    fMatrix[i][j] = fMatrix[i - 1][j];
                }
            }
        }
        System.out.print(fMatrix[v.length][maxValue]);
    }
}
