package 下一个排列_31;

import java.util.Arrays;

/**
 * @Author YFAN
 * @Description
 * @Date 20:54 2020/7/16/016

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,2};
//        int[] nums = new int[]{4,2,0,2,3,2,4};
        solution.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    //  123    199
    public void nextPermutation(int[] nums) {
        int number = Integer.MAX_VALUE;
        int index = -1;
        // 从右往左，找一个左边小于右边的数
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                number = nums[i];
                index = i;
                break;
            }
        }
        // index为-1则数字为最大排序
        if (index == -1) {
            Arrays.sort(nums);
        } else {
            // 从右往左，找一个比number大的数
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > number) {
                    nums[index] = nums[i];
                    nums[i] = number;
                    Arrays.sort(nums, index + 1, nums.length);
                    break;
                }
            }
        }
    }
}