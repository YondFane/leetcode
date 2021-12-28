package src.question187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 187. 重复的DNA序列
 *
 * @Author YFAN
 * @Date 2021/12/28
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 提示：
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 */
public class LeetCode187 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        list.forEach(s -> {
            System.out.println(s);
        });
    }
}

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0, j = 10; j <= s.length(); j++, i++) {
            String subStr = s.substring(i, j);
            if (map.containsKey(subStr) && map.get(subStr) == 1) {
                list.add(subStr);
                map.put(subStr, map.get(subStr) + 1);
            } else {
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }
        return list;
    }
}