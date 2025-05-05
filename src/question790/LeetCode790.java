package src.question790;

/**
 * 790. 多米诺和托米诺平铺
 * 中等
 * 相关标签
 * 相关企业
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * <p>
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 109 + 7 取模 的值。
 * <p>
 * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: n = 3
 * 输出: 5
 * 解释: 五种不同的方法如上所示。
 * 示例 2:
 * <p>
 * 输入: n = 1
 * 输出: 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class LeetCode790 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilings(3));
    }
}

class Solution {
    // n = 0 ,result = 1, f(0) = 1
    // n = 1 ,result = 1, f(1) = 1
    // n = 2 ,result = 2, f(2) = 2
    // n = 3 ,result = 5 --> f(3) =
    // n = 4 ,5 + 5 + 1,  f[i] = (2 * f[i - 1] + f[i - 3])
    public int numTilings(int n) {
        int mod = 1000000007;
        if (n < 3) {
            return n;
        }
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = (2 * f[i - 1] + f[i - 3]) % mod;
        }
        return (int) f[n];
    }
}