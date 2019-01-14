package writtenExam.beike.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
4
1 2 3 4 5 6
128 39 20 109 100 92
1000 10 39 33 333 39
101 10 10 101 20 20
XIAOCHUN
XIAOZHI
TIE
TIE
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] words = br.readLine().trim().split(" ");
            int x = Integer.parseInt(words[0]);
            int a = Integer.parseInt(words[1]);
            int c = Integer.parseInt(words[2]);
            int y = Integer.parseInt(words[3]);
            int b = Integer.parseInt(words[4]);
            int d = Integer.parseInt(words[5]);
            int zhiTime = 0;
            int chunTime = 0;

            y -= a;
            x -= b;
            if (x <= 0 && y <= 0) {
                list.add("TIE");
            } else if (x <= 0) {
                list.add("XIAOCHUN");
            } else if (y <= 0) {
                list.add("XIAOZHI");
            }

            int zhiN = (int) Math.ceil(y / a);
            int chunN = (int) Math.ceil(x / b);
            int zhiNT = zhiN * (c - 1);
            int chunNT = chunN * (d - 1);



            while (x > 0 && y > 0) {
                zhiTime++;
                chunTime++;
                if (zhiTime == c && chunTime == d) {
                    y -= a;
                    x -= b;
                    if (x <= 0 && y <= 0) {
                        list.add("TIE");
                        break;
                    } else if (x <= 0) {
                        list.add("XIAOCHUN");
                        break;
                    } else if (y <= 0) {
                        list.add("XIAOZHI");
                        break;
                    }
                    zhiTime = 0;
                    chunTime = 0;
                } else if (zhiTime == c) {
                    y -= a;
                    if (y <= 0) {
                        list.add("XIAOZHI");
                        break;
                    }
                    zhiTime = 0;
                } else if (chunTime == d) {
                    x -= b;
                    if (x <= 0) {
                        list.add("XIAOCHUN");
                        break;
                    }
                    chunTime = 0;
                }
            }
        }

        for (String a : list) {
            System.out.println(a);
        }
    }
}
