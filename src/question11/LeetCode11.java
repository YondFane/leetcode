package src.question11;

/**盛最多水的容器
 * @Author YFAN
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 **/
public class LeetCode11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

// 双指针 92.78%
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int x = height[i] < height[j] ? height[i] : height[j];
            max = max > x * (j - i) ? max : x * (j - i);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}

// 暴力破解 7%
class Solution1 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int x = height[i] < height[j] ? height[i] : height[j];
                max = max > x * (j - i) ? max : x * (j - i);
            }
        }
        return max;
    }
}