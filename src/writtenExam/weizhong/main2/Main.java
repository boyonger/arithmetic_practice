package writtenExam.weizhong.main2;

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String GetResult(int N) {
        int row = 1;
        int col = 1;
        int i = 1;
        while (i <= N) {
            while (row != 1) {
                if (i>=N){
                    break;
                }
                row = row - 1;
                col = col + 1;
                i++;
            }
            if (i>=N){
                break;
            }
            col++;
            i++;
            while (col != 1) {
                if (i>=N){
                    break;
                }
                row = row + 1;
                col = col - 1;
                i++;
            }
            if (i>=N){
                break;
            }
            row++;
            i++;
        }
        return row+"/"+col;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        res = GetResult(_N);
        System.out.println(res);
    }
}

