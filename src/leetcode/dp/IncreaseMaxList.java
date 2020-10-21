package leetcode.dp;

import java.util.Arrays;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18] [-10,100,2,102,5,6,7,8,-13,103]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class IncreaseMaxList {

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] minNumList = new int[nums.length];
        int len = 0;
        minNumList[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 对于最后一个数字比它大 直接增加
            if (nums[i] > minNumList[len]) {
                len++;
                minNumList[len] = nums[i];
            } else {
                // 找到一个比它小的数字
                int pos = divFind(minNumList, nums[i], 0, len);
                if (minNumList[pos] > nums[i]) {
                    minNumList[pos] = nums[i];
                } else if (minNumList[pos] < nums[i]) {
                    minNumList[pos + 1] = nums[i];
                }
            }
        }
        return len + 1;
    }

    public int divFind(int[] a, int num, int start, int end) {
        int mid = (start + end) / 2;
        if (mid == start) {
            return mid;
        }
        if (a[mid] > num) {
            return divFind(a, num, start, mid);
        } else if (a[mid] < num) {
            return divFind(a, num, mid, end);
        } else {
            return mid;
        }
    }

    public int increase(int[] a) {
        if (a.length < 1) {
            return 0;
        }
        int[] maxList = new int[a.length];
        Arrays.fill(maxList, 1);
        // n2 动态规划
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    maxList[i] = Math.max(maxList[i], maxList[j] + 1);
                }
            }
        }
        return maxList[maxList.length - 1];
    }

    public static void main(String[] args) {
        int v = new IncreaseMaxList().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(v);
    }
}
