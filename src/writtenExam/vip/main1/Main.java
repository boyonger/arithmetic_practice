package writtenExam.vip.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        int k = Integer.parseInt(words[0]);
        int n = Integer.parseInt(words[1]);
        int[][] numberList = new int[n][n];
        List<Integer> twoList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                numberList[i][j] = Integer.parseInt(words[j]);
                twoList.add(Integer.parseInt(words[j]));
            }
        }
        Collections.sort(twoList);
        System.out.println(twoList.get(k-1));
    }

/*    public static void dfs(int[][] numberList, int k, int row, int col) {
        Collections.sort(list);
        if (list.size() < k) {
            list.changeTo(numberList[row][col]);
        }else{
            if ()
        }
    }*/
}
