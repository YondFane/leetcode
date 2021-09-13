package src.question447;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 447. 回旋镖的数量
 * @Author YFAN
 * @Date 2021/9/13
 * @params
 * @return 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 * 提示：
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 */
public class LeetCode447 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;

        for (int[] point1 : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] point2 : points) {
                int distance_2 = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                map.put(distance_2, map.getOrDefault(distance_2, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int t = entry.getValue();
                result += t * (t - 1);
            }
        }
        return result;
    }
}
