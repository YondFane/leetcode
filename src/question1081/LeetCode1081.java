package src.question1081;

/**
* @Description 1081. 不同字符的最小子序列
* @Author YFAN
* @Date 2021/6/3 
返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
示例 1：
输入：s = "bcabc"
输出："abc"
示例 2：
输入：s = "cbacdcbc"
输出："acdb"
提示：
1 <= s.length <= 1000
s 由小写英文字母组成
*/
public class LeetCode1081 {
}

class Solution {
    public String smallestSubsequence(String s) {
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