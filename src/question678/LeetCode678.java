package src.question678;

/**
 * @Description 678. 有效的括号字符串
 * @Author YFAN
 * @Date 2021/9/14
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 * <p>
 * 输入: "(*))"
 * 输出: True
 * 注意:
 * <p>
 * 字符串大小将在 [1，100] 范围内。
 */
public class LeetCode678 {
    public static void main(String[] args) {

    }
}

class Solution {
    /**
     * @return boolean
     * 因为 * 可能为（ 也可能为 ），
     * 当 * 为 ( , 左括号存在最大值，
     * 当 * 为 ），左括号存在最小值，
     * @Description 贪心算法
     * @Author YFAN
     * @Date 2021/9/14
     * @params [s]
     */
    public boolean checkValidString(String s) {
        int minLeft = 0;// 左括号最小数量
        int maxLeft = 0;// 左括号最大数量
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 遇到左括号时，minLeft和maxLeft都加1
                minLeft++;
                maxLeft++;
            } else if (c == ')') {
                // 遇到右括号时，minLeft和maxLeft都减1，不让minLeft小于0
                minLeft = Math.max(minLeft - 1, 0);
                maxLeft--;
                // 最大左括号数量小于0直接返回false
                if (maxLeft < 0) {
                    return false;
                }
            } else {
                // 遇到 * 时，minLeft -1，maxLeft + 1, 不让minLeft小于0
                minLeft = Math.max(minLeft - 1, 0);
                maxLeft++;
            }
        }
        return minLeft == 0;
    }
}
