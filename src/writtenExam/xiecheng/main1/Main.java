package writtenExam.xiecheng.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(br.readLine().trim());
        String str = "";
        String result = Long.toBinaryString(number);
        long sum = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1') {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
