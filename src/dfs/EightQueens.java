package dfs;

/*
会下国际象棋的人都很清楚：皇后可以在横、竖、斜线上不限步数地吃掉其他棋子。如何将 8 个皇后放在棋盘上（有8×8个方格），使它们谁也不能被吃掉！这就是著名的八皇后问题。
对于某个满足要求的8皇后的摆放方法，定义一个皇后串a与之对应，即 a=b1b2...b8, 其中bi（1≤bi≤8）为相应摆法中第 i 行皇后所处的列数。已经知道8皇后问题一共有92组解
（即92个不同的皇后串）。给出一个数n，要求输出第n个串。串的比较是这样的:皇后串x置于皇后串y之前，当且仅当将x视为整数时比y小。
 */

import java.io.IOException;

public class EightQueens {
    public static void main(String[] args) throws IOException {

    }

    //k[0]=0表示（1,1）
    public static void solveQueens(int n, int[] k) { //n代表k[n]
        for (int i = 0; i < k.length; i++) { //k[0]从0->k.length表示位置
            k[n] = i;
            for (int j = 0; j < n; j++) {
                if (k[j] != k[n] && Math.abs(j - n) != Math.abs(k[j] - k[n])) {
                    solveQueens(n+1,k);
                }
            }
        }
    }
}
