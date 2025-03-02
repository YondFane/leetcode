package src.question347;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 347. 前 K 个高频元素
 中等
 相关标签
 相关企业
 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。


 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]


 提示：

 1 <= nums.length <= 105
 k 的取值范围是 [1, 数组中不相同的元素的个数]
 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的


 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class LeetCode347 {

    public static void main(String[] args) {


        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));


        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));

    }
}


/**
 * 优秀解
 */
class Solution {

    /**
     *
     *  1 2 2 3 4 5 5
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // 找出数组中，a 最大值 b 最小值
        int a = nums[0], b = nums[0];
        for (int num : nums) {
            if (num > a) {
                a = num;
            }
            if (num < b) {
                b = num;
            }
        }
        // (a - b + 1) 数据中不重复数字最大数量
        int[] count = new int[a - b + 1];
        for (int num : nums) {
            // 统计频率
            count[num - b]++;
        }
        int index = 0;
        while (index < k) {
            // 频率中出现的最大次数
            int max = 0;
            int j = 0;
            for (int i = 0; i < count.length ;i++) {
                if (count[i] > max) {
                    j = i;
                    max = count[i];
                }
            }
            // 使用count[num - b]++来统计，所以 (j + b) 等于被统计的数字，
            res[index++] = j + b;
            // 重置0，下一轮不计算
            count[j] = 0;
        }
        return res;
    }
}

class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // k 数字 v 频率
        for(int num : nums) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer>[] list = new List[nums.length + 1];
        map.forEach((a,b) -> {
            if (list[b] == null) {
                list[b] = new ArrayList<>();
            }
            list[b].add(a);
        });

        int count = 0;
        for (int i = list.length - 1; i >= 0 && count < k; i--) {
            if (list[i] != null) {
                for (Integer num : list[i]) {
                    res[count++] = num;
                }
            }
        }
        return res;
    }
}