package src.question1329;

import java.util.Arrays;

/**
 * 1329. 将矩阵按对角线排序
 *
 * @Author: YFAN
 * @Date: 2021/5/8/008
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。
 * 例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 * 示例 1：
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 示例 2：
 * 输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
 * 输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class LeetCode1329 {
    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        Solution solution = new Solution();
        mat = solution.diagonalSort(mat);
        for (int[] array : mat) {
            System.out.println(Arrays.toString(array));
        }
    }
}

/**
 * 执行用时：
 * 3 ms
 * , 在所有 Java 提交中击败了
 * 93.72%
 * 的用户
 * 内存消耗：
 * 39.5 MB
 * , 在所有 Java 提交中击败了
 * 53.14%
 * 的用户
 */
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        //开始往右走，初始往上走
        boolean runRight = false;
        int row = mat.length;
        int col = mat[0].length;
        // 对角线条数
        int count = row + col - 1;
        // 开始坐标为矩阵左下角
        int x = row - 1;
        int y = 0;
        for (int i = 0; i < count; i++) {
            int x1 = x;
            int y1 = y;
            int row1 = row;
            int col1 = col;
            // 循环找到对角线的第n个最大值放到对角线最后一个坐标上
            while (x1 < row1 && y1 < col1) {
                int max = mat[x1][y1];
                int maxX = x1;
                int maxY = y1;
                int l = 0;
                int r = 0;
                // 最大值
                for (l = x1, r = y1; l < row1 && r < col1; l++, r++) {
                    if (max < mat[l][r]) {
                        max = mat[l][r];
                        maxX = l;
                        maxY = r;
                    }
                }
                //交换
                swapNumer(mat, l - 1, r - 1, maxX, maxY);
                //减少当前对角线最后一个坐标
                row1--;
                col1--;
            }
            //移动坐标
            if (runRight) {
                if (y + 1 < col) {
                    y++;
                }
            } else {
                if (x - 1 < 0) {
                    runRight = true;
                    y++;
                } else {
                    x--;
                }
            }
        }
        return mat;
    }

    // 数组交换
    public void swapNumer(int[][] mat, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return;
        }
        int t = mat[x1][y1];
        mat[x1][y1] = mat[x2][y2];
        mat[x2][y2] = t;
    }
}