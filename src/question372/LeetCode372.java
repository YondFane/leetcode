package src.question372;

/**
 372. 超级次方
 中等
 相关标签
 相关企业
 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

 示例 1：

 输入：a = 2, b = [3]
 输出：8
 示例 2：

 输入：a = 2, b = [1,0]
 输出：1024
 示例 3：

 输入：a = 1, b = [4,3,3,8,5,2]
 输出：1
 示例 4：

 输入：a = 2147483647, b = [2,0,0]
 输出：1198


 提示：

 1 <= a <= 231 - 1
 1 <= b.length <= 2000
 0 <= b[i] <= 9
 b 不含前导 0
 */
public class LeetCode372 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.superPow(2, new int[]{3}));

    }


}
class Solution {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}