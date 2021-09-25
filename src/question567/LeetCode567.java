package src.question567;

import java.util.Arrays;

/*
 * 567. 字符串的排列
 * @author YFAN
 * @date 2021/9/25/025
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
换句话说，s1 的排列之一是 s2 的 子串 。
示例 1：
输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：
输入：s1= "ab" s2 = "eidboaoo"
输出：false
提示：
1 <= s1.length, s2.length <= 104
s1 和 s2 仅包含小写字母
 */
public class LeetCode567 {
    public static void main(String[] args) {
        // "abc"
        //"bbbca"
        System.out.println(new Solution().checkInclusion("abc", "bbbca"));
    }
}

class Solution {
    /*
     * 滑动窗口
     * "adc"   "dcda"
     * @author YFAN
     * @date 2021/9/25/025
     * @param  * @param s1
     * @param s2
     * @return boolean
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return  false;
        }
        char[] cur1 = new char[26];
        char[] cur2 = new char[26];
        for(int i = 0; i < n; i++) {
            cur1[s1.charAt(i) - 'a']++;
            cur2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cur1, cur2)) {
            return true;
        }
        for(int i = n; i < m; i++) {
            cur2[s2.charAt(i) - 'a']++;
            cur2[s2.charAt(i- n) - 'a']--;
            if (Arrays.equals(cur1, cur2)) {
                return true;
            }
        }
        return false;
    }
}