package src.question1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: LeetCode1353
1353. 最多可以参加的会议数目
中等
提示
给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。

你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。

请你返回你可以参加的 最大 会议数目。

示例 1：

输入：events = [[1,2],[2,3],[3,4]]
输出：3
解释：你可以参加所有的三个会议。
安排会议的一种方案如上图。
第 1 天参加第一个会议。
第 2 天参加第二个会议。
第 3 天参加第三个会议。
示例 2：

输入：events= [[1,2],[2,3],[3,4],[1,2]]
输出：4

提示：

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
 * @Author: yangfan
 * @Date: 2025-01-24 16:08
 **/
public class LeetCode1353 {
    public static void main(String[] args) {

        // [[1,2],[1,2],[3,3],[1,5],[1,5]]
       int[][] events = {{1,2},{1,2},{3,3},{1,5},{1,5}};

        Solution solution = new Solution();
        System.out.println(solution.maxEvents(events));
    }
}

class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        // 按照开始时间升序排列，这样，对于相同开始时间的会议，可以一起处理
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 小顶堆：用于高效的维护最小的 endDay
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int currDay = 1;
        int i = 0;
        while (i < n || !pq.isEmpty()) {
            // 将所有开始时间等于 currDay 的会议的结束时间放到小顶堆
            while (i < n && events[i][0] == currDay) {
                pq.add(events[i][1]);
                i++;
            }

            // 将已经结束的会议弹出堆中，即堆顶的结束时间小于 currDay 的
            while (!pq.isEmpty() && pq.peek() < currDay) {
                pq.remove();
            }

            // 贪心的选择结束时间最小的会议参加
            if (!pq.isEmpty()) {
                // 参加的会议，就从堆中删除
                pq.remove();
                res++;
            }

            // 当前的天往前走一天，开始看下下一天能不能参加会议
            currDay++;
        }

        return res;
    }
}