package src.question905;

import java.util.Arrays;

/**
 905. 按奇偶排序数组
 简单
 相关标签
 相关企业
 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。

 返回满足此条件的 任一数组 作为答案。

 示例 1：

 输入：nums = [3,1,2,4]
 输出：[2,4,3,1]
 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 示例 2：

 输入：nums = [0]
 输出：[0]

 提示：

 1 <= nums.length <= 5000
 0 <= nums[i] <= 5000
 */
public class LeetCode905 {


    public static void main(String[] args) {

        int[] nums = {1,3,4,5,6,4,5,6,8,10,23,12};
        System.out.println(Arrays.toString(nums));
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParity(nums)));
    }

}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (index == i) {
                    index++;
                    continue;
                }
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

}