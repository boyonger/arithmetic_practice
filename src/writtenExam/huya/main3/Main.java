package writtenExam.huya.main3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class MyObject {
        int id;
        int score;

        public MyObject(int id, int score) {
            this.id = id;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "{" + id + ":" + score + '}';
        }
    }

    public static void sort(MyObject[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].score > a[j + 1].score) {
                    MyObject mid = new MyObject(a[j].id, a[j].score);
                    a[j] = a[j + 1];
                    a[j + 1] = mid;
                }
            }
        }
    }

    public static MyObject[] parseSampleInput() {
        Scanner in = new Scanner(System.in);
        List<MyObject> inList = new ArrayList<>();
        while (in.hasNextInt()) {
            int id = in.nextInt();
            int score = in.nextInt();
            inList.add(new MyObject(id, score));
        }
        MyObject[] a = new MyObject[inList.size()];
        return inList.toArray(a);
    }

    public static void main(String[] args) {
        MyObject[] a = parseSampleInput();
        sort(a);
        System.out.println("Result: " + Arrays.toString(a));
    }
}
