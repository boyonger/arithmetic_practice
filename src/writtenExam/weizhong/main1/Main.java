package writtenExam.weizhong.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        int[] count = new int[words.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = Integer.parseInt(words[i]);
        }
        int sum = 0;
        sum += count[5];
        sum += count[4];
        count[0] = count[0] - count[4] * 11;
        if (count[0] < 0) count[0] = 0;
        sum += count[3];
        int rest4For0 = 0;
        count[1] = count[1] - count[3] * 5;
        if (count[1] < 0) {
            rest4For0 = 4 * Math.abs(count[1]);
        }
        int mod = count[2] % 4;
        sum += Math.ceil(count[2] / 4);
        //3 conten 11 1
        int rest3For0 = 0;
        if (count[1] <= 0) {
            rest3For0 = 27 - mod * 9;
        } else {
            if (mod == 1) {
                count[1] = count[1] - 4;
                rest3For0 = 11;
            } else if (mod == 2) {
                count[1] = count[1] - 3;
                rest3For0 = 6;
            } else if (mod == 3) {
                count[1] = count[1] - 1;
                rest3For0 = 5;
            }
            if (count[1] < 0) {
                rest3For0 = rest3For0 + Math.abs(count[1]) * 4;
            }
        }
        int rest2For0 = 0;
        if (count[1] > 0) {
            sum += Math.ceil(count[1] / 9);
            int twoMod = count[1] % 9;
            rest2For0 = 36 - twoMod * 4;
        }
        int allRest = rest4For0 + rest3For0 + rest2For0;
        if (count[0] <= allRest) {
            System.out.println(sum);
        } else {
            count[0] -= allRest;
            System.out.println(sum + Math.ceil(count[0] / 36));
        }
    }
}
