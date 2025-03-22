package src.question2643;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: src.question2643
 * @Author: YANF
 * @CreateTime: 2025-03-22  22:03
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode2643 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = {{0,1,1},{1,1,0},{0,1,0}};
        System.out.println(Arrays.toString(solution.rowAndMaximumOnes(mat)));

    }
}

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                count+= mat[i][j];
            }
            if (res[1] < count) {
                res[0] = i;
                res[1] = count;
            }
            if (count == mat[i].length) {
                return res;
            }
        }
        return res;
    }
}