package src.question283;

import java.util.Arrays;

/*
 * 283. 移动零
 * @author YFAN
 * @date 2021/9/22/022
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
public class LeetCode283 {
    public static void main(String[] args) {
        int[] array = {0,1,0,3,12};
        new Solution().moveZeroes2(array);
        System.out.println(Arrays.toString(array));
    }
}
class Solution {
    /*
     * 总体思想：把非零的数往前移
     * 剩下的都是0
     * @author YFAN
     * @date 2021/9/22/022
     * @param  * @param nums
     * @return void
     */
    public void moveZeroes(int[] nums) {
        if (nums!=null && nums.length != 0) {
            int i = 0;
            for(int step = 0; step < nums.length; step++) {
                if (nums[step] != 0) {
                    nums[i++] = nums[step];
                }
            }
            for(;i<nums.length;i++) {
                nums[i] = 0;
            }
        }
    }

    /*
     * 优解
     * @author YFAN
     * @date 2021/9/22/022
     * @param  * @param nums
     * @return void
     */
    public void moveZeroes2(int[] nums) {
        if (nums!=null && nums.length != 0) {
            // 记录下一次数组中的非零元素交换的下标
            int i = 0;
            for(int step = 0; step < nums.length; step++) {
                if (nums[step] != 0) {
                    // 非零直接交换
                    int t = nums[i];
                    nums[i] = nums[step];
                    nums[step] = t;
                    i++;
                }
            }

        }
    }
}
