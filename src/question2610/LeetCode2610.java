package src.question2610;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 2610. 转换二维数组
 中等
 相关标签
 相关企业
 提示
 给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：

 二维数组应该 只 包含数组 nums 中的元素。
 二维数组中的每一行都包含 不同 的整数。
 二维数组的行数应尽可能 少 。
 返回结果数组。如果存在多种答案，则返回其中任何一种。

 请注意，二维数组的每一行上可以存在不同数量的元素。

 示例 1：

 输入：nums = [1,3,4,1,2,3,1]
 输出：[[1,3,4,2],[1,3],[1]]
 解释：根据题目要求可以创建包含以下几行元素的二维数组：
 - 1,3,4,2
 - 1,3
 - 1
 nums 中的所有元素都有用到，并且每一行都由不同的整数组成，所以这是一个符合题目要求的答案。
 可以证明无法创建少于三行且符合题目要求的二维数组。
 示例 2：

 输入：nums = [1,2,3,4]
 输出：[[4,3,2,1]]
 解释：nums 中的所有元素都不同，所以我们可以将其全部保存在二维数组中的第一行。


 提示：

 1 <= nums.length <= 200
 1 <= nums[i] <= nums.length
 */
public class LeetCode2610 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.findMatrix(new int[]{4,5,3,3,3}));

    }
}

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //  1 <= nums[i] <= nums.length
        int[] cnt = new int[nums.length + 1];

        for (int num : nums) {
            cnt[num]++;
        }
        int index = 0;
        while (index <= nums.length) {
            for(int i = 0; i < cnt[index]; i++) {
                if (res.size() <= i) {
                    res.add(new ArrayList<>());
                }
                res.get(i).add(index);
            }
            index++;
        }
        return res;
    }
}


class Solution2 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] flag = new int[nums.length];
        int count = 0;
        while (count < nums.length) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (flag[i] == 1) {
                    continue;
                }
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    flag[i]=1;
                    count++;
                }
            }
            if (set.size() > 0) {
                res.add(set.stream().collect(Collectors.toList()));
            }
        }
        return res;
    }
}