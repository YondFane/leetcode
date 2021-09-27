package src.question695;

import java.util.Arrays;

/*
 * 695. 岛屿的最大面积
 * @author YFAN
 * @date 2021/9/27/027
给你一个大小为 m x n 的二进制矩阵 grid 。
岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

示例 1：
输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
示例 2：
输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 为 0 或 1
 */
public class LeetCode695 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0}, {0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1}, {1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1}};
        System.out.println(new Solution2().maxAreaOfIsland(grid));
    }
}

class Solution {
    private int result;
    // 上下左右
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 存在岛屿则进行深度遍历
                if (grid[i][j] == 1) {
                    result = Math.max(result, def(visited, grid, i, j));
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return result;
    }
    /*
     * 深度遍历
     * 找出岛屿面积
     * @author YFAN
     * @date 2021/9/27/027
     * @param  * @param visited
     * @param grid
     * @param x
     * @param y
     * @return int
     */
    private int def(boolean[][] visited, int[][] grid, int x, int y) {
        if (!visited[x][y]) {
            int area = grid[x][y];
            // 标记访问
            visited[x][y] = true;
            for (int[] array : direction) {
                int newX = x + array[0];
                int newY = y + array[1];
                // 判断边界
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1) {
                    area += def(visited, grid, newX, newY);
                }
            }
            return area;
        } else {
            return 0;
        }
    }
}
/*
 * 优化
 * 去掉visited标记访问数组
 * @author YFAN
 * @date 2021/9/27/027
 * @param  * @param null
 * @return
 */
class Solution2 {
    private int result;
    // 上下左右
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 存在岛屿则进行深度遍历
                if (grid[i][j] == 1) {
                    result = Math.max(result, def(grid, i, j));
                }
            }
        }
        return result;
    }
    /*
     * 深度遍历
     * 找出岛屿面积
     * @author YFAN
     * @date 2021/9/27/027
     * @param grid
     * @param x
     * @param y
     * @return int
     */
    private int def(int[][] grid, int x, int y) {
        int area = grid[x][y];
        if (area == 1) {
            // 改为 0
            grid[x][y] = 0;
            for (int[] array : direction) {
                int newX = x + array[0];
                int newY = y + array[1];
                // 判断边界
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1) {
                    area += def(grid, newX, newY);
                }
            }
        }
        return area;
    }
}