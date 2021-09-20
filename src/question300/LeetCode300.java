package src.question300;

/*
 * 300. 最长递增子序列
 * @author YFAN
 * @date 2021/9/20/020
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
提示：
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(array));
        System.out.println(solution.lengthOfLIS2(array));
    }
}

class Solution {
    /*
     * 动态规划
     * 时间复杂度O(n^2)
     * @author YFAN
     * @date 2021/9/20/020
     * @param  * @param nums
     * @return int
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        //dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度
        dp[0] = 1;// 默认长度1
        int result = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;// 默认长度1
            for (int j = 0; j < i; j++) {
                // 当数组中元素后者大于前者
                if (nums[i] > nums[j]) {
                    // 前i个元素递增子序长度 与 前j个元素自增字序长度 比较
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    /*
     * 贪心 + 二分查找
     * TODO
     */
    public int lengthOfLIS2(int[] nums) {
        // TODO
        return 0;
    }
}
