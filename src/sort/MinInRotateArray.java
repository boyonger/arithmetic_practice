package sort;

public class MinInRotateArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(findMin(a, 0, a.length - 1));
    }

    public static int findMin(int[] numberList, int start, int end) {
        int mid = (end + start) / 2;
        if (mid == start) {
            return numberList[mid + 1];
        } else {
            if (numberList[mid] > numberList[start]) {
                return findMin(numberList, mid + 1, end);
            } else {
                return findMin(numberList, start, mid);
            }
        }
    }


}
