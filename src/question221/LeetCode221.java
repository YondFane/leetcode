package src.question221;

/*
 * 221. 最大正方形
 * @author YFAN
 * @date 2022/6/1/001
221. 最大正方形
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
示例 1：
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
示例 2：
输入：matrix = [["0","1"],["1","0"]]
输出：1
示例 3：
输入：matrix = [["0"]]
输出：0
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] 为 '0' 或 '1'
 */
public class LeetCode221 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(matrix));
    }
}
// 动态规划
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int colmn = matrix[0].length;
        int[][] dp = new int[row][colmn];
        int maximalSquare = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colmn; j++) {
                if (matrix[i][j] == '1') {
                    // 边界默认为 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 找到左上方、左方、上方的最小值 + 1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maximalSquare = Math.max(dp[i][j], maximalSquare);
                }
            }
        }
        return maximalSquare * maximalSquare;
    }
}