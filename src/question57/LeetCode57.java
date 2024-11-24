package src.question57;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/4/28/028
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */
public class LeetCode57 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {7, 8}};
        int[] newInterval = {3, 6};
        solution.insert(intervals,newInterval);
        //输出
        for (int[] array : intervals) {
            System.out.println(Arrays.toString(array));
        }
    }
}

class Solution {
    /**
     * 解题思路
     * 找到newInterval在intervals的并集
     * 然后返回
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        // isCross是否存在交集
        boolean isCross = false;
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] array : intervals) {

            if (array[0] > right) {
                //与右边区间无交集 例如 [1,3] [7,8] && [4,5]
                if (!isCross) {
                    isCross = true;
                    list.add(new int[]{left, right});
                }
                list.add(array);
            } else if (array[1] < left) {
                //与左边区间无交集 例如 [4,7] [8,9] && [2,3]
                list.add(array);
            } else {
                //有交集   [1,3] [4,6] &&  [2,5]
                left = Math.min(left, array[0]);
                right = Math.max(right, array[1]);
            }
        }
        if (!isCross) {
            list.add(new int[]{left, right});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}