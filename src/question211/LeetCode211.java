package src.question211;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * @Author YFAN
 * @Date 2021/12/30
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * 示例：
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * <p>
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 */
public class LeetCode211 {
    public static void main(String[] args) {
        //["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
        //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }
}

class WordDictionary {
    private DictionaryTree tree;

    public WordDictionary() {
        tree = new DictionaryTree();
    }

    public void addWord(String word) {
        tree.insertWord(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, tree);
    }

    /**
     * 深度遍历搜索字典树
     *
     * @return boolean
     * @Author YFAN
     * @Date 2021/12/30 10:34
     * @params [word, index, dictionaryTree]
     */
    private boolean dfs(String word, int index, DictionaryTree tree) {
        if (word.length() == index) {
            return tree.isEnd();
        }
        char ch = word.charAt(index);
        // 字母
        if (Character.isLetter(ch)) {
            int i = ch - 'a';
            DictionaryTree tempTree = tree.getDictionaryTree()[i];
            if (tempTree != null && dfs(word, index + 1, tempTree)) {
                return true;
            }
        } else {
            // 存在.需要遍历字典数组
            DictionaryTree[] tTrees = tree.getDictionaryTree();
            for(int i = 0; i < tTrees.length; i++) {
                DictionaryTree tTree = tTrees[i];
                if (tTree != null && dfs(word, index + 1, tTree)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class DictionaryTree {
    private DictionaryTree[] trees;
    private boolean isEnd;

    public DictionaryTree() {
        trees = new DictionaryTree[26];
        isEnd = false;
    }

    /**
     * 插入单词构建字典树
     *
     * @return void
     * @Author YFAN
     * @Date 2021/12/30 10:32
     * @params [word]
     */
    public void insertWord(String word) {
        DictionaryTree dictionaryTree = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (dictionaryTree.trees[index] == null) {
                dictionaryTree.trees[index] = new DictionaryTree();
            }
            dictionaryTree = dictionaryTree.trees[index];
        }
        dictionaryTree.isEnd = true;
    }


    public DictionaryTree[] getDictionaryTree() {
        return trees;
    }

    public boolean isEnd() {
        return isEnd;
    }
}