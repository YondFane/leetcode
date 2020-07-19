package 组合总和_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author YFAN
 * @Description
 * @Date 19:37 2020/7/19/019
给定一个无重复元素的数组 candidates 和一个目标数 target ，
找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 

示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
[7],
[2,2,3]
]
示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 **/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> listList = solution.combinationSum(new int[]{7,2,6,3}, 7);
        for (List<Integer> list : listList) {
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}
//执行用时：
//3 ms
//, 在所有 Java 提交中击败了
//87.90%
//的用户
//内存消耗：
//40.2 MB
//, 在所有 Java 提交中击败了
//9.43%
//的用户
class Solution {
    // 不对数组进行排序，直接遍历
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        fun(listList, new ArrayList<>(), candidates, target, 0);
        return listList;
    }
    public void fun(List<List<Integer>> listList, List<Integer> list, int[] nums, int target, int i) {
        if (target == 0) {
            listList.add(list);
            return;
        }
        for (;i < nums.length; i++) {
            if (nums[i] <= target) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                fun(listList, temp, nums, target - nums[i], i);
            }
        }
    }
}
//执行用时：
//4 ms
//, 在所有 Java 提交中击败了
//56.12%
//的用户
//内存消耗：
//40.3 MB
//, 在所有 Java 提交中击败了
//9.43%
//的用户
class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(candidates);
        fun(listList, new ArrayList<>(), candidates, target, 0);
        return listList;
    }
    public void fun(List<List<Integer>> listList, List<Integer> list, int[] nums, int target, int i) {
        if (target == 0) {
            listList.add(list);
            return;
        }
        for (;i < nums.length; i++) {
            if (nums[i] <= target) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                fun(listList, temp, nums, target - nums[i], i);
            } else {
                break;
            }
        }
    }
}