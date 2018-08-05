package wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Time {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        List<String> list=new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String[] data = br.readLine().
                    split(":");
            if (Integer.parseInt(data[0]) > 23) {
                data[0] = "0" + Integer.parseInt(data[0]) % 10;
            }
            if (Integer.parseInt(data[1]) > 59) {
                data[1] = "0" + Integer.parseInt(data[1]) % 10;
            }
            if (Integer.parseInt(data[2]) > 59) {
                data[1] = "0" + Integer.parseInt(data[2]) % 10;
            }
            list.add(String.join(":", data));
        }
        for (String a:list){
            System.out.println(a);
        }
    }
}
