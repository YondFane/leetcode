package src.question459;

/**
 459. 重复的子字符串
 简单
 相关标签
 相关企业
 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。

 示例 1:

 输入: s = "abab"
 输出: true
 解释: 可由子串 "ab" 重复两次构成。
 示例 2:

 输入: s = "aba"
 输出: false
 示例 3:

 输入: s = "abcabcabcabc"
 输出: true
 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)


 提示：

 1 <= s.length <= 104
 s 由小写英文字母组成
 */
public class LeetCode459 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));
    }
}
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i * 2 <= s.length(); i++) {
            if (s.length() % i != 0) {
                continue;
            }
            boolean match = true;
            for(int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return match;
            }
        }
        return false;
    }
}