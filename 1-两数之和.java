package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        if (ints != null) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums != null) {
            int i = 0;//初始位置
            HashMap<Integer, Integer> map = new HashMap<>();
            while (i < nums.length) {
                int t = target - nums[i];
                // 判断是否有该key
                if (map.containsKey(t)) {
                    return new int[]{map.get(t), i};
                }
                map.put(nums[i], i);
                i++;
            }
        }
        return null;
    }
}