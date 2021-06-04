package src.question402;

/**
 * @Description 402. 移掉K位数字
 * @Author YFAN
 * @Date 2021/6/4
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class LeetCode402 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1432219", 3));
    }
}
/**
* @Description 贪心 + 单调栈
* @Author YFAN
* @Date 2021/6/4
*/
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            //当前数字跟栈顶数字比较，栈顶数字大于当前数字则出栈
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > c) {
                // 出栈
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            // 入栈
            sb.append(c);
        }
        //删掉栈顶剩下数字
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        //去除先导0
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}