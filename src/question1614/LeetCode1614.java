package src.question1614;

/**
 1614. 括号的最大嵌套深度
 简单
 相关标签
 相关企业
 提示
 给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。
 示例 1：
 输入：s = "(1+(2*3)+((8)/4))+1"
 输出：3

 解释：数字 8 在嵌套的 3 层括号中。
 示例 2：
 输入：s = "(1)+((2))+(((3)))"
 输出：3
 解释：数字 3 在嵌套的 3 层括号中。

 示例 3：
 输入：s = "()(())((()()))"
 输出：3

 提示：

 1 <= s.length <= 100
 s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 题目数据保证括号字符串 s 是 有效的括号字符串
 */
public class LeetCode1614 {


    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.maxDepth("()(())((()()))"));

    }

}
class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left += 1;
                max = Math.max(max, left);
            }
            if (c == ')') {
                left -= 1;
            }
        }
        return max;
    }
}