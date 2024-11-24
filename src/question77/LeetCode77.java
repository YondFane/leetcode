package src.question77;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @Description:
 * @Param:
 * @return:
 * @Author: YFAN
 * @Date: 2021/5/10/010
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class LeetCode77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> list : solution.combine(4, 2)) {
            System.out.println(list.toString());
        }
    }
}

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fun(result, list, 1, n, k);
        return result;
    }

    public void fun(List<List<Integer>> result, List<Integer> list, int i, int n, int k) {
        //剪枝
        if(list.size() + n - i + 1 < k) {
            return;
        }
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        //使用当前位置
        list.add(i);
        fun(result, list, i + 1, n, k);
        //不使用当前位置
        list.remove(list.size() - 1);
        fun(result, list, i + 1, n, k);
    }
}