package src.question22;

import java.util.ArrayList;
import java.util.List;

/**括号生成
 * @Author YFAN
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：
输入：n = 3
输出：[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
 **/
public class LeetCode22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
// 1ms 97.78%
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n > 0) {
            fun(n, n, list, "");
        }
        return list;
    }

    public void fun(int left, int right, List<String> list, String str) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0 && left <= right) {
            fun(left - 1, right, list, str + "(");
            fun(left, right - 1, list, str + ")");
        }
        if (left == 0){
            fun(left, right - 1, list, str + ")");
        }
    }
}