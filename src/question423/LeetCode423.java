package src.question423;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: src.question423
 * @Author: YANF
 * @CreateTime: 2025-02-18  22:28
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode423 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.originalDigits("fviefuro"));

    }
}


class Solution {
    /**
     * zero    (z-1)  0
     * one     (o-2)  1
     * two     (w-1)  2
     * three   (t-2)  3
     * four    (u-1)  4
     * five    (f-2)  5
     * six     (x-1)  6
     * seven   (s-4)  7
     * eight   (g-1)  8
     * nine    (i-5)  9
     *
     * o n e t w h r f u s i x v g z
     * 0
     */

    public String originalDigits(String str) {
        int z = 0;//0
        int o = 0;//1
        int w = 0;//2
        int t = 0;//3
        int u = 0;//4
        int f = 0;//5
        int x = 0;//6
        int s = 0;//7
        int g = 0;//8
        int i = 0;//9

        for (char c : str.toCharArray()) {
            switch (c) {
                case 'z':
                    z++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'w':
                    w++;
                    break;
                case 't':
                    t++;
                    break;
                case 'f':
                    f++;
                    break;
                case 'u':
                    u++;
                    break;
                case 'x':
                    x++;
                    break;
                case 's':
                    s++;
                    break;
                case 'g':
                    g++;
                    break;
                case 'i':
                    i++;
                    break;
                default:
                    break;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (z > 0) {
            for (int q = z; q > 0 && z > 0 && o > 0; q--) {
                list.add(0);
                z--;
                o--;
            }
        }
        if (w > 0) {
            for (int q = w; q > 0 && w > 0 && t > 0 && o > 0; q--) {
                list.add(2);
                w--;
                t--;
                o--;
            }
        }
        if (x > 0) {
            for (int q = x; q > 0 && x > 0 && s > 0 && i > 0; q--) {
                list.add(6);
                s--;
                i--;
                x--;
            }
        }
        if (g > 0) {
            for (int q = g; q > 0 && g > 0 && i > 0 && t > 0; q--) {
                list.add(8);
                g--;
                i--;
                t--;
            }
        }
        if (u > 0) {
            for (int q = u; q > 0 && u > 0 && f > 0 && o > 0; q--) {
                list.add(4);
                u--;
                f--;
                o--;
            }
        }
        if (t > 0) {
            for (int q = t; q > 0 && t > 0; q--) {
                list.add(3);
                t--;
            }
        }
        if (o > 0) {
            for (int q = o; q > 0 && o > 0; q--) {
                list.add(1);
                o--;
            }
        }
        if (f > 0) {
            for (int q = f; q > 0 && f > 0 && i > 0; q--) {
                list.add(5);
                f--;
                i--;
            }
        }
        if (s > 0) {
            for (int q = s; q > 0 && s > 0; q--) {
                list.add(7);
                s--;
            }
        }
        if (i > 0) {
            for (int q = i; q > 0 && i > 0; q--) {
                list.add(9);
                i--;
            }
        }
        Collections.sort(list);
        String ans = "";
        for (Integer num : list) {
            ans += num;
        }
        return ans;
    }
}


/**
 * 优解
 */
class Solution2 {
    // "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"

    // 1. 统计上面单词都出现一次时的字符个数(普通数组统计即可)
    // [0, 0, 0, 0, 9, 2, 1, 2, 4, 0, 0, 0, 0, 4, 4, 0, 0, 3, 2, 3, 1, 2, 1, 1, 0, 1]
    // [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]

    // 2. 去掉不存在的字符
    // 9, 2, 1, 2, 4, 4, 4, 3, 2, 3, 1, 2, 1, 1, 1
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 3. 选择个数为1的字符对应的英文单词，可以模拟整个过程，不过直接找出一条构造序列效率更高
    // 下面是一条构造序列的推理过程

    // 0->zero 选z(g/u/w/x都可以，记得选完后需要将zero所有字符都-1。后面同理)
    // 8, 2, 1, 2, 4, 4, 3, 2, 2, 3, 1, 2, 1, 1, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 6->six
    // 8, 2, 1, 2, 3, 4, 3, 2, 1, 3, 1, 2, 1, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 2->two
    // 8, 2, 1, 2, 3, 4, 2, 2, 1, 2, 1, 2, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 4->four
    // 8, 1, 1, 2, 3, 4, 1, 1, 1, 2, 0, 2, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 7->seven(因为six已经选过，所以这个s只能选seven，后面同理)
    // 6, 1, 1, 2, 3, 3, 1, 1, 0, 2, 0, 1, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 5->five
    // 5, 0, 1, 2, 2, 3, 1, 1, 0, 2, 0, 0, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 3->three
    // 3, 0, 1, 1, 2, 3, 1, 0, 0, 1, 0, 0, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 8->eight
    // 2, 0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 1->one
    // 1, 0, 0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    // 9->nine
    // 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    // e, f, g, h, i, n, o, r, s, t, u, v, w, x, z

    private static final String[] ENS = new String[] {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    /** 见上面推理 */
    private static final int[] SEQUENCE = new int[] { 0, 6, 2, 4, 7, 5, 3, 8, 1, 9 };

    public String originalDigits(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int[] scnt = new int[10];
        int total = 0;
        for (int sq : SEQUENCE) {
            char[] cs = ENS[sq].toCharArray();
            int min = s.length();
            for (char c : cs) {
                min = Math.min(min, cnt[c - 'a']);
            }
            for (char c : cs) {
                cnt[c - 'a'] -= min;
            }
            scnt[sq] = min;
            total += min;
        }
        char[] ans = new char[total];
        int p = 0;
        for (int i = 0; i < 10; ++i) {
            while (scnt[i] > 0) {
                ans[p++] = (char) (i + '0');
                scnt[i]--;
            }
        }
        return new String(ans);
    }
}