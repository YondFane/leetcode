package src.question53;

/*
 * 53. 最大子序和
 * @author YFAN
 * @date 2021/9/20/020
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [0]
输出：0
示例 4：
输入：nums = [-1]
输出：-1
示例 5：
输入：nums = [-100000]
输出：-100000
提示：
1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class LeetCode53 {
    public static void main(String[] args) {

    }
}
class Solution {
    /*
     * 动态规划
     * @author YFAN
     * @date 2021/9/20/020
     * @param  * @param nums
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;// 前面元素之和
        int result = nums[0];
        for(int i : nums) {
            // 当前元素 与 当前元素 + pre 比较
            pre = Math.max(i, pre + i);
            // 最大值
            result = Math.max(result, pre);
        }
        return result;
    }
}