package 无重复字符的最长子串_3;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring("pwwkew");

        System.out.println(result);
        // a a b c d b
    }
}
// 3ms 97.97%
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s != null && s.length() != 0) {
            max = 1;
            int len = s.length();
            // i为字符串开始位置 j为字符串结束位置，（j-i+1）为当前子字符串长度
            for (int i = 0, j = 0; j < len; j++) {
                // 获取字符在字符串第一次出现的位置
                int index = s.indexOf(s.charAt(j), i);
                // 初始位置小于当前位置 则有重复字符
                if (index < j) {
                    // 重新定义字符串开始位置
                    i = index + 1;
                }
                max = max > j - i + 1 ? max : j - i + 1;
            }
        }
        return max;
    }
}
// 10ms 70%
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s != null && s.length() != 0) {
            HashSet<Character> set = new HashSet<>();
            int len = s.length();
            int i = 0;// 字符删除位
            int j = 0;// 字符读取位
            while (i < len && j < len) {
                // 判断set集合中是否有该字符
                if (!set.contains(s.charAt(j))) {
                    // 没有则添加进set集合中
                    set.add(s.charAt(j++));
                    // 刷新最大值
                    max = max > j - i ? max : j - i;
                } else {
                    // 有则删除s字符串中位置i的字符，i++
                    set.remove(s.charAt(i++));
                }
            }
        }
        return max;
    }
}
// 15ms 30%
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s != null && s.length() != 0) {
            result = 1;
            int len = s.length();
            String str = "";
            for (int i = 0; i < len; i++) {
                String temp = s.charAt(i) + "";
                if (str.contains(temp)) {
                    result = result > str.length() ? result : str.length();
                    str = str.substring(str.indexOf(temp) + 1) + temp;
                } else {
                    str += temp;
                }
                if (result > len - i + str.length()) {
                    break;
                }
            }
            return result > str.length() ? result : str.length();
        }
        return result;
    }
}