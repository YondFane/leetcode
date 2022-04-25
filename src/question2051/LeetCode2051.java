package src.question2051;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 2051.花期内花的数目
 * @author YFAN
 * @date 2022/4/25/025
给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 persons ，persons[i] 是第 i 个人来看花的时间。
请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
示例 1：
输入：flowers = [[1,6],[3,7],[9,12],[4,13]], persons = [2,3,7,11]
输出：[1,2,2,2]
解释：上图展示了每朵花的花期时间，和每个人的到达时间。
对每个人，我们返回他们到达时在花期内花的数目。
示例 2：
输入：flowers = [[1,10],[3,3]], persons = [3,3,2]
输出：[2,2,1]
解释：上图展示了每朵花的花期时间，和每个人的到达时间。
对每个人，我们返回他们到达时在花期内花的数目。
提示：
1 <= flowers.length <= 5 * 104
flowers[i].length == 2
1 <= starti <= endi <= 109
1 <= persons.length <= 5 * 104
1 <= persons[i] <= 109
 */
public class LeetCode2051 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.fullBloomFlowers(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}},
                new int[]{2, 3, 7, 11});
        Arrays.stream(result).forEach(System.out::println);
    }
}

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Integer[] indexs = new Integer[persons.length];
        // 填充
        for (int i = 0; i < persons.length; i++) {
            indexs[i] = i;
        }
        // 根据persons的值将indexs排序
        Arrays.sort(indexs, (a, b) -> persons[a] - persons[b]);
        // 将花按照开花时期排序
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);

        int[] result = new int[persons.length];
        for (int i = 0, j = 0; i < persons.length; i++) {
            // 将当前花期开启小于等于看花时间压入队列（来之前话还没开）
            while (j < flowers.length && flowers[j][0] <= persons[indexs[i]]) {
                queue.offer(flowers[j][1]);
                j++;
            }
            // 将队列头部元素小于当前看花时间的队列元素去掉（没来前花就凋零了）
            while (!queue.isEmpty() && queue.peek() < persons[indexs[i]]) {
                queue.poll();
            }
            // 队列中剩下为绽放的花
            result[indexs[i]] = queue.size();
        }
        return result;
    }
}