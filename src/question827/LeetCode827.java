package src.question827;

import java.util.*;

/**
 827. 最大人工岛
 困难
 相关标签
 相关企业
 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。

 返回执行此操作后，grid 中最大的岛屿面积是多少？

 岛屿 由一组上、下、左、右四个方向相连的 1 形成。

 示例 1:

 输入: grid = [[1, 0], [0, 1]]
 输出: 3
 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 示例 2:

 输入: grid = [[1, 1], [1, 0]]
 输出: 4
 解释: 将一格0变成1，岛屿的面积扩大为 4。
 示例 3:

 输入: grid = [[1, 1], [1, 1]]
 输出: 4
 解释: 没有0可以让我们变成1，面积依然为 4。


 提示：

 n == grid.length
 n == grid[i].length
 1 <= n <= 500
 grid[i][j] 为 0 或 1
 */
public class LeetCode827 {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {0, 1}}));// 3

//        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}}));// 4

        System.out.println(solution.largestIsland(new int[][]{
                {0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}
        }));

    }
}

/**
 * 超时解答
 */
class Solution {
    // 岛屿计数:-1开始降序计数
    int t = -1;
    int res = 0;
    int col = 0;
    int row = 0;

    Set<Integer> set = new HashSet<>();

    public int largestIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        // 标记岛屿
        for (int[] arr : grid) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[i] = t--;
                }
            }
        }
        // 联通计算岛屿最大面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                set.clear();
                if (grid[i][j] == 0) {
                    grid[i][j] = t - 1;
                    int sum = dfs(grid, i, j, 0);
                    //System.out.println("x="+i + ",y=" + j+",sum="+sum);
                    res = Math.max(res, sum);
                    grid[i][j] = 0;
                } else {
                    int sum = dfs(grid, i, j, 0);
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int sum) {
        if (x < 0 || y < 0 || y >= col || x >= row) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        // 访问过不处理
        if (set.contains(grid[x][y])) {
            return 0;
        }
        sum++;
        set.add(grid[x][y]);
        // 上
        sum += dfs(grid, x, y - 1, 0);
        // 下
        sum += dfs(grid, x, y + 1, 0);
        // 左
        sum += dfs(grid, x - 1, y, 0);
        // 右
        sum += dfs(grid, x + 1, y, 0);
        return sum;
    }
}

/**
 作者：力扣官方题解
 链接：https://leetcode.cn/problems/making-a-large-island/solutions/1828969/zui-da-ren-gong-dao-by-leetcode-solution-lehy/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 {
    static int[] d = {0, -1, 0, 1, 0};

    public int largestIsland(int[][] grid) {
        int n = grid.length, res = 0;
        int[][] tag = new int[n][n];
        Map<Integer, Integer> area = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = i * n + j + 1;
                    area.put(t, dfs(grid, i, j, tag, t));
                    res = Math.max(res, area.get(t));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;
                    Set<Integer> connected = new HashSet<Integer>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k], y = j + d[k + 1];
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
                            continue;
                        }
                        z += area.get(tag[x][y]);
                        connected.add(tag[x][y]);
                    }
                    res = Math.max(res, z);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int[][] tag, int t) {
        int n = grid.length, res = 1;
        tag[x][y] = t;
        for (int i = 0; i < 4; i++) {
            int x1 = x + d[i], y1 = y + d[i + 1];
            if (valid(n, x1, y1) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {
                res += dfs(grid, x1, y1, tag, t);
            }
        }
        return res;
    }

    public boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
