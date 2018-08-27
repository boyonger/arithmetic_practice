package writtenExam.youdao.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        int[] apples = new int[count];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            apples[i] = (Integer.parseInt(data[i]));
        }
        int m = Integer.parseInt(br.readLine());
        data = br.readLine().split(" ");
        int[] askNumber = new int[m];
        for (int i = 0; i < askNumber.length; i++) {
            askNumber[i] = Integer.parseInt(data[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int number = askNumber[i];
            int allsum = apples[0];
            if (allsum >= number) {
                list.add(0);
            } else {
                for (int j = 1; j < apples.length; j++) {
                    allsum += apples[j];
                    if (allsum >= number) {
                        list.add(j);
                        break;
                    }
                }
            }
        }

        for (int a : list) {
            System.out.println(a + 1);
        }
    }

}
