package src.question62;

import java.math.BigInteger;

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
