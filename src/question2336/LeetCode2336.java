package src.question2336;

import java.util.TreeSet;

/**
 2336. 无限集中的最小数字
 中等
 相关标签
 相关企业
 提示
 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。

 实现 SmallestInfiniteSet 类：

 SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 int popSmallest() 移除 并返回该无限集中的最小整数。
 void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。


 示例：

 输入
 ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
 [[], [2], [], [], [], [1], [], [], []]
 输出
 [null, null, 1, 2, 3, null, 1, 4, 5]

 解释
 SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
 smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
 smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
 smallestInfiniteSet.popSmallest(); // 返回 2 ，并将其从集合中移除。
 smallestInfiniteSet.popSmallest(); // 返回 3 ，并将其从集合中移除。
 smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
 smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 在上一步中被添加到集合中，
 // 且 1 是最小的整数，并将其从集合中移除。
 smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
 smallestInfiniteSet.popSmallest(); // 返回 5 ，并将其从集合中移除。


 提示：

 1 <= num <= 1000
 最多调用 popSmallest 和 addBack 方法 共计 1000 次
 */
public class LeetCode2336 {

    public static void main(String[] args) {


    }

}
class SmallestInfiniteSet {
    private int thres;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        thres = 1;
        set = new TreeSet<Integer>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = thres;
            ++thres;
            return ans;
        }
        int ans = set.pollFirst();
        return ans;
    }

    public void addBack(int num) {
        if (num < thres) {
            set.add(num);
        }
    }
}
