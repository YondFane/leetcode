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

        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {0, 1}}));// 3

        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}}));// 4

        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}}));// 4

        System.out.println(solution.largestIsland(new int[][]{
                {0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}
        }));

    }
}

/**
 执行用时分布
 24
 ms
 击败
 100.00%

 */
class Solution {
    int res = 0;
    int col = 0;
    int row = 0;

    public int largestIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        // 面积地图
        int[] counts = new int[row * col + 2];
        // 岛屿编号
        int no = 2;
        // 计算岛屿面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 1 : 未标记编号的岛屿
                if (grid[i][j] == 1) {
                    // 计算岛屿面积
                    int sum = dfs(grid, i, j, no);
                    // 编号+1, 记录岛屿面积
                    counts[no++] = sum;
                    res = Math.max(res, sum);
                }
            }
        }
        if (res >= row * col - 1) {
            return row * col;
        }

        // 连通岛屿，算出最大面积
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 对地图上的海洋部分处理，连接上下左右岛屿面积
                if (grid[i][j] == 0) {
                    int sum = 1;
                    // 上下左右四个岛屿编号
                    int left = 0, right = 0, up = 0, below = 0;
                    if (j > 0)
                        left = grid[i][j - 1];

                    if (j + 1 < col )
                        right = grid[i][j + 1];

                    if (i + 1 < row)
                        below = grid[i + 1][j];

                    if (i > 0)
                        up = grid[i - 1][j];

                    // 左岛屿
                    sum += counts[left];

                    // 右岛屿
                    if(right != left)
                        sum += counts[right];

                    // 上岛屿
                    if(up != left && up != right)
                        sum += counts[up];

                    // 下岛屿
                    if(below != left && below != right && below != up)
                        sum += counts[below];

                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int no) {
        if (x < 0 || y < 0 || y >= col || x >= row || grid[x][y] != 1) {
            return 0;
        }
        // 岛屿编号
        grid[x][y] = no;
        int sum = 1;
        // 上
        sum += dfs(grid, x, y - 1, no);
        // 下
        sum += dfs(grid, x, y + 1, no);
        // 左
        sum += dfs(grid, x - 1, y, no);
        // 右
        sum += dfs(grid, x + 1, y, no);
        return sum;
    }
}


/**
 执行用时分布
 108
 ms
 击败
 24.97%

 消耗内存分布
 76.37
 MB
 击败
 44.52%
 */
class Solution5 {
    int res = 0;
    int col = 0;
    int row = 0;

    // key 岛屿编号 value 面积
    // 主要用来节省遍历时间复杂度
    Map<Integer, Integer> map = new HashMap<>();

    public int largestIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        // 岛屿编号
        int no = 2;
        // 计算岛屿面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 1 : 未标记编号的岛屿
                if (grid[i][j] == 1) {
                    // 计算岛屿面积
                    int sum = dfs(grid, i, j, no);
                    // 记录岛屿面积
                    map.put(no, sum);
                    // 编号+1
                    no++;
                    res = Math.max(res, sum);
                }
            }
        }
        // 连通岛屿，算出最大面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 连通岛屿编号集合
                Set<Integer> noSet = new HashSet<>();
                noSet.add(0);
                int sum = 1;
                // 对地图上的海洋部分处理，连接上下左右岛屿面积
                if (grid[i][j] == 0) {
                    int x = i;
                    int y = j;
                    // 连通上下左右四个岛屿面积之和
                    // 上岛屿
                    x = i;
                    y = j -1;
                    if (y >= 0 && !noSet.contains(grid[x][y])) {
                        sum += map.getOrDefault(grid[x][y], 0);
                        noSet.add(grid[x][y]);
                    }
                    // 下岛屿
                    x = i;
                    y = j + 1;
                    if (y < col && !noSet.contains(grid[x][y])) {
                        // 获取不到岛屿，默认返回0面积
                        sum += map.getOrDefault(grid[x][y], 0);
                        noSet.add(grid[x][y]);
                    }
                    // 左岛屿
                    x = i - 1;
                    y = j;
                    if (x >= 0 && !noSet.contains(grid[x][y])) {
                        sum += map.getOrDefault(grid[x][y], 0);
                        noSet.add(grid[x][y]);
                    }
                    // 右岛屿
                    x = i + 1;
                    y = j;
                    if (x < row && !noSet.contains(grid[x][y])) {
                        sum += map.getOrDefault(grid[x][y], 0);
                        noSet.add(grid[x][y]);
                    }
                }
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int no) {
        if (x < 0 || y < 0 || y >= col || x >= row || grid[x][y] != 1) {
            return 0;
        }
        // 岛屿编号
        grid[x][y] = no;
        int sum = 1;
        // 上
        sum += dfs(grid, x, y - 1, no);
        // 下
        sum += dfs(grid, x, y + 1, no);
        // 左
        sum += dfs(grid, x - 1, y, no);
        // 右
        sum += dfs(grid, x + 1, y, no);
        return sum;
    }
}


/**
 * 第一版解答
 * 超时解答
 */
class Solution3 {
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
                    // 每个岛屿编号
                    int t = i * n + j + 1;
                    // key 岛屿编号 value 岛屿面积
                    area.put(t, dfs(grid, i, j, tag, t));
                    res = Math.max(res, area.get(t));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;
                    // 连接岛屿编号集合
                    Set<Integer> connected = new HashSet<Integer>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k], y = j + d[k + 1];
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
                            continue;
                        }
                        // 获取岛屿面积
                        z += area.get(tag[x][y]);
                        // 添加岛屿
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


/**
 * 优秀解答
 */
class Solution4 {
    // 1. Explore every island using dfs, count its area, give it an island id and save the result to  counts[id] = area map.
    // 2. Loop every cell == 0, check its connected islands and calculate total islands area.
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        // i 编号 坐标值为面积
        int[] counts = new int[ n * n + 2]; // store island size
        int id = 2;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, id);
                    maxSum = Math.max(maxSum,count);
                    counts[id++] = count;
                }
            }
        }

        if(maxSum >= n * n - 1)
            return n * n;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 0)
                    continue;

                int left = 0, right = 0, up = 0, below = 0;

                if (j > 0)
                    left = grid[i][j - 1];

                if (j + 1 < n )
                    right = grid[i][j + 1];

                if (i + 1 < n)
                    below = grid[i + 1][j];

                if (i > 0)
                    up = grid[i - 1][j];

                int sum = 1 + counts[left];

                if(right != left)
                    sum += counts[right];

                if(up != left && up != right)
                    sum += counts[up];

                if(below != left && below != right && below != up)
                    sum += counts[below];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    private int dfs(int[][] grid, int i, int j, int id) {

        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1)
            return 0;

        grid[i][j] = id;
        int size = 1 + dfs(grid, i - 1, j, id)
                + dfs(grid, i + 1, j, id)
                + dfs(grid, i, j - 1, id)
                + dfs(grid, i, j + 1, id);

        return size;
    }
}