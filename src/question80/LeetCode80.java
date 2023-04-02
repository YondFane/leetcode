package src.question80;

import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class LeetCode80 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array1 = {0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4};
        System.out.println(solution.removeDuplicates(array1));
        System.out.println(Arrays.toString(array1));
        int[] array2 = {1, 1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicates(array2));
        System.out.println(Arrays.toString(array2));
        int[] array3 = {1, 2, 3, 4, 5, 6};
        System.out.println(solution.removeDuplicates(array3));
        System.out.println(Arrays.toString(array3));
        int[] array4 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(solution.removeDuplicates(array4));
        System.out.println(Arrays.toString(array4));


    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int num = nums[0];
        int count = 0;
        for (int i = 0; i < result; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                num = nums[i];
                count = 1;
            }
            if (count > 2) {
                result--;
                changeArray(nums, i-1);
                i--;
            }
        }
        return result;
    }

    public void changeArray(int[] nums, int index) {
        int len = nums.length;
        for (; index < len - 1; index++) {
            nums[index] = nums[index+1];
        }
    }
}

// 使用快慢指针，只需要检查当前元素是否与上上个元素相等
// {0, 1, 1, 2, 2, 3, 3, 3, 3, 3, 4}
class Solution_full {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}