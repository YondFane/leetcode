package src.question2231;

import java.util.PriorityQueue;

/*
 * 2231. 按奇偶性交换后的最大数字
 * @author YFAN
 * @date 2022/4/15/015
2231. 按奇偶性交换后的最大数字
给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
返回交换 任意 次之后 num 的 最大 可能值。
示例 1：
输入：num = 1234
输出：3412
解释：交换数字 3 和数字 1 ，结果得到 3214 。
交换数字 2 和数字 4 ，结果得到 3412 。
注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
示例 2：
输入：num = 65875
输出：87655
解释：交换数字 8 和数字 6 ，结果得到 85675 。
交换数字 5 和数字 7 ，结果得到 87655 。
注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
提示：
1 <= num <= 109
 */
public class LeetCode2231 {
    public static void main(String[] args) {
/*        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(15);
        queue.offer(12);
        queue.forEach(i->System.out.println(i));*/
        System.out.println(new Solution().largestInteger(1234));
    }
}

class Solution {
    public int largestInteger(int num) {
        char[] chars = (num + "").toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                int num1 = chars[i] - '0';
                int num2 = chars[j] - '0';
                // 奇偶相同 && 后者大于前者
                if ((num1 + num2) % 2 == 0 && chars[i] < chars[j]) {
                    // 交换位置
                    char c = chars[i];
                    chars[i] = chars[j];
                    chars[j] = c;
                }
            }
        }
        return Integer.valueOf(new String(chars));
    }
}

class Solution1 {
    // 大顶堆
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        char[] chars = (num + "").toCharArray();
        for (char c : chars) {
            int i = c - '0';
            if (i % 2 == 0) {
                even.offer(i);
            } else {
                odd.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int i = c - '0';
            if (i % 2 == 0) {
                sb.append(even.poll());
            } else {
                sb.append(odd.poll());
            }
        }
        return Integer.valueOf(sb.toString());
    }
}