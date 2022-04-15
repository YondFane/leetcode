package src.question398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * 398. 随机数索引
 * @author YFAN
 * @date 2022/4/15/015

给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
注意：
数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
示例:
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);
// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
solution.pick(3);
// pick(1) 应该返回 0。因为只有nums[0]等于1。
solution.pick(1);
通过次数18,764提交次数27,912
 */
public class LeetCode398 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        long start = System.currentTimeMillis();
        System.out.println(new Solution(nums).pick(3));
        System.out.println("运行时间：" + (System.currentTimeMillis() - start) + "ms");
    }
}

class Solution {
    private int[] nums;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int rand = 1 + random.nextInt(++p);
                if (rand == p) {
                    res = i;
                }
            }
        }
        return res;
    }
}

/*
执行用时：
67 ms
, 在所有 Java 提交中击败了
21.80%
的用户
内存消耗：
50.9 MB
, 在所有 Java 提交中击败了
5.76%
的用户
 */
class Solution1 {
    private HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
    private Random random = new Random();

    public Solution1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i], list);
            }
        }
    }

    public int pick(int target) {
        ArrayList<Integer> integers = hashMap.get(target);
        return integers.get(random.nextInt(integers.size()));
    }
}