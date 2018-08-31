package writtenExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
5
2 3 3 3

9
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int allLen = Integer.parseInt(br.readLine().trim());
        String[] data = br.readLine().split(" ");
        int aCount = Integer.parseInt(data[0]);
        int aLen = Integer.parseInt(data[1]);
        int bCount = Integer.parseInt(data[2]);
        int bLen = Integer.parseInt(data[3]);
        long aSum = 0;
        long bSum = 0;
        long aBSum = 0;
        if (allLen % aLen == 0 && allLen / aLen < aCount) {
            int aNumber = allLen / aLen;
            int a = 1;
            for (int i = 1; i <= aLen; i++) {  //不是事0
                a = a * i;
            }
            int b = 1;
            for (int i = 1; i <= aNumber; i++) {  //不是事0
                b = b * i;
            }
            int c = 1;
            for (int i = 1; i <= aLen - aNumber; i++) {  //不是事0
                c = c * i;
            }
            aSum = a / (b * c);
        }
        if (allLen % bLen == 0 && allLen / bLen < bCount) {
            int bNumber = allLen / bLen;
            int a = 1;
            for (int i = 1; i <= bLen; i++) {  //不是事0
                a = a * i;
            }
            int b = 1;
            for (int i = 1; i <= bNumber; i++) {  //不是事0
                b = b * i;
            }
            int c = 1;
            for (int i = 1; i <= bLen - bNumber; i++) {  //不是事0
                c = c * i;
            }
            bSum = a / (b * c);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < aLen; i++) {
            for (int j = 0; j < bLen; j++) {
                if (i * aCount + j * bCount == allLen) {
                    List<Integer> aList=new ArrayList<>();
                    aList.add(i);
                    aList.add(j);
                    list.add(aList);
                    break;
                }
            }
        }
        if (!list.isEmpty()) {
            for (List<Integer> bList:list) {
                //alent x blen y
                int a = 1;
                for (int i = 1; i <= aLen; i++) {
                    a = a * i;
                }
                int b = 1;
                for (int i = 1; i <= bList.get(0); i++) {
                    b = b * i;
                }
                int c = 1;
                for (int i = 1; i <= aLen - bList.get(0); i++) {
                    c = c * i;
                }
                aBSum += a / (b * c);
                int a1 = 1;
                for (int i = 1; i <= bLen; i++) {  //不是事0
                    a1 = a1 * i;
                }
                int b1 = 1;
                for (int i = 1; i <= bList.get(1); i++) {  //不是事0
                    b1 = b1 * i;
                }
                int c1 = 1;
                for (int i = 1; i <= bLen - bList.get(1); i++) {  //不是事0
                    c1 = c1 * i;
                }
                aBSum += a1 / (b1 * c1);
            }
        }

        System.out.println((aSum + bSum + aBSum) % 1000000007);
    }
}
