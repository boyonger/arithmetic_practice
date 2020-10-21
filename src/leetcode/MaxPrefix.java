package leetcode;

/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */
public class MaxPrefix {

    /*public String longestCommonPrefix(String[] strs) {
        String a=strs[0];
        if (a.equals("")){
            return "";
        }
        
    }*/

    static int maxSum(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= 0) {
                res = Math.max(res, sum);
            } else {
                sum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1, 2, 3, -1, 2, -1}));
        // System.out.println(maxSum(new int[]{-2, -1, -3}));
    }
}
