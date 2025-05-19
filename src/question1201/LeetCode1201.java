package src.question1201;

/**
 1201. 丑数 III
 中等
 相关标签
 相关企业
 提示
 丑数是可以被 a 或 b 或 c 整除的 正整数 。

 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。

 示例 1：

 输入：n = 3, a = 2, b = 3, c = 5
 输出：4
 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 示例 2：

 输入：n = 4, a = 2, b = 3, c = 4
 输出：6
 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 示例 3：

 输入：n = 5, a = 2, b = 11, c = 13
 输出：10
 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。


 提示：

 1 <= n, a, b, c <= 109
 1 <= a * b * c <= 1018
 本题结果在 [1, 2 * 109] 的范围内
 */
public class LeetCode1201 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(2, 3,4,5));
    }
}
class Solution {
    /**
     *
     [0, X] 中有多少个丑数，满足一下条件：
     1.该数只能被a整除 (该数一定是a 的整数倍)

     2.该数只能被b整除 (该数一定是b 的整数倍)

     3.该数只能被c整除 (该数一定是c 的整数倍)

     4.该数只能被a和b同时整除 (该数一定是a、b最小公倍数的整数倍)

     5.该数只能被a和c同时整除 (该数一定是a、c最小公倍数的整数倍)

     6.该数只能被b和c同时整除 (该数一定是b、c最小公倍数的整数倍)

     7.该数只能被a和b和c同时整除（该数一定是a、b、c的最小公倍数的整数倍）

     所以，我们只需要分别计算以上七项就能得到结果了！让我们分别来看（用MCM+下标表示最小公倍数）：

     情况1 = X/a - 情况4 - 情况5 - 情况7
     情况2 = X/b - 情况4 - 情况6 - 情况7
     情况3 = X/c - 情况5 - 情况6 - 情况7
     情况4 = X/MCM_a_b - 情况7
     情况5 = X/MCM_a_c - 情况7
     情况6 = X/MCM_b_c - 情况7
     情况7 = X/MCM_a_b_c

     让我们整理上述方程后也就得到：

     sum(情况) = X/a + X/b + X/c - X/MCM_a_b - X/MCM_a_c - X/MCM_b_c + X/MCM_a_b_c
     计算X中包含多少个丑数因子的方法

     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (n < 1 || a < 1 || b < 1 || c < 1) throw new IllegalArgumentException("invalid param");

        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        // 三个数的最小公倍数
        long lcm = lcm(lcmAB, c);

        // lcm之内的数字数目，即一个周期内的元素数
        long m = lcm / a + lcm / b + lcm / c - lcm / lcmAB - lcm / lcmAC - lcm / lcmBC + 1;

        // 周期数
        long epoch = n / m;
        // 缺几个
        long r = n % m;
        long result = epoch * lcm;

        if (r > 0) {
            // 二分查找，范围缩小为1～lcm
            long left = 1, right = lcm;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcm;
                if (count >= r) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 最后left就是要查找的值
            result += left;
        }

        return (int)result;
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公因数
    private long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}
