package writtenExam.vip.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//二进制加法
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine().trim();
        int[] numberList = new int[6];
        for (int i = 0; i < words.length(); i++) {
            numberList[i] = words.charAt(i) - '0';
        }
    }
}
