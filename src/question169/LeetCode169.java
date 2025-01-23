package src.question169;

/**
 * @ClassName: LeetCode169
169. 多数元素
简单
相关标签
相关企业
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：
输入：nums = [2,2,1,1,1,2,2]
输出：2
提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * @Author: yangfan
 * @Date: 2025-01-23 14:07
 **/
public class LeetCode169 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,4,4,3,3,3,3,3,3,2,2,1,1,1,2,2,3,3,3};
        System.out.println(solution.majorityElement(nums));
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
