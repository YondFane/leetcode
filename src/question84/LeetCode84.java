package src.question84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/** 84. 柱状图中最大的矩形
* @Description:
* @Author: YFAN
* @Date: 2021/5/21/021
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
*/
public class LeetCode84 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
/**
 *执行用时：
 * 28 ms
 * , 在所有 Java 提交中击败了
 * 58.84%
 * 的用户
 * 内存消耗：
 * 47.5 MB
 * , 在所有 Java 提交中击败了
 * 78.64%
 * 的用户
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            // 找出当前i节点，右边大于等于heights[i]的右边界
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            // 栈顶为左边大于等于heights[i]的左边界
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
/**
 * 超时
 */
class Solution2 {
    /**
     * 暴力解法
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int len = heights.length;
        int left = 0;
        int right = 0;
        for(int i = 0; i < len;i++) {
            left = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            right = i;
            while (right < len -1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            area = Math.max(area,(right - left + 1) * heights[i]);
        }
        return area;
    }
}