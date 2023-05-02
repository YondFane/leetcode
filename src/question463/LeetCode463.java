package src.question463;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: src.question463
 * @Description: TODO
 * @Author: YFAN
 * @CreateTime: 2023-05-02 22:32
 * @Version: 1.0
 */
public class LeetCode463 {

    public static void main(String[] args) {

    }

}

class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int newX = i;
                    int newY = j;
                    switch (k) {
                        case 0:
                            newX--;// 上
                            break;
                        case 1:
                            newX++;// 下
                            break;
                        case 2:
                            newY--;// 左
                            break;
                        case 3:
                            newY++;// 右
                            break;
                    }
                    if (newX < 0 ||newY < 0 || newY >= cols
                            || newX >= rows || grid[newX][newY] == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}