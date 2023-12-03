package src.question414;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 414. 第三大的数
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 */
public class LeetCode414 {
    public static void main(String[] args) {
        System.out.println(new Solution2().thirdMax(new int[]{2, 2, 3, 1}));

    }
}

class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long thrid = Long.MIN_VALUE;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            if (num > first) {
                thrid = second;
                second = first;
                first = num;
            } else if (num > second) {
                thrid = second;
                second = num;
            } else if (num > thrid) {
                thrid = num;
            }
        }
        return set.size() > 2 ? (int) thrid : (int) first;
    }
}

/**
 * 优秀题解
 */
class Solution2 {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (first < num) {
                third = second;
                second = first;
                first = num;
            } else if (first > num && second < num) {
                third = second;
                second = num;
            } else if (second > num && third < num) {
                third = num;
            }
        }

        if (third == Long.MIN_VALUE) {
            return (int) first;
        }
        return (int) third;
    }
}