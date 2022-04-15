package src.question264;

import java.util.HashSet;

/*
 * 264. 丑数 II
 * @author YFAN
 * @date 2022/4/15/015
给你一个整数 n ，请你找出并返回第 n 个 丑数 。
丑数 就是只包含质因数 2、3 和/或 5 的正整数。
示例 1：
输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
示例 2：
输入：n = 1
输出：1
解释：1 通常被视为丑数。
提示：
1 <= n <= 1690
 */
public class LeetCode264 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.nthUglyNumber(10));
        System.out.println(System.currentTimeMillis() - start);
    }

}

class Solution {
    // 动态规划
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}

// 超时
class Solution1 {
    private HashSet<Integer> set = new HashSet<>();

    public int nthUglyNumber(int n) {
        int i = 1;
        while (n > 0) {
            if (isUgly(i)) {
                n--;
                set.add(i);
            }
            i++;
        }
        return i - 1;
    }

    private boolean isUgly(int n) {
        while (n > 0) {
            if (set.contains(n) || n == 2 || n == 3 || n == 5 || n == 1) {
                return true;
            }
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return false;
    }
}