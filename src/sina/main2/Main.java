package sina.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        int n = Integer.parseInt(words[1]);
        int[][] posMatrix = new int[2][3]; // x y zhi
        int[] timeChange = new int[words.length - 1];
        for (int i = 1; i < words.length - 1; i++) {
            timeChange[i] = Integer.parseInt(words[i]);
        }



        for (int i = 0; i < timeChange.length; i++) {
            int posOne=0;
            int increasePos = 0;
            int sum=0;
            for (int j = i + 1; j < timeChange.length; j++) {
                if (timeChange[j] - timeChange[i] > sum) {
                    posOne = timeChange[j];
                    sum=timeChange[j] - timeChange[i];
                }
            }
        }


        boolean increase = true;
        int increaseInterrupt = 0;
        for (int i = 1; i < timeChange.length; i++) {
            if (timeChange[i] < timeChange[i - 1]) {
                increaseInterrupt = i;
                break;
            }
        }
        if (increaseInterrupt != 0) {
            int sum = 0;
            int increasePos = increaseInterrupt;
            for (int i = increaseInterrupt + 1; i < timeChange.length; i++) {
                if (timeChange[i] - timeChange[increaseInterrupt] > sum) {
                    increasePos = timeChange[i];
                }
            }
        }

    }
}
