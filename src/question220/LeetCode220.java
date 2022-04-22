package src.question220;

import java.util.TreeSet;

/*
 * 220. 存在重复元素 III
 * @author YFAN
 * @date 2022/4/21/021
220. 存在重复元素 III
给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
如果存在则返回 true，不存在返回 false。
示例 1：
输入：nums = [1,2,3,1], k = 3, t = 0
输出：true
示例 2：
输入：nums = [1,0,1,1], k = 1, t = 2
输出：true
示例 3：
输入：nums = [1,5,9,1,5,9], k = 2, t = 3
输出：false
提示：
0 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1
 */
public class LeetCode220 {
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            // 查找大于或等于x的数
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            // 符合abs(nums[i] - nums[j]) <= t
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 滑动窗口，符合abs(i - j) <= k
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}