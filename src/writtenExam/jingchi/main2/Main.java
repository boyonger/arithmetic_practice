package writtenExam.jingchi.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int count = 1;
    public static int increase = 1;
    public static int step = 2;
    public static int temp = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix=new int[n][2]; //count 1:crease
        matrix[0][0]=1;
        matrix[0][1]=1;
        matrix[1][0]=2;
        matrix[2][1]=1;
        matrix[3][0]=3;
        matrix[3][1]=1;
        /*for (int i=3;i<matrix.length;i++){
            if (matrix[i-3][0]*2=)
        }*/
        dfs(n);
        System.out.println(Collections.min(list));
    }

    public static void dfs(int k) {
        for (int i = 0; i < 2; i++) {
            temp = increase;
            change(i);
            if (count == k) {
                list.add(step);
            } else if (count < k) {
                dfs(k);
            }
            decrease(i);
        }
    }

    public static void change(int i) {
        switch (i) {
            case 0:
                step++;
                count = count + increase;
                break;
            case 1:
                step += 3;
                increase = count;
                count = count + increase;
                break;
            default:
                break;
        }
    }

    public static void decrease(int i) {
        switch (i) {
            case 0:
                step--;
                count = count - increase;
                break;
            case 1:
                step -= 3;
                count = count - increase;
                increase = temp;
                break;
            default:
                break;
        }
    }
}
