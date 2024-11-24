package src.question16;

import java.util.Arrays;

/**最接近的三数之和
 * @Author YFAN
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 **/
public class LeetCode16 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1 , 1, 1, 0, 55}, 3));
    }
}
// 6ms 87.05%
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        // 结果
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // 使用双指针
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    return sum;
                } else {
                    result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;
                    if (sum > target) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return result;
    }
}