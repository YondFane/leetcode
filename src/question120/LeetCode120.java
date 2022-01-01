package src.question120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 120. 三角形最小路径和
 * @author YFAN
 * @date 2022/1/1/001
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：

输入：triangle = [[-10]]
输出：-10
提示：
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 */
public class LeetCode120 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(-1));
        lists.add(Arrays.asList(2,3));
        lists.add(Arrays.asList(1,-1,-3));
//        lists.add(Arrays.asList(4,1,8,3));
        System.out.println(solution.minimumTotal(lists));
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] f = new int[triangle.size()];
        f[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            f[i] = f[i-1]+triangle.get(i).get(i);
            for(int j = i - 1; j > 0; j--) {
                f[j] = Math.min(f[j - 1],f[j]) + triangle.get(i).get(j);
            }
            f[0]+=triangle.get(i).get(0);
        }
        int result = f[0];
        for (int i = 1;i<f.length;i++){
            result = Math.min(result, f[i]);
        }
        return result;
    }
}