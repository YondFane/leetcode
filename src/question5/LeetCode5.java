package src.question5;

/**最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 **/
public class LeetCode5 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("dfgaaasgd"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        int[] range = new int[2];
        for (int i = 0; i < len; i++) {
            i = fun(str, i, range);
        }

        return s.substring(range[0], range[1]+1);
    }

    public int fun(char[] str, int i, int[] range) {
        int j = i;
        int len = str.length;
        // 寻找回文串的中心部分
        while (j < len - 1 && str[j + 1] == str[i]) {
            j++;
        }
        // 中心部分最右边界值
        int result = j;
        // 中心部分左右相等的字符
        while (i > 0 && j < len - 1 && str[i - 1] == str[j + 1]) {
            i--;
            j++;
        }
        // 记录最大长度
        if (j - i > range[1] - range[0]) {
            range[0] = i;
            range[1] = j;
        }
        return result;
    }
}
