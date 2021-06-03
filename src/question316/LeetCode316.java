package src.question316;

/**
 * @Description 316. 去除重复字母
 * @Author YFAN
 * @Date 2021/6/3
 * @params
 * @return 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class LeetCode316 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabcba"));
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        //计算器
        int[] count = new int[26];
        //是否操作过
        boolean[] option = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // 单调栈
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //改字母是否操作过
            if (!option[c - 'a']) {
                // 将栈顶大于c的字母出栈
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                    //如果栈顶字母小于等于0不做出栈操作
                    if (count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        option[sb.charAt(sb.length() - 1) - 'a'] = false;
                        //出栈
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        //不能打乱字符串排序
                        break;
                    }
                }
                //入栈
                sb.append(c);
                option[c - 'a'] = true;
            }
            //计数--
            count[c - 'a']--;
        }
        return sb.toString();
    }
}