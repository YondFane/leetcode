package src.question479;

/**
 * 479. 最大回文数乘积
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * <p>
 * 示例 1:
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 示例 2:
 * 输入： n = 1
 * 输出： 9
 * 提示:
 * 1 <= n <= 8
 */
public class LeetCode479 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestPalindrome(2));
    }
}

class Solution {
    /**
     * 大致思路
     * n = 2 时，假设最大回文数为9999，由2 个 n位数组成
     * 2个n位数 10 * 10 到 99 * 99的范围
     * 回文数左半边范围为 10 - 99
     * 通过遍历左半边范围，依次求出的回文数有  2 * （99 - 10 + 1）个
     * 每个回文数必然右半边的范围也是 10 -99 （从大到小 99 - 10）
     * 遍历所有回文数，从大到小遍历右半边的数字
     * 当右半边数字是当前回文数的因子时，即是答案。
     **/
    public int largestPalindrome(int n) {

        if (n == 1) {
            return 9;
        }
        int ans = 0;
        // 左半边最大值
        int upper = (int) (Math.pow(10, n) - 1);
        for (int left = upper; ans == 0; --left) {
            long p = left;
            // 通过左半边数字获取整个回文数
            int t = left;
            while (t > 0) {
                p = p * 10 + t % 10;
                t /= 10;
            }
            // 从最大值往下找当前最大的因子
            long x = upper;
            while (x * x >= p) {
                // 是否为因子
                if (p % x == 0) {
                    ans = (int) (p % 1337);
                    break;
                }
                x--;
            }
        }
        return ans;
    }
}