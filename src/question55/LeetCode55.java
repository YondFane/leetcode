package src.question55;

/**
 * 55. 跳跃游戏
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/26/026
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class LeetCode55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{3, 2, 1, 1, 5, 7, 1, 3, 5, 0, 4}));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int step = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // i大于步数无法到达
            if (i > step) {
                return false;
            }
            //提前退出
            if (step >= len - 1) {
                return true;
            }
            step = Math.max(step, i + nums[i]);
        }
        return true;
    }
}