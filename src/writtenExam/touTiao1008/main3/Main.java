package writtenExam.touTiao1008.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//计算排列组合以及阶乘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine().trim();
        for (int i=0;i<words.length();i++){

        }
        int blank = words.length() - 1;
        int c = jieCheng(blank) / jieCheng(blank - 3) / 6;
        System.out.println(c);
    }

    public static int jieCheng(int a) {
        int sum = 1;
        for (int i = a; i >= 1; i--) {
            sum = sum * i;
        }
        return sum;
    }
}