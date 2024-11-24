package src.question10;
/**正则表达式匹配
 * @Author YFAN
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

示例 1:
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例 2:
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

示例 3:
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

示例 4:
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

示例 5:
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 **/
public class LeetCode10 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("ab", ".*c"));
    }
}

// 动态规划 2ms 98.85%
class Solution {
    Boolean[][] result;

    public boolean isMatch(String text, String pattern) {
        // memo[i][j] 表示text[0:i]与pattern[0:j]是否匹配
        result = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        // 如果 memo[i][j] 被初始化过，直接返回当前值
        if (result[i][j] != null) {
            return result[i][j];
        }
        // text[0:i]与pattern[0:j]是否匹配的标志位
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            // 判断text[i] 与 pattern[j] 是否匹配
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));
            // pattern[j+1] 是否为 *
            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                // pattern[j+1] 为 * 的两种情况
                // 第一种 * 匹配 0个 前面字符
                // 第二种 * 匹配 大于0个 前面字符
                ans = (dp(i, j+2, text, pattern) || first_match && dp(i+1, j, text, pattern));
            } else {
                // pattern[j+1] 不为 *，则前进一步
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        // 填值
        result[i][j] = ans;
        return ans;
    }
}

// 回溯法 13.54%
class Solution1 {
    public boolean isMatch(String text, String pattern) {
        // pattern为空
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        // 判断text第一个字符是否匹配
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            // pattern 第二个字符为 * 的两种情况
            // 第一种 ee...    c*ee...（first_match为false）
            // 第二种 ew...    e*w...（first_match为ftrue）
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            // pattern 第二个字符不为 *
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
// 回溯法增强版 节省字符串建立 42.15&
class Solution2 {
    public boolean isMatch(String text, String pattern) {
        // pattern为空
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        return fun(0, 0, text, pattern);
    }

    public boolean fun(int i, int j, String text, String pattern) {
        // pattern为空
        if (j == pattern.length()) {
            return i == text.length();
        }
        // 判断text第一个字符是否匹配
        boolean first_match = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (pattern.length() > j + 1 && pattern.charAt(j + 1) == '*'){
            // pattern 第二个字符为 * 的两种情况
            // 第一种 ee...    c*ee...（first_match为false）
            // 第二种 ew...    e*w...（first_match为ftrue）
            return (fun(i, j + 2 , text, pattern) ||
                    (first_match && fun(i + 1, j, text, pattern)));
        } else {
            // pattern 第二个字符不为 *
            return first_match && fun(i + 1, j + 1, text, pattern);
        }
    }
}
