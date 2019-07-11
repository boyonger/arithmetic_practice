package sort;

import java.io.IOException;

//all in small to big
public class Sort {

    //快排
    //xposition表示移动后的比较数位置 i表示xposition跟不上小于他的数的位置 需交换
    //从0开始，end结束（不包括end 传入时包括end）
    public static int slip(int start, int end, int[] numberList) {
        int x = numberList[start];
        int xPosition = start;
        for (int i = start + 1; i < end; i++) {
            if (numberList[i] < x) {
                xPosition++;
                if (i != xPosition) {
                    int mid = numberList[i];
                    numberList[i] = numberList[xPosition];
                    numberList[xPosition] = mid;
                }
            }
        }
        int mid = numberList[start];
        numberList[start] = numberList[xPosition];
        numberList[xPosition] = mid;
        return xPosition;
    }

    public static void quickSort(int start, int end, int[] numberList) {
        if (start < end) {
            int mid = slip(start, end, numberList);
            quickSort(start, mid, numberList);
            quickSort(mid + 1, end, numberList);
        }
    }

    //bubble sort small to big
    public static void bubbleSort(int[] numberList) {
        for (int i = 0; i < numberList.length; i++) {
            for (int j = i + 1; j < numberList.length; j++) {
                if (numberList[i] > numberList[j]) {
                    int mid = numberList[i];
                    numberList[i] = numberList[j];
                    numberList[j] = mid;
                }
            }
        }
    }

    //调整最大堆 然后遍历 length就是长度 要减一
    public static void adjustHeap(int[] numberList, int i, int len) {
        int temp = numberList[i];
        for (int j = i * 2 + 1; j < len; j = i * 2 + 1) {
            if (j < len - 1 && numberList[j + 1] > numberList[j]) {
                j++;
            }
            if (temp > numberList[j]) {
                break;
            }
            numberList[i] = numberList[j];
            i = j;
        }
        numberList[i] = temp;
    }

    public static void headSort(int[] numberList) {
        //构造最大堆 i表示位置 所以从一半到0
        for (int i = numberList.length / 2 - 1; i > -1; i--) {
            adjustHeap(numberList, i, numberList.length);
        }

        for (int i = numberList.length - 1; i > 0; i--) {
            int temp = numberList[0];
            numberList[0] = numberList[i];
            numberList[i] = temp;
            adjustHeap(numberList, 0, i);
        }
    }


    public static void main(String[] args) throws IOException {
        int[] a = {522, 9, -1, 3, 999, 555, 454545, -9998, 555};
        int b[]={49, 38, 65, 97, 76, 13, 27, 50 };
        //bubbleSort(a);
        //headSort(a);
        quickSort(0,b.length,b);
        quickSort(0, a.length , a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }

}
