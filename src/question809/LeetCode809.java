package src.question809;

/**
 809. 情感丰富的文字
 中等
 相关标签
 相关企业
 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。

 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。

 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。

 输入一组查询单词，输出其中可扩张的单词数量。

 示例：

 输入：
 s = "heeellooo"
 words = ["hello", "hi", "helo"]
 输出：1
 解释：
 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。

 提示：

 1 <= s.length, words.length <= 100
 1 <= words[i].length <= 100
 s 和所有在 words 中的单词都只由小写字母组成。
 */
public class LeetCode809 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }
}
class Solution {
    /**
     * @param s
     * @param words
     * @return
     */
    public int expressiveWords(String s, String[] words) {
        int res = 0;

        for (String word : words) {
            if (fun(s, word)) {
                res++;
            }
        }

        return res;
    }

    /**
     *  heeellooo   hello
     * @param s
     * @param t
     * @return
     */
    public boolean fun(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // 当前相同字符
            char ch = s.charAt(i);
            // 计算字符串s相同字符数量
            int counti = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                i++;
                counti++;
            }
            // 计算字符串t相同字符数量
            int countj = 0;
            while (j < t.length() && t.charAt(j) == ch) {
                j++;
                countj++;
            }
            // 大于说明无法扩张，不符合
            if (counti < countj) {
                return false;
            }
            // 不等于时，判断字符数量是否满足扩展3个字符以上
            if (counti != countj && counti < 3) {
                return false;
            }
        }

        return i == s.length() && j== t.length();
    }
}