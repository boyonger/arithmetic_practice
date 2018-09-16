package zhaoHangBank.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        int[] max = new int[number + 1];
        max[0] = 1;
        max[1] = 1;
        for (int i = 2; i < number + 1; i++) {
            max[i] = max[i - 1] + max[i - 2] ;
        }
        System.out.println(max[number]);
    }
}