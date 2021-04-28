package src.question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**四数之和
 * @Author YFAN

给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
[-1,  0, 0, 1],
[-2, -1, 1, 2],
[-2,  0, 0, 2]
]

 **/
public class LeetCode18 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> listList = solution.fourSum(new int[]{-1,-5,-5,-3,2,5,0,4 -7}, -7);
        for (List<Integer> list : listList) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// 4ms 94.48%
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        if (nums.length < 4) {
            return listList;
        }
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            // 边界处理
            if (nums[i] + nums [i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums [len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            // 去重
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                // 边界处理
                if (nums[i] + nums [j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums [j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                // 去重
                if (j != i + 1  && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        listList.add(list);
                        // 去重
                        while(l < r && nums[l] == nums[l + 1]){
                            l++;
                        }
                        // 去重
                        while(l < r && nums[r] == nums[r - 1]){
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return listList;
    }
}
