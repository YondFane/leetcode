package src.question135;

/**
 135. 分发糖果
 困难
 相关标签
 相关企业
 n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

 你需要按照以下要求，给这些孩子分发糖果：

 每个孩子至少分配到 1 个糖果。
 相邻两个孩子评分更高的孩子会获得更多的糖果。
 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

 示例 1：

 输入：ratings = [1,0,2]
 输出：5
 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 示例 2：

 输入：ratings = [1,2,2]
 输出：4
 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。


 提示：

 n == ratings.length
 1 <= n <= 2 * 104
 0 <= ratings[i] <= 2 * 104
 **/
public class LeetCode135 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};

    }

}
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // 初始化，每个孩子至少分到 1 个糖果
        int ret = 1;
        // inc 表示递增规则，dec 表示递减规则，pre 表示前一个孩子评分的糖果数
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                // 递增规则处理
                // 如果当前孩子评分高于前一个孩子，则当前孩子至少分到前一个孩子糖果数 + 1
                // 如果当前孩子评分等于前一个孩子，则当前孩子至少分到前一个孩子糖果数
                // 如果当前孩子评分低于前一个孩子，则当前孩子至少分到 1 个糖果
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                // 递减规则处理
                // 如果当前孩子评分低于前一个孩子，则当前孩子至少分到 1 个糖果
                // 如果当前孩子评分等于前一个孩子，则当前孩子至少分到前一个孩子糖果数
                // 如果当前孩子评分高于前一个孩子，则当前孩子至少分到前一个孩子糖果数 + 1
                dec++;
                if (dec == inc) {
                    // 当递减序列长度和递增序列长度相等时，把递增序列的最后一个同学分配到递减序列中
                    dec++;
                }
                // 这里加的dec相当于把递减序列翻转后加的每个同学的糖果数量
                ret += dec;
                // pre在递减序列中没有意义，因为我肯定比前一个同学少；
                pre = 1;
            }
        }
        return ret;
    }
}

class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        // 左递增规则处理
        for (int i = 0; i < n; ++i) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ans = 0;
        // 右递增规则处理
        for (int i = n - 1; i >= 0; --i) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ans += Math.max(left[i], right);
        }
        return ans;
    }
}