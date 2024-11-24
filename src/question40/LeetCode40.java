package src.question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**组合总和II
 * @Author YFAN
 * @Description
给定一个数组 candidates 和一个目标数 target ，
找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
[1, 7],
[1, 2, 5],
[2, 6],
[1, 1, 6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 **/
public class LeetCode40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> listList = solution.combinationSum2(new int[]{10,1,7,2,6,1,5}, 8);
        for (List<Integer> list : listList) {
            for (Integer i : list) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}
//执行用时：
//9 ms
//, 在所有 Java 提交中击败了
//18.78%
//的用户
//内存消耗：
//40.3 MB
//, 在所有 Java 提交中击败了
//25.00%
//的用户
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(candidates);
        fun(listList, new ArrayList<>(), candidates, target, 0);
        return listList;
    }
    public void fun(List<List<Integer>> listList, List<Integer> list, int[] nums, int target, int i) {
        if (target == 0) {
            if (!listList.contains(list)) {
                listList.add(list);
            }
            return;
        } else if(target > 0) {
            for (; i < nums.length; i++) {
                if (nums[i] <= target) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(nums[i]);
                    fun(listList, temp, nums, target - nums[i], i + 1);
                }
            }
        }
    }
}
// 别人写的 1ms
class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList();
        if(candidates==null||candidates.length==0)return result;
        int[]sum=new int[candidates.length];
        Arrays.sort(candidates);
        zidiedai(result,candidates,target,0,sum,-1,0);
        return result;
    }
    public static void zidiedai(List<List<Integer>>result,int[] candidates,int target,int candidatesindex,int[] sum,int sumindex,int temp)
    {
        //如果没有下一个数了，就返回
        if(candidatesindex>=candidates.length)return;

        for(int i=candidatesindex;i<candidates.length;i++)
        {
            //如果等于，则加入到result中
            if(temp+candidates[i]==target)
            {
                List<Integer>list=new ArrayList();
                for(int j=0;j<sumindex+1;j++)
                {
                    list.add(sum[j]);
                }
                list.add(candidates[i]);
                result.add(list);
                return;
            }
            //如果已经大了，那就没必要继续查找了，因为后面的更大
            else if(temp+candidates[i]>target)return;
            //如果比target还小的话
            if(sum[sumindex+1]==candidates[i])continue;
            sum[sumindex+1]=candidates[i];
            zidiedai(result,candidates,target,i+1,sum,sumindex+1,temp+candidates[i]);
        }

    }
}