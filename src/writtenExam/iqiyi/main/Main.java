package writtenExam.iqiyi.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
修改数字098989
1
111000
3
000111
1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine().trim();
        int[] numberList = new int[6];
        for (int i = 0; i < words.length(); i++) {
            numberList[i] = words.charAt(i) - '0';
        }
        int afterNumber = numberList[3] + numberList[4] + numberList[5];
        int beforeNumber = numberList[0] + numberList[1] + numberList[2];
        List<Integer> afterList = new ArrayList<>();
        afterList.add(numberList[3]);
        afterList.add(numberList[4]);
        afterList.add(numberList[5]);
        List<Integer> beforeList = new ArrayList<>();
        beforeList.add(numberList[0]);
        beforeList.add(numberList[1]);
        beforeList.add(numberList[2]);
        if ((numberList[0] + numberList[1] + numberList[2]) == (numberList[3] + numberList[4] + numberList[5])) {
            System.out.println(0);
        } else if (((afterNumber - beforeNumber <= 9 - Collections.min(beforeList)) && (afterNumber - beforeNumber >= 0))
                || (beforeNumber - afterNumber <= 9 - Collections.min(afterList)) && (afterNumber - beforeNumber < 0)) {

            System.out.println(1);
        } else {
            int one = 9 - Collections.min(beforeList);
            int oneOne = 9 - Collections.min(afterList);
            beforeList.remove(Collections.min(beforeList));
            afterList.remove(Collections.min(afterList));
            if (((afterNumber - beforeNumber <= one + 9 - Collections.min(beforeList)) && (afterNumber - beforeNumber >= 0))
                    || (beforeNumber - afterNumber <= oneOne + 9 - Collections.min(afterList)) && (afterNumber - beforeNumber < 0)) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
