package src.question167;

import java.util.Arrays;

/*
 * 167. 两数之和 II - 输入有序数组
 * @author YFAN
 * @date 2021/9/23/023
给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
示例 1：
输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
示例 2：
输入：numbers = [2,3,4], target = 6
输出：[1,3]
示例 3：
输入：numbers = [-1,0], target = -1
输出：[1,2]
提示：
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案
 */
public class LeetCode167 {
    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        int[] twoSum = new Solution().twoSum(numbers, 100);
        System.out.println(Arrays.toString(twoSum));
    }
}

class Solution {
    /*
     * 双指针
     * @author YFAN
     * @date 2021/9/23/023
     * @param  * @param numbers
     * @param target
     * @return int[]
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] array = new int[2];
        int p = 0;
        int q = 1;
        while (q < numbers.length) {
            int sum = numbers[q] + numbers[p];
            if (sum < target) {
                q++;
                if (q == numbers.length) {
                    p++;
                    q = p + 1;
                }
            } else if (sum > target) {
                p++;
                q = p + 1;
            } else {
                array[0] = p + 1;
                array[1] = q + 1;
                break;
            }
        }
        return array;
    }
    /*
     * 优化-双指针
     * @author YFAN
     * @date 2021/9/23/023
     * @param  * @param numbers
     * @param target
     * @return int[]
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] array = new int[2];
        int p = 0;
        int q = numbers.length - 1;
        while (p < q) {
            int sum = numbers[q] + numbers[p];
            if (sum < target) {
                p++;
            } else if (sum > target) {
                q--;
            } else {
                array[0] = p + 1;
                array[1] = q + 1;
                break;
            }
        }
        return array;
    }
}