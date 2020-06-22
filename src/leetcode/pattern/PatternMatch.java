package leetcode.pattern;

import com.sun.org.apache.xpath.internal.operations.Bool;

/*
    你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
    例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
    但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
	输入： pattern = "abba", value = "dogcatcatdog"
	输出： true
	示例 2：
	输入： pattern = "abba", value = "dogcatcatfish"
	输出： false
	示例 3：
	输入： pattern = "aaaa", value = "dogcatcatdog"
	输出： false
	示例 4：
	输入： pattern = "abba", value = "dogdogdogdog"
	输出： true
	解释： "a"="dogdog",b=""，反之也符合规则
	提示：
	0 <= len(pattern) <= 1000
	0 <= len(value) <= 1000
	你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class PatternMatch {

    public static boolean patternMatching(String pattern, String value) {
        int aCount = 0, bCount = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        if (aCount < bCount) {
            StringBuilder changePattern = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'a') {
                    changePattern.append('b');
                } else if (pattern.charAt(i) == 'b') {
                    changePattern.append('a');
                }
            }
            pattern = changePattern.toString();
            int temp;
            temp = aCount;
            aCount = bCount;
            bCount = temp;
        }
        if (value.length() == 0) {
            return bCount == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        // 此时已经确保 aCount>bCount 的数量 开始
        for (int len = 0; len * aCount <= value.length(); len++) {
            int rest = value.length() - len * aCount;
            if ((bCount == 0 && rest == 0) || (bCount != 0 && rest % bCount == 0)) {
                int bLength = (bCount == 0 ? 0 : (rest / bCount));
                boolean isCorrect = true;
                // 尝试匹配
                int valuePos = 0;
                String valueA = "", valueB = "";
                for (int patternPos = 0; patternPos < pattern.length(); patternPos++) {
                    if (pattern.charAt(patternPos) == 'a') {
                        String a = value.substring(valuePos, valuePos + len);
                        if (valueA.length() != 0) {
                            if (!a.equals(valueA)) {
                                isCorrect = false;
                                break;
                            }
                        } else {
                            valueA = a;
                        }
                        valuePos += len;
                    } else {
                        String b = value.substring(valuePos, valuePos + bLength);
                        if (valueB.length() == 0) {
                            valueB = b;
                        } else {
                            if (!valueB.equals(b)) {
                                isCorrect = false;
                                break;
                            }
                        }
                        valuePos += bLength;
                    }
                }
                if (isCorrect && !valueA.equals(valueB)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] arg) {
        System.out.println(patternMatching("abba", "dogcatcatdog"));
    }
}
