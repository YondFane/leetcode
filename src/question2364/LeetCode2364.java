package src.question2364;

import java.util.HashMap;
import java.util.Map;

/**
 2364. 统计坏数对的数目
 中等
 相关标签
 相关企业
 提示
 给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。

 请你返回 nums 中 坏数对 的总数目。

 示例 1：

 输入：nums = [4,1,3,3]
 输出：5
 解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
 数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
 数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
 数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
 数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
 总共有 5 个坏数对，所以我们返回 5 。
 示例 2：

 输入：nums = [1,2,3,4,5]
 输出：0
 解释：没有坏数对。


 提示：

 1 <= nums.length <= 105
 1 <= nums[i] <= 109
 */
public class LeetCode2364 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBadPairs(new int[]{4,1,3,3}));
        System.out.println(solution.countBadPairs(new int[]{1,2,3,4,5}));
    }
}

class Solution {
    /**
     * 数组长度为 n
     * 所有数对数量为 1 + 2 + 3 + ... n
     * 所有数对数量 减去 非坏数对数量 即是 坏数对数量
     * @param nums
     * @return
     */
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for(int i = 0; i < nums.length; i ++) {
            int key = nums[i] - i;
            // 遍历到i时，本来会增加i个数对，减去非坏数对的个数就是新增的坏数对的个数
            res += i - map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }
}

/**
 * 超时
 */
class Solution2 {
    public long countBadPairs(int[] nums) {
        long res = 0;
        for(int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] != (j - i)) {
                    res++;
                }
            }
        }
        return res;
    }
}