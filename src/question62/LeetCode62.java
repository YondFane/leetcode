package src.question62;

import java.math.BigInteger;
/*
 * 62. 不同路径
 * @author YFAN
 * @date 2021/10/24/024
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
示例 1：
输入：m = 3, n = 7
输出：28
示例 2：
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：
输入：m = 7, n = 3
输出：28
示例 4：
输入：m = 3, n = 3
输出：6
提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109
 */
public class LeetCode62 {
    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(1, 100));
    }
}

class Solution {
    public int count = 0;

    /*
     * 这道题是一道数学题
     * 例如m=3,n=2
     * 从左上角到右下角的步数为 m+n-2
     * (m+n-2)步中有(n-1)步是向右的，由此数学的排列组合公式得：
     *  C(n-1,m+n-2) = (m+n-2)!/(n-1)!(m-1)!
     * @author YFAN
     * @date 2021/10/24/024
     * @param  * @param m
     * @param n
     * @return int
     */
    public int uniquePaths(int m, int n) {
        String str = fun(m + n - 2).divide(fun(n - 1)).divide(fun(m - 1)).toString();
        return Integer.valueOf(str);
    }

    /*
     * 求阶层函数
     * @author YFAN
     * @date 2021/10/24/024
     * @param  * @param n
     * @return int
     */
    public BigInteger fun(int n) {
        BigInteger result = new BigInteger("1");
        if (n == 0) {
            return result;
        }
        while (n > 0) {
            result = result.multiply(new BigInteger("" + n));
            n--;
        }
        System.out.println(result);
        return result;
    }
}

/*
 * 优化
 * @author YFAN
 * @date 2021/10/24/024
 */
class Solution2 {
    /*
     * 这道题是一道数学题
     * 例如m=3,n=2
     * 从左上角到右下角的步数为 m+n-2
     * (m+n-2)步中有(n-1)步是向右的，由此数学的排列组合公式得：
     *  C(n-1,m+n-2) = (m+n-2)!/(n-1)!(m-1)!
     * @author YFAN
     * @date 2021/10/24/024
     * @param  * @param m
     * @param n
     * @return int
     */
    public int uniquePaths(int m, int n) {
        int q = m + n - 2;
        int p = Math.min(n - 1, m - 1);
        // 求C(q,p)
        long result = 1;
        int i = 0;
        while (i < p) {
            result *= (q - i);
            result /= (i + 1);
            i++;
        }
        return (int) result;
    }
}
