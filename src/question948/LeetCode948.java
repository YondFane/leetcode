package src.question948;

import java.util.Arrays;

/**
 * @ClassName: LeetCode986
948. 令牌放置
中等
你的初始 能量 为 power，初始 分数 为 0，只有一包令牌以整数数组 tokens 给出。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
你的目标是通过有策略地使用这些令牌以 最大化 总 分数。在一次行动中，你可以用两种方式中的一种来使用一个 未被使用的 令牌（但不是对同一个令牌使用两种方式）：

朝上：如果你当前 至少 有 tokens[i] 点 能量 ，可以使用令牌 i ，失去 tokens[i] 点 能量 ，并得到 1 分 。
朝下：如果你当前至少有 1 分 ，可以使用令牌 i ，获得 tokens[i] 点 能量 ，并失去 1 分 。
在使用 任意 数量的令牌后，返回我们可以得到的最大 分数 。

示例 1：

输入：tokens = [100], power = 50
输出：0
解释：因为你的初始分数为 0，无法使令牌朝下。你也不能使令牌朝上因为你的能量（50）比 tokens[0] 少（100）。
示例 2：
输入：tokens = [200,100], power = 150
输出：1
解释：使令牌 1 正面朝上，能量变为 50，分数变为 1 。
不必使用令牌 0，因为你无法使用它来提高分数。可得到的最大分数是 1。
示例 3：

输入：tokens = [100,200,300,400], power = 200
输出：2
解释：按下面顺序使用令牌可以得到 2 分：
1. 令牌 0 (100)正面朝上，能量变为 100 ，分数变为 1
2. 令牌 3 (400)正面朝下，能量变为 500 ，分数变为 0
3. 令牌 1 (200)正面朝上，能量变为 300 ，分数变为 1
4. 令牌 2 (300)正面朝上，能量变为 0 ，分数变为 2

可得的最大分数是 2。
提示：
0 <= tokens.length <= 1000
0 <= tokens[i], power < 104
 * @Author: yangfan
 * @Date: 2025-01-24 09:38
 **/
public class LeetCode948 {

    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        Solution solution = new Solution();
        System.out.println(solution.bagOfTokensScore(tokens, 200));
    }

}

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // 排序
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int result = 0;
        while (left <= right && (power >= tokens[left] || score > 0)) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
                result = Math.max(result, score);
            } else if (score > 0){
                power += tokens[right--];
                score--;
            }
        }
        return result;
    }
}