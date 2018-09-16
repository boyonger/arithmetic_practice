package writtenExam.Tencent.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
3
91 16 5
58 16 0
96 12 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String data[] = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            int c = Integer.parseInt(data[2]);
            boolean flag = false;
            for (int j = 1; j < 100; j++) {
                if ((a * j) % b == c) {
                    list.add("Yes");
                    flag=true;
                    break;
                }
            }
            if (flag == false) {
                list.add("No");
            }
        }
        for (String a : list) {
            System.out.println(a);
        }
    }
}
