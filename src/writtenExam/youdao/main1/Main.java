package writtenExam.youdao.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int bbsum = 0;
        int allsum=0;
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        int[] score = new int[n];
        int[] wake = new int[n];
        data = br.readLine().split(" ");
        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(data[i]);
        }
        data = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            wake[i] = Integer.parseInt(data[i]);
            if (wake[i] == 1)
                bbsum += score[i];
        }
        if (k >= n) k = n;
        for (int i = 0; i < n; i++) {
            int a = 0;
            for (int j = 0; j < k; j++) {
                if ((i + j ) >= n) break;
                else {
                    if (wake[i + j ] == 0) {
                        a += score[i + j ];
                    }
                }
            }
            if (allsum<a){
                allsum=a;
            }
        }

        System.out.println(bbsum + allsum);

    }

}
