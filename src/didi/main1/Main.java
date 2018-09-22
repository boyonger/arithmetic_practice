package didi.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] subOne = new String("q w e r t a s d f g z x c v").split(" ");
        String[] subTwo = new String("y u i o p h j k l b n m").split(" ");
        List<String> oneList = new ArrayList<>(Arrays.asList(subOne));
        List<String> twoList = new ArrayList<>(Arrays.asList(subTwo));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        String[][] data = new String[words.length - 1][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = words[i + 1];
        }
        String originalWord = words[0];
        //+1
        int[] score = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int min = Integer.min(data[i][0].length(), originalWord.length());
            int jian = data[i][0].length() - originalWord.length();
            int inScore = 0;
            for (int j = 0; j < min; j++) {
                Character one = data[i][0].charAt(j);
                Character two = originalWord.charAt(j);
                if (one != two) {
                    if ((oneList.contains(one) && oneList.contains(two)) || (twoList.contains(one) && twoList.contains(two))) {
                        inScore++;
                    } else {
                        inScore += 2;
                    }
                }
            }
            inScore += Math.abs(jian)*3;
            data[i][1] = inScore + "";
        }
        bubbleSort(data);
        for (int i = 0; i < 3; i++) {
            System.out.print(data[i][0] + " ");
        }
    }

    public static void bubbleSort(String[][] numberList) {
        for (int i = 0; i < numberList.length; i++) {
            for (int j = i + 1; j < numberList.length; j++) {
                if (numberList[i][1].compareTo(numberList[j][1]) > 0) {
                    String mid = numberList[i][0];
                    String mid2 = numberList[i][1];
                    numberList[i][0] = numberList[j][0];
                    numberList[i][1] = numberList[j][1];
                    numberList[j][0] = mid;
                    numberList[j][1] = mid2;
                }
            }
        }
    }
}
