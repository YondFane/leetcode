package src.question174;

import java.util.Arrays;

/**
 * @ClassName: LeetCode174
 * @Description:
 * @Author: yangfan
 * @Date: 2025-02-23 10:21
 **/
public class LeetCode174 {
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        Solution solution = new Solution();
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;

        // dp[i][j] 表示从 (i,j) 到出口的最小生命值
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 设置到达出口后的最小生命值为1
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                /**
                 *
                 *   y 3 %
                 *   2 x a
                 *   % b %
                 *
                 *   y 到达 x 的最小生命值
                 *   只需要判断 max(min(a,b) - x), 1) 的最大值
                 *   那么就是y的最小初始值
                 *
                 */
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}