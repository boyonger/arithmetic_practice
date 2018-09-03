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
public class PermuteCombine {
    public static int calculateCombine(int bigNumber,int smallNumber){
        int first=1;
        int second=1;
        int third=1;
        for (int i=1;i<=bigNumber;i++){
            first=first*i;
        }
        for (int i=1;i<=smallNumber;i++){
            second=second*i;
        }
        for (int i=1;i<=bigNumber-smallNumber;i++){
            third=third*i;
        }
        return first/(second*third);
    }

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
        long aBSum = 1;
        if (allLen % aLen == 0 && allLen / aLen < aCount) {
            int aNumber = allLen / aLen;
            aSum=calculateCombine(allLen,aNumber);
        }
        if (allLen % bLen == 0 && allLen / bLen < bCount) {
            int bNumber = allLen / bLen;
            bSum = calculateCombine(bLen,bNumber);
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
                aBSum *= calculateCombine(aLen,bList.get(0));
                aBSum *= calculateCombine(bLen,bList.get(1));
            }
        }
        System.out.println((aSum + bSum + aBSum) % 1000000007);
    }
}
