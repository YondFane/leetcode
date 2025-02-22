package src.question692;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 *
 * 示例 1：
 *
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 注意：
 *
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] 由小写英文字母组成。
 * k 的取值范围是 [1, 不同 words[i] 的数量]
 *
 *
 * 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class LeetCode692 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] strs = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(solution.topKFrequent(strs, k));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.topKFrequent(strs, k));

    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return map.get(word1) == map.get(word2) ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
            }
        });
        return rec.subList(0, k);
    }
}

class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>((w1, w2) -> map.get(w1) == map.get(w2) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        map.forEach((a, b)-> priorityQueue.add(a));
        List<String> res = new ArrayList<>();
        while (!priorityQueue.isEmpty() && k-- > 0) {
            res.add(priorityQueue.poll());
        }
        return res;
    }
}