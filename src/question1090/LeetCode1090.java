package src.question1090;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LeetCode1090
1090. 受标签影响的最大值
中等
相关标签
相关企业
提示
以两个整数数组  values 和 labels 给定 n 个项的值和标签，并且给出两个整数 numWanted 和 useLimit 。

你的任务是从这些项中找到一个值的和 最大 的子集使得：

项的数量 最多 为 numWanted。
相同标签的项的数量 最多 为 useLimit。
返回最大的和。

示例 1：

输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1

输出：9

解释：

选择的子集是第一个、第三个和第五个项，其值之和为 5 + 3 + 1。

示例 2：

输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2

输出：12

解释：
选择的子集是第一个、第二个和第三个项，其值之和为 5 + 4 + 3。

示例 3：

输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1

输出：16

解释：

选择的子集是第一个和第四个项，其值之和为 9 + 7。

提示：

n == values.length == labels.length
1 <= n <= 2 * 104
0 <= values[i], labels[i] <= 2 * 104
1 <= numWanted, useLimit <= n
 * @Author: yangfan
 * @Date: 2025-01-24 15:35
 **/
public class LeetCode1090 {

    public static void main(String[] args) {
        int[] values = {5,4,3,2,1};
        int[] labels = {1,1,2,2,3};
        int numWanted = 3;
        int useLimit = 1;
        Solution solution = new Solution();
        System.out.println(solution.largestValsFromLabels(values, labels, numWanted, useLimit));
    }

}
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int ans = 0;
        Integer[] numInexs = new Integer[values.length];
        for (int i = 0; i < numInexs.length;i++) {
            numInexs[i] = i;
        }
        Arrays.sort(numInexs, (a, b) -> values[b] - values[a]);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numInexs.length; i++) {
            int index = numInexs[i];
            Integer count = map.getOrDefault(labels[index], 0);
            if (count < useLimit) {
                ans += values[index];
                map.put(labels[index], count + 1);
                numWanted--;
            }
            if (numWanted == 0) {
                break;
            }
        }
        return ans;
    }
}