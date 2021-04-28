package src.question35;

/**搜索插入位置
 * @Author YFAN
 * @Description
 * @Date 19:23 2020/7/19/019
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2
示例 2:
输入: [1,3,5,6], 2
输出: 1
示例 3:
输入: [1,3,5,6], 7
输出: 4
示例 4:
输入: [1,3,5,6], 0
输出: 0
 **/
public class LeetCode35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{}, 2));
    }
}
//执行用时：
//0 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//39.2 MB
//, 在所有 Java 提交中击败了
//5.55%
//的用户
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return 0;}
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                continue;
            }else {
                return i;
            }
        }
        return nums.length;
    }
}