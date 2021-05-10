package question78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @Description:
 * @Author: YFAN
 * @Date: 2021/5/10/010
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class LeetCode78 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> list : solution.subsets(new int[]{1, 2, 3})) {
            System.out.println(list.toString());
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 子集个数 0 - nums.length
        for (int i = 0; i <= nums.length; i++) {
            fun(result, list, i, nums, 0);
        }
        return result;
    }

    public void fun(List<List<Integer>> result, List<Integer> list, int size, int[] nums, int i) {
        // 剪枝
        if (list.size() + nums.length - i < size) {
            return;
        }
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        fun(result, list, size, nums, i + 1);
        list.remove(list.size() - 1);
        fun(result, list, size, nums, i + 1);
    }
}