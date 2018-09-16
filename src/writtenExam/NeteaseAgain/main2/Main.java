package writtenExam.NeteaseAgain.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] minMax = new int[t][2];
        for (int i = 0; i < t; i++) {
            String[] data = br.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            int[] stay = new int[n];
            int pos = 0;
            if (k==0){

            } else if (k == 1) {
                stay[0] = 1;
            } else if (k == 2) {
                stay[0] = 1;
                stay[stay.length - 1] = 1;
            } else if (k >= 3) {
                k = k - 2;
                stay[0] = 1;
                stay[stay.length - 1] = 1;
                pos=2;
                while (k > 0) {
                    if (stay[pos] == 0) {
                        stay[pos] = 1;
                        k--;
                    }
                    if (pos + 2 > stay.length - 1) {
                        if (stay[stay.length - 1] == 0) {
                            pos = stay.length - 1;
                        } else {
                            for (int u = 0; u < stay.length; u++) {
                                if (stay[u] == 0) {
                                    pos = u;
                                    break;
                                }
                            }
                        }
                    } else {
                        pos = (pos + 2) % n;
                    }
                }
            }
            int max = 0;
            if (stay.length < 1) {

            } else {
                for (int j = 1; j + 1 < stay.length; j++) {
                    if ((stay[j] == 0) && (stay[j - 1] == 1) && (stay[j + 1] == 1)) {
                        max++;
                    }
                }
            }
            minMax[i][0] = 0;
            minMax[i][1] = max;
        }
        /*
        事实上 如果n数组 k比n的一半小 那么 选择k k比n的一半大 选择n-k
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int x = 0; x < t; ++x) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int max = 0;
            if (k != 0) {
                if (k <= n / 2) {
                    max = k - 1;
                } else {
                    max = n - k;
                }
            }
            System.out.println(0 + " " + max);

        }
         */
        for (int i = 0; i < minMax.length; i++) {
            System.out.println(minMax[i][0] + " " + minMax[i][1]);
        }
    }
}
