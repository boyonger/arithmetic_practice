package writtenExam.huya.main2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void encode(int[] a) {
        Map<Integer,Integer> encodeMap=new HashMap<>();
        StringBuffer stringBuffer=new StringBuffer();
        encodeMap.put(1,5);
        encodeMap.put(2,3);
        encodeMap.put(3,1);
        encodeMap.put(4,2);
        encodeMap.put(5,4);
        for (int i=0;i<a.length;i++){
            stringBuffer.append(encodeMap.get(a[i]));
        }
        System.out.println(stringBuffer);
    }

    public static int[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String[] t1 = in.nextLine().split(" ");
            int[] t2 = new int[t1.length];
            for (int i = 0; i < t1.length; i++) {
                t2[i] = Integer.parseInt(t1[i]);
            }
            return t2;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = parseSampleInput();
        encode(a);
    }
}
