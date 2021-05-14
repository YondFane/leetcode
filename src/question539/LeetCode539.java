package src.question539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 *
 * @Description:
 * @Param:
 * @return:
 * @Author: YFAN
 * @Date: 2021/5/14/014
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * 提示：
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 */
public class LeetCode539 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        Solution solution = new Solution();
        System.out.println(solution.findMinDifference(list));
    }
}

/**
 * 执行用时：
 * 10 ms
 * , 在所有 Java 提交中击败了
 * 30.75%
 * 的用户
 * 内存消耗：
 * 37.3 MB
 * , 在所有 Java 提交中击败了
 * 99.78%
 * 的用户
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] array = new int[timePoints.size()];
        int i = 0;
        int minDifference = 1440;
        for (String str : timePoints) {
            if ("00:00".equals(str)) {
                array[i++] = 1440;
                continue;
            }
            array[i++] = char2int(str.charAt(0)) * 600 + char2int(str.charAt(1)) * 60 + char2int(str.charAt(3)) * 10 + char2int(str.charAt(4));
        }
        Arrays.sort(array);
        for (int j = 0; j < array.length - 1; j++) {
            int temp = array[j + 1] - array[j];
            minDifference = minDifference < temp ? minDifference : temp;
        }
        int temp = 1440 - array[array.length - 1] + array[0];
        minDifference = minDifference < temp ? minDifference : temp;
        return minDifference;
    }
    private int char2int(char c) {
        int result = c - 48;
        return result;
    }
}

/**
 * 执行用时：
 * 10 ms
 * , 在所有 Java 提交中击败了
 * 30.75%
 * 的用户
 * 内存消耗：
 * 39.8 MB
 * , 在所有 Java 提交中击败了
 * 36.34%
 * 的用户
 */
class Solution2 {
    public int findMinDifference(List<String> timePoints) {
        int[] array = new int[timePoints.size()];
        int i = 0;
        int minDifference = 1440;
        for (String str : timePoints) {
            if ("00:00".equals(str)) {
                array[i++] = 1440;
                continue;
            }
            String[] split = str.split(":");
            array[i++] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        Arrays.sort(array);
        for (int j = 0; j < array.length - 1; j++) {
            int temp = array[j + 1] - array[j];
            minDifference = minDifference < temp ? minDifference : temp;
        }
        int temp = 1440 - array[array.length - 1] + array[0];
        minDifference = minDifference < temp ? minDifference : temp;
        return minDifference;
    }
}