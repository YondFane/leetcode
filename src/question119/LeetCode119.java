package src.question119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 119. 杨辉三角 II
 * @author YFAN
 * @date 2022/3/13/013
119. 杨辉三角 II
给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
示例 1:
输入: rowIndex = 3
输出: [1,3,3,1]
示例 2:
输入: rowIndex = 0
输出: [1]
示例 3:
输入: rowIndex = 1
输出: [1,1]
提示:
0 <= rowIndex <= 33
进阶：
你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 */
public class LeetCode119 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getRow(3).forEach(System.out::println);
    }
}

class Solution {
    /*
            1
           1 1
          1 2 1
         1 3 3 1
        1 4 6 4 1
     */
    public List<Integer> getRow(int rowIndex) {
        int[] array = new int[rowIndex + 1];
        int[] ans = new int[rowIndex + 1];
        array[0] = 1;
        int index = 1;
        while (index <= rowIndex + 1) {
            for (int i = 0; i < index; i++) {
                if (i == 0 || i == index - 1) {
                    ans[i] = 1;
                } else {
                    ans[i] = array[i] + array[i - 1];
                }
            }
            array = Arrays.copyOf(ans, index);
            index++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int an : ans) {
            list.add(an);
        }
        return list;
    }
}