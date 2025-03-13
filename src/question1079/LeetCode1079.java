package src.question1079;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 1079. 活字印刷
 中等
 相关标签
 相关企业
 提示
 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。

 注意：本题中，每个活字字模只能使用一次。

 示例 1：

 输入："AAB"
 输出：8
 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 示例 2：

 输入："AAABBC"
 输出：188
 示例 3：

 输入："V"
 输出：1


 提示：

 1 <= tiles.length <= 7
 tiles 由大写英文字母组成
 **/
public class LeetCode1079 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities("AAABBC"));
    }
}

class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = countMap.keySet();
        // 减一去掉非空字符
        return dfs(tiles.length(), countMap, set) - 1;
    }

    public int dfs(int i , Map<Character, Integer> countMap, Set<Character> set) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (Character c : set) {
            if (countMap.get(c) > 0){
                countMap.put(c, countMap.get(c) - 1);
                res += dfs(i -1,countMap, set);
                countMap.put(c, countMap.get(c) + 1);
            }
        }
        return res;
    }
}