package src.question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 56. 合并区间
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 示例 1：
 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：
 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 提示：
 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 */
public class LeetCode56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arrays = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] arrays2 = new int[][]{
                {1,4},{2,3}
        };

        int[][] merge = solution.merge(arrays2);
        System.out.println(Arrays.deepToString(merge));
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            // 判断最后一个区间的最大值是否小于当前区间最小值
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                // 最后一个区间的最大值和当前区间最大值比较并重新赋值最大值
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}