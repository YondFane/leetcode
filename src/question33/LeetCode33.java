package src.question33;

/**搜索旋转排序数组
 * @Author YFAN
 * @Description
 * @Date 09:02 2020/7/18/018
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别

示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4

示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 **/
public class LeetCode33 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }

}
//执行用时：
//0 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//39.5 MB
//, 在所有 Java 提交中击败了
//17.74%
//的用户
class Solution {
    // 使用类似二分查找
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return -1;}
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }

        }
        return -1;
    }
}
// 大于log（n）
//执行用时：
//1 ms
//, 在所有 Java 提交中击败了
//18.14%
//的用户
//内存消耗：
//39.4 MB
//, 在所有 Java 提交中击败了
//17.74%
//的用户
class Solution1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return -1;}
        if (nums[0] > target) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
                if (nums[i] < target) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
                if (nums[i] > target) {
                    break;
                }
            }
        }
        return -1;
    }
}