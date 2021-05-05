package src.question96;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 96. 不同的二叉搜索树
 *
 * @Author: YFAN
 * @Date: 2021/5/5/005
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 示例 1：
 * 图
 * https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 19
 */
public class LeetCode96 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(19));
    }
}

class Solution {
    /**
     * 卡塔兰数 一般公式公式 C(2n,n)/(n+1)
     * C(0,0) = 1, C(1,1) = 1
     *
     * h(0) = C(0,0)/(0+1) = 1
     * h(5) = c(10,5)/(6) = 10!/5!(10-5)!/6 = 42
     *
     *
     * h(0+1) = 2（2*0+1）/(0+2) * h(0)
     * h(1+1) = 2(2*1+1)/(1+2) * h(1)
     * h(n+1) = 2(2*n+1)/(n+2) * h(1)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
