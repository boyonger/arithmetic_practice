package leetcode;

/*
leetcode 53
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/

public class MaxContinuousSum {

    public int maxSubArray(int[] nums) {
        // 没写出来的 懒得写
        // 从头往后 两个数两个数计算 正数收下 负数舍弃
        // 找到第一个正数
        int[] naxSub = new int[nums.length];
        int mid = 0;
        int subSum = 0;
        for (int i = 0; i < nums.length; i++) {
            mid += nums[i];
            subSum += nums[i];
            if (mid <= 0) {
                //舍弃
                mid = 0;
                subSum = 0;
            }
        }
        return subSum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 6};
        System.out.println(new MaxContinuousSum().maxSubArray(a));
    }
}
