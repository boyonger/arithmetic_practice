package shootBasketball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChooseBasketball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] data = str.split(" ");
            int p = Integer.parseInt(data[0]);
            int n = Integer.parseInt(data[1]);
            int[] basketballNumber = new int[n];
            int[] visitBasketry = new int[p];
            int a = -1;
            boolean judge = false;
            for (int i = 0; i < n && (str = br.readLine()) != null; i++) {
                basketballNumber[i] = Integer.parseInt(str.trim());
                int position = Integer.parseInt(str.trim()) % p;
                if (judge == false) {
                    if (visitBasketry[position] == 0) {
                        visitBasketry[position] = 1;
                    } else {
                        a = i + 1;
                        judge = true;
                    }
                }

            }
            System.out.println(a);

        }
    }
}
