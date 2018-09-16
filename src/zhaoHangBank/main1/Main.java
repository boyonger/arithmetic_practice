package zhaoHangBank.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int[] gi = new int[data.length];
        //List<Integer> gi=new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            gi[i] = Integer.parseInt(data[i]);
            //gi.add(Integer.parseInt(data[i]));
        }
        data = br.readLine().split(" ");
        //int[] sj = new int[data.length];
        List<Integer> sj = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            sj.add(Integer.parseInt(data[i]));
        }
        int sum = 0;
        for (int i = 0; i < gi.length; i++) {
            int satisfy = Integer.MAX_VALUE;
            int number = -1;
            for (int j = 0; j < sj.size(); j++) {
                if (sj.get(j) >= gi[i] && sj.get(j) < satisfy) {
                    satisfy = sj.get(j);
                    number = j;
                }
            }
            if (number != -1) {
                sj.remove(number);
                sum++;
            }
        }
        System.out.println(sum);
    }
}
