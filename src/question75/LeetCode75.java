package src.question75;

import java.util.Arrays;

/**
 * 75. 颜色分类
 *
 * @Author: YFAN
 * @Date: 2021/5/8/008
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *  
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class LeetCode75 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arrayInt = {2,2,2,1,0,0,0,0};
        solution.sortColors(arrayInt);
        System.out.println(Arrays.toString(arrayInt));

    }
}

/**
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 36.9 MB
 * , 在所有 Java 提交中击败了
 * 74.83%
 * 的用户
 */
class Solution {
    // 综合思想就是把0放到数组前面 2放到数组后面，数组中间自然就是1
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            int t = nums[index];
            //只对 0 2进行处理
            if (t == 0) {
                // nums[index] 为0时 与 nums[left]交换
                swapNumer(nums, index, left);
                left++;
            } else if (t == 2) {
                // nums[index] 为2时 与 nums[right]交换
                swapNumer(nums, index, right);
                right--;
                // 注意这里index需要减1下个循环继续
                index--;
            }
            index++;
        }
    }
    // 数组交换
    public void swapNumer(int[] nums, int i, int j) {
        int len = nums.length;
        if (i < len && j < len && i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
    public void sortColors2(int[] nums) {
        int zero = 0;
        int one = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            nums[i] = 2;
            //当num[i]==0时，nums[zero] 赋值为0 nums[one] 赋值为1, zero++ one++
            //当nums[i]==1时，nums[one] 赋值为1, one++
            //当nums[i]==2时，num[i]赋值为2，不做处理
            if(num < 2){
                nums[one++] = 1;
            }
            if(num < 1){
                nums[zero++] = 0;
            }
        }
    }
}