package src.question647;

/**
 647. 回文子串
 中等
 相关标签
 相关企业
 提示
 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

 回文字符串 是正着读和倒过来读一样的字符串。

 子字符串 是字符串中的由连续字符组成的一个序列。

 示例 1：

 输入：s = "abc"
 输出：3
 解释：三个回文子串: "a", "b", "c"
 示例 2：

 输入：s = "aaa"
 输出：6
 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

 提示：

 1 <= s.length <= 1000
 s 由小写英文字母组成
 */
public class LeetCode647 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("AAA"));
    }
}
class Solution {
    /**
     * 计算有多少个回文子串的最朴素方法就是枚举出所有的回文子串，而枚举出所有的回文字串又有两种思路，分别是
     * 1、枚举出所有的子串，然后再判断这些子串是否是回文；
     * 2、枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候就拓展，否则停止拓展。
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <s.length();i++) {
            // 一个字符或者两个字符作为中心
            for (int j = 0; j<=1;j++) {
                int left = i;
                int right = i+j;
                while (left >= 0 && right< s.length() && s.charAt(left--) == s.charAt(right++)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
