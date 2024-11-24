package src.question867;

import java.util.Arrays;

/**转置矩阵
 * @Author YFAN
 * @Description 
 * @Date 17:03 2021/2/25/025
 * @Param
 * @return
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 **/
public class LeetCode867 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},
                                    {4,5,6}
                                    /*{7,8,59,4,6},
                                    {13,8,25,4,6},
                                    {7,8,91,4,45}*/};
        Solution solution = new Solution();
        matrix = solution.transpose(matrix);
        for(int[] tmp: matrix) {
            System.out.println(Arrays.toString(tmp));
        }
    }
    /**
      1 2 3   1 4 2 5 3 6  0,0 0,1 0,2  0,0 1,0 2,0 0,1 1,1 2,1
      4 5 6                1,0 1,1 1,2
     **/
}
class Solution {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length ==0) {
        } else {
            // 循环次数
            int count = matrix[0].length;
            int[][] arrays = new int[count][matrix.length];
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j< matrix[i].length; j++) {
                    arrays[j][i] = matrix[i][j];
                }
            }
            return arrays;
        }
        return matrix;
    }
}