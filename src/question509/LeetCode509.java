package src.question509;

/*
 * 509. 斐波那契数
 * @author YFAN
 * @date 2021/9/21/021
斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。
示例 1：
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1
示例 2：
输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2
示例 3：
输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */
public class LeetCode509 {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(4));
    }
}

class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}