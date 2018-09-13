package writtenExam.thunder.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        int sum = 0;
        for (int i = 1; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                double number = i * i + j * j;
                double sqrNumber = Math.sqrt(number);
                if (sqrNumber == (int) sqrNumber && sqrNumber <= count) {
                    if (divNumber(i, j) == 1 && divNumber(i, (int) sqrNumber) == 1 && divNumber(j, (int) sqrNumber) == 1) {
                        sum++;
                        //System.out.println(i+" "+j+" "+sqrNumber);
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static int divNumber(int a, int b) {
        return a % b == 0 ? b : divNumber(b, a % b);
    }
}
