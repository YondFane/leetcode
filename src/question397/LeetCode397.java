package src.question397;

/**
 * 397. 整数替换
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/19/019
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class LeetCode397 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.integerReplacement(8));
    }
}

/**
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 35.2 MB
 * , 在所有 Java 提交中击败了
 * 64.48%
 * 的用户
 */
class Solution {
    /**
     * 根据二进制结构解法
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        // int 为4字节整数
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                // 偶数，则用n/2
                n>>=1;
            } else {
                // 奇数 n的二进制最后两位为01或11结尾
                // 01结尾最优解直接n+1
                if ((n & 2) ==0) {
                    n--;
                } else if (n == 3){
                    //11结尾 n等于3时例外 n-1为最优解
                    n--;
                } else {
                    //11结尾 n++
                    n++;
                }
            }
            count++;
        }
        return count;
    }
}

/**
 * 递归解法
 */
class Solution2 {
    long result;

    public int integerReplacement(int n) {
        result = n / 2 + 1;
        fun(n, 0);
        return (int) result;
    }

    public void fun(long n, int count) {
        if (n == 1) {
            result = result > count ? count : result;
        } else if (n > 1) {
            //剪枝
            if (count >= result) {
                return;
            }
            if (n % 2 == 0) {
                fun(n / 2, count + 1);
            } else {
                fun(n + 1, count + 1);
                fun(n - 1, count + 1);
            }
        }
    }
}