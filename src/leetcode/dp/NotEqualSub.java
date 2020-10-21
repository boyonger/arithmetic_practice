package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/*
  leetcode 3
  abcabcbb -> abc 3
  pwwkew -> wke 3
  aab -> ab 2
  bpfbhmipx -> 7
  
  滑动窗口逻辑：左右指针 先左指针不变 右指针移动 直到出现重复 左指针向右移动 右指针继续
  优化逻辑：左右指针 左指针不变 右指针移动 直到出现重复 定位到重复的位置 左指针移动到重复的位置 右指针继续
 */
public class NotEqualSub {

    public int judgeLongSub(String content) {
        int subMaxCount = 0;
        int deleteStartPos = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
            Character subChar = content.charAt(i);
            Integer pos = map.getOrDefault(subChar, -1);
            // 非常巧妙 不需要remove map的值 但也能过滤计算之前的子串值
            if (deleteStartPos <= pos) {
                // 滑动窗口 删除之前的
                int curMax = i - deleteStartPos;
                subMaxCount = Math.max(subMaxCount, curMax);
                deleteStartPos = pos + 1;
            }
            map.put(subChar, i);
        }
        subMaxCount = Math.max(subMaxCount, content.length() - deleteStartPos);
        return subMaxCount;
    }

    public static void main(String[] args) {
        System.out.println(new NotEqualSub().judgeLongSub("abba"));
    }
}
