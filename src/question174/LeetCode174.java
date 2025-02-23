package src.question174;

import java.util.Arrays;

/**
 174. 地下城游戏
 困难
 相关标签
 相关企业
 恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

 为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。

 返回确保骑士能够拯救到公主所需的最低初始健康点数。

 注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。


 示例 1：


 输入：dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 输出：7
 解释：如果骑士遵循最佳路径：右 -> 右 -> 下 -> 下 ，则骑士的初始健康点数至少为 7 。
 示例 2：

 输入：dungeon = [[0]]
 输出：1


 提示：

 m == dungeon.length
 n == dungeon[i].length
 1 <= m, n <= 200
 -1000 <= dungeon[i][j] <= 1000
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