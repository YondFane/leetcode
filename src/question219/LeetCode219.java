package src.question219;

import java.util.HashSet;
import java.util.TreeSet;

/*
 * 219. 存在重复元素 II
 * @author YFAN
 * @date 2022/4/21/021
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
示例 1：
输入：nums = [1,2,3,1], k = 3
输出：true
示例 2：
输入：nums = [1,0,1,1], k = 1
输出：true
示例 3：
输入：nums = [1,2,3,1,2,3], k = 2
输出：false
提示：
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
public class LeetCode219 {
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i]);
            if (ceiling != null && ceiling == nums[i]) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}