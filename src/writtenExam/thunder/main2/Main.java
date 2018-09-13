package writtenExam.thunder.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().trim().split(" ");
        int posNumber = Integer.parseInt(number[0]);
        int negNumber = Integer.parseInt(number[1]);
        int[] maxList = new int[17];
        maxList[0] = posNumber;
        int nowNumber = negNumber;
        int neg7Count = 0;
        int pos7Count = 1;
        for (int i = 0; i < 6; i++) {
            nowNumber = nowNumber + posNumber;
            if (nowNumber < 0) {
                pos7Count++;
            } else {
                neg7Count++;
                nowNumber = nowNumber - posNumber + negNumber;
            }
        }
        for (int i = 0; i < pos7Count; i++) {
            maxList[i] = posNumber;
        }
        for (int i = 6; 6 - i < neg7Count; i--) {
            maxList[i] = negNumber;
        }
        for (int i = 7; i < 17; i++) {
            int moveNumber = 0;
            for (int j = i - 1; j > i - 7; j--) {
                moveNumber = moveNumber + maxList[j];
            }
            if (moveNumber + posNumber > 0) {
                maxList[i] = negNumber;
            } else {
                maxList[i] = posNumber;
            }
        }

        int sum = 0;
        for (int i = 0; i < maxList.length; i++) {
            sum += maxList[i];
        }
        System.out.println(sum);
    }
}
