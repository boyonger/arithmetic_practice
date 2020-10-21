package leetcode.numberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
leetcode 15
给定数组 输出和为0的数组 输出集合不能重复
nums = [-1, 0, 1, 2, -1, -4]，
输出集合：
[[-1, 0, 1],[-1, -1, 2]]
 */
public class ThreeSum {

    /*
    先排序(small->big) 然后双指针递增递减
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        quickSort(nums, 0, nums.length);
        // Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int twoTarget = -nums[i];
            // 开始双指针
            int left = i + 1;
            int right = nums.length - 1;
            // left<right多个可能
            while (left < right) {
                while (left < right && left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[left] + nums[right] > twoTarget) {
                    right--;
                }
                while (left < right && nums[left] + nums[right] < twoTarget) {
                    left++;
                }
                if (left < right && nums[left] + nums[right] == twoTarget) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = spilt(nums, start, end);
            quickSort(nums, start, mid);
            quickSort(nums, mid + 1, end);
        }
    }

    public int spilt(int[] nums, int start, int end) {
        //每次为第一个数找到一个合适的位置 && 左边都比他小 右边都比他大
        int startNumber = nums[start];
        int pos = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] < startNumber) {
                pos++;
                if (i != pos) {
                    swap(nums, i, pos);
                }
            }
        }
        swap(nums, start, pos);
        return pos;
    }

    public void swap(int[] a, int aPos, int bPos) {
        int temp = a[aPos];
        a[aPos] = a[bPos];
        a[bPos] = temp;
    }

    public static void main(String[] args) {
        // 2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4
        System.out.println(
                new ThreeSum().threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4}).toString());
    }
}
