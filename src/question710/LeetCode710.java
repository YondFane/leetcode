package src.question710;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 710. 黑名单中的随机数
 * 困难
 * 相关标签
 * 相关企业
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 * // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 109
 * 0 <= blacklist.length <= min(105, n - 1)
 * 0 <= blacklist[i] < n
 * blacklist 中所有值都 不同
 * pick 最多被调用 2 * 104 次
 */
public class LeetCode710 {

    public static void main(String[] args) {

        Random rand = new Random();
        System.out.println(rand.nextInt(2 - 1));
        System.out.println(rand.nextInt(2 - 1));
        System.out.println(rand.nextInt(2 - 1));

        Solution solution = new Solution(2, new int[]{});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }

}
/**
 * 官方答案
 * 黑名单落点随机
 * 例如 10  [1, 5, 8]
 * 有7个白名单，3个黑名单
 * 需要将
 * 1 映射成 9
 * 5 映射成 10
 * 那么只需要对白名单数量进行随机即可
 * 使用一个映射列表将前面黑名单的数字映射成后面白名单数字
 * 那么就可以看成 “前面都是白名单” “后面都是黑名单”
 * 套多了一层映射关系，减少数据检索时间
 */
class Solution {
    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    public Solution(int n, int[] blacklist) {
        b2w = new HashMap<Integer, Integer>();
        random = new Random();
        // 黑名单数量
        int m = blacklist.length;
        // 白名单数量
        bound = n - m;

        // 将后面区间的黑名单找出来
        Set<Integer> black = new HashSet<Integer>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        // 白名单位置
        int w = bound;
        for (int b : blacklist) {
            // 黑名单落在前面区间，需要对黑名单进行白名单映射
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                // 黑名单映射白名单
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }
}
