package poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Poker {
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] data = br.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            String[] pokerOrderString = br.readLine().split(" ");
            String[] pokerOrder = new String[2*n];
            for (int j = 0; j < 2 * n; j++) {
                int tmp = j + 1;
                for (int t = 0; t < k; t++) {
                    if (tmp <= n) tmp = 2 * tmp - 1;
                    else tmp = 2 * (tmp - n);
                }
                tmp = tmp - 1;
                pokerOrder[tmp] = pokerOrderString[j];
            }
            System.out.println(String.join(" ", pokerOrder));
        }
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] data = br.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            String[] pokerOrderString = br.readLine().split(" ");
            int[] res = new int[2*n];
            for(int i=0;i<2*n;i++){
                int tmp = i + 1;
                for(int j = 0; j < k;j++){
                    if (tmp <= n) tmp = 2*tmp - 1;
                    else tmp = 2 * (tmp - n);
                }
                res[tmp - 1]=Integer.parseInt(pokerOrderString[i]);
            }
            //输出
            if(res.length> 0) System.out.print(res[0]);
            for(int i = 1;i< 2*n;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
        br.close();
    }


    public static String[] clearUpOrder(String[] pokerOrder) {
        int n = pokerOrder.length / 2;
        String[] clearPokerOrder = new String[pokerOrder.length];
        for (int i = 0, j = 0; j < n; i = i + 2, j++) {
            clearPokerOrder[i] = pokerOrder[j];
            clearPokerOrder[i + 1] = pokerOrder[j + n];
        }
        return clearPokerOrder;
    }
}
