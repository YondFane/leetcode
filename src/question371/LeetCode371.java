package src.question371;

/*
 * 371. 两整数之和
 * @author YFAN
 * @date 2021/9/26/026
给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
示例 1：
输入：a = 1, b = 2
输出：3
示例 2：
输入：a = 2, b = 3
输出：5
提示：
-1000 <= a, b <= 1000
 */
public class LeetCode371 {
    public static void main(String[] args) {
        System.out.println(new Solution().getSum(1, 1));
    }
}

class Solution {
    /*
     * 在不考虑进位的情况下，其无进位加法结果为 a ^ b。
     * 而所有需要进位的位为 a & b，进位后的进位结果为 (a & b) << 1。
     * @author YFAN
     * @date 2021/9/26/026
     * @param  * @param a
     * @param b
     * @return int
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}