package writtenExam.jingchi.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
3 3
T 1 2
T 3 2
Q 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int a = Integer.parseInt(data[1]);
        int[] passengerList = new int[n];
        for (int i = 0; i < n; i++) {
            passengerList[i] = i;
        }
        for (int i = 0; i < a; i++) {
            data = br.readLine().split(" ");
            if (data[0].equals("T")) {
                int a1 = Integer.parseInt(data[1]) - 1;
                int a2 = Integer.parseInt(data[2]) - 1;
                for (int j = 0; j < passengerList.length; j++) {
                    if (passengerList[j] == a1) {
                        passengerList[j] = a2;
                    }
                }

            } else if (data[0].equals("Q")) {
                int b1 = Integer.parseInt(data[1]) - 1;
                int pos = passengerList[b1];
                int sum = 0;
                for (int j = 0; j < passengerList.length; j++) {
                    if (passengerList[j] == pos) {
                        sum++;
                    }
                }
                list.add(pos+1);
                list.add(sum);
            }
        }
        for (int tt : list)
        {
            System.out.print(tt + " ");
        }
    }
}
