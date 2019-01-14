package pony.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        Character operation = br.readLine().charAt(0);
        String b = br.readLine();
        int[] arrayA = detail(a);
        int[] arrayB = detail(b);
        int[] score = new int[2];
        switch (operation) {
            case '+':
                score = add(arrayA, arrayB);
                break;
            case '-':
                score = sub(arrayA, arrayB);
                break;
            case '*':
                score = mul(arrayA, arrayB);
                break;
            case '/':
                score = div(arrayA, arrayB);
                break;
        }
        printScore(score);
    }

    public static int[] add(int[] a, int[] b) {
        int[] score = new int[2];
        int son = a[0] * b[1] + a[1] * b[0];
        int mother = a[1] * b[1];
        score[0] = son;
        score[1] = mother;
        return score;
    }

    public static int[] sub(int[] a, int[] b) {
        int[] score = new int[2];
        int son = a[0] * b[1] - a[1] * b[0];
        int mother = a[1] * b[1];
        score[0] = son;
        score[1] = mother;
        return score;
    }

    public static int[] mul(int[] a, int[] b) {
        int[] score = new int[2];
        int son = a[0] * b[0];
        int mother = a[1] * b[1];
        score[0] = son;
        score[1] = mother;
        return score;
    }

    public static int[] div(int[] a, int[] b) {
        int[] score = new int[2];
        int son = a[0] * b[1];
        int mother = a[1] * b[0];
        score[0] = son;
        score[1] = mother;
        return score;
    }

    public static int smallMul(int n, int m) {  //求最小公倍數
        int r = n % m;
        while (r != 0) {
            n = m;
            m = r;
            r = n % m;
        }
        return m;
    }

    public static void printScore(int[] a) {
        int d = smallMul(a[0], a[1]);
        a[0] /= d;
        a[1] /= d;
        String str = a[0] * a[1] < 0 ? "-" : "";
        if (a[0] % a[1] == 0) {
            str += Math.abs(a[0] / a[1]);  //绝对值
        } else {
            int one = Math.abs(a[0]);
            int two = Math.abs(a[1]);
            if (one > two) {
                int temp = one / two;
                int other = one % two;
                str += temp + " " + other + "/" + two;
            } else
                str += one + "/" + two;
        }
        System.out.println(str);
    }

    // 0位 0正 1负
    public static int[] detail(String words) {
        int[] number = new int[2];
        boolean isSub = false;
        if (words.charAt(0) == '-') {
            isSub = true;
            words = words.substring(1);
        }
        String[] wordOne = words.split(" ");
        if (wordOne.length > 1) {
            String[] wordTwo = wordOne[1].split("/");
            int temp = Integer.parseInt(wordOne[0]) * Integer.parseInt(wordTwo[1])
                    + Integer.parseInt(wordTwo[0]);
            wordTwo[0] = temp + "";
            number[0] = Integer.parseInt(wordTwo[0]);
            number[1] = Integer.parseInt(wordTwo[1]);
        } else {
            String[] wordTwo = wordOne[0].split("/");
            if (wordTwo.length > 1) {
                number[0] = Integer.parseInt(wordTwo[0]);
                number[1] = Integer.parseInt(wordTwo[1]);
            } else {
                number[0] = Integer.parseInt(wordOne[0]);
                number[1] = 1;
            }
        }
        if (isSub) {
            number[0] = 0 - number[0];
        }
        return number;
    }
}
