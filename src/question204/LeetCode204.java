package src.question204;

import java.util.*;

/**
 204. 计数质数
 中等
 相关标签
 相关企业
 提示
 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。

 示例 1：

 输入：n = 10
 输出：4
 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 示例 2：

 输入：n = 0
 输出：0
 示例 3：
 输入：n = 1
 输出：0

 提示：

 0 <= n <= 5 * 106
 */
public class LeetCode204 {
    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(1500000));
        System.out.println(System.currentTimeMillis() - start);

        Long start2 = System.currentTimeMillis();
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.countPrimes(1500000));
        System.out.println(System.currentTimeMillis() - start2);

    }
}

/**
 * 效率够快但是还不够
 */
class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int count = 0;
        for(int i = 2; i<n; i++) {
            if (isPrimeNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimeNumber(int num) {
        int i =2;
        while (i * i <= num) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

}


class Solution2 {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i<n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (isPrimeNumber(i)) {
                count++;
                addNotPrimeNumber(set, i, n);
            }
        }
        return count;
    }

    private boolean isPrimeNumber(int num) {
        int i =2;
        while (i * i <= num) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    private void addNotPrimeNumber(Set<Integer> set, int num, int n) {
        int i = 2;
        while (i * num < n) {
            set.add(i*num);
            i++;
        }
    }
}