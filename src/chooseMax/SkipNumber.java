package chooseMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//跳过数选最大
public class SkipNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int maxSumBySkip = 1001;
        int maxSumNotSkip=0;
        while ((str = br.readLine()) != null) {
            Integer count = Integer.parseInt(str);
            int[] increaseNumber = new int[count];
            str = br.readLine();
            String[] number = str.split(" ");
            for (int i = 0; i < count; i++) {
                increaseNumber[i] = Integer.parseInt(number[i]);
            }
            for (int i=1;i<count;i++){
                int mid=increaseNumber[i]-increaseNumber[i-1];
                if (maxSumNotSkip<mid){
                    maxSumNotSkip=mid;
                }
            }
            boolean flag=true;
            for (int i = 2; i < count; i++) {
                int midSkip=(increaseNumber[i] - increaseNumber[i - 2]);
                if (midSkip<=maxSumNotSkip){
                    System.out.println(maxSumNotSkip);
                    flag=false;
                    break;
                }else if (midSkip<maxSumBySkip){
                    maxSumBySkip=midSkip;
                }
            }
            if (flag){
                System.out.println(maxSumBySkip);
            }
        }

    }
}
