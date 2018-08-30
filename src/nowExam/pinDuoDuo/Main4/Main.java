package nowExam.pinDuoDuo.Main4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = 0;
        String[] data = br.readLine().trim().split(" ");
        double a = Integer.parseInt(data[0]);
        double b = Integer.parseInt(data[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int mod = (int)a % (int) b;
        int c = 0;
        while (true) {
            if (mod == 0) {
                c = 0;
                break;
            } else if (!map.containsKey(mod)) {
                map.put(mod, count);
                count++;
            } else {
                c = count - map.get(mod);
                start -= c;
                break;
            }
            start++;

            while (mod < b) {
                mod = mod * 10;
            }
            mod = mod % (int) b;
        }
        System.out.println(start + " " + (int) c);
    }
}
