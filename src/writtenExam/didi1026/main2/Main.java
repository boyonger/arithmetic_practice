package writtenExam.didi1026.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
2
2 1
6 2
 */
public class Main {
    public static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String[] words = br.readLine().trim().split("   | |  ");
            int n = Integer.parseInt(words[0]);
            int d = Integer.parseInt(words[1]);
            int[] dayThing = new int[n]; // 1 2
            int max = n / 2;
            dfs(d, 0, max, dayThing);
            list.add(sum);
            sum = 0;
        }

        for (Integer a : list) {
            System.out.println(a);
        }
    }

    public static void dfs(int d, int pos, int max, int[] matrix) {
        if (pos == matrix.length - 1) {
            ++sum;
        } else {
            for (int i = 1; i < 3; i++) {
                matrix[pos] = i;
                if (pos <= d || matrix[pos - d] != i) {
                    int count1 = 0, count2 = 0;
                    boolean flag = false;
                    for (int j = 0; j <= pos; j++) {
                        if (matrix[j] == 1) {
                            ++count1;
                        } else {
                            ++count2;
                        }
                        if (count1 >= max || count2 >= max) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == true) {
                        if (matrix[pos] == matrix[0]) {
                            ++sum;
                        }
                        continue;
                    }
                    dfs(d, pos + 1, max, matrix);
                } else {
                    continue;
                }
            }
        }

    }
}
