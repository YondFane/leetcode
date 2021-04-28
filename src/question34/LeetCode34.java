package src.question34;
/**在排序数组中查找元素的第一个和最后一个位置
 * @Author YFAN
 * @Description
 * @Date 10:08 2020/7/18/018
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 **/
public class LeetCode34 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = solution.searchRange(new int[]{2}, 2);
        System.out.println(array[0] + " " +array[1]);
    }
}
//执行用时：
//0 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//43 MB
//, 在所有 Java 提交中击败了
//52.63%
//的用户
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 获取数组的第一个target位置
        int left = fun(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        // 获取数组的最后一个target位置
        int right = fun(nums, target, false);
        return new int[]{left, right - 1};
    }
    public int fun(int[] nums, int target, boolean left) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}