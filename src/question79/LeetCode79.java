package src.question79;

/**
 * @Description 79. 单词搜索
 * @Author YFAN
 * @Date 2021/9/13
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Solution().exist(board, "ABCCED2"));
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i ++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return flag;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            // 如果当前字符不等于数组对应的字符直接返回false
            return false;
        } else if (k == word.length() - 1) {
            // 如果k等于word的长度，说明最后一个字符也匹配了，直接返回true
            return true;
        }
        // 位置标记访问
        visited[i][j] = true;
        // 上 下 左 右 移动
        int[][] direction = {{0,-1},{0,1},{-1,0},{1,0}};
        // 方向移动
        for (int[] temp : direction) {
            int newi = i + temp[0];
            int newj = j + temp[1];
            // 数组边界判断 && 是否被访问
            if (newi >= 0 && newi < board.length && newj >=0 && newj < board[0].length && !visited[newi][newj]) {
                // 回溯
                boolean flag = check(board, visited, newi, newj, word, k + 1);
                if (flag) {
                    // 匹配直接返回true
                    return true;
                }
            }
        }
        // 位置取消访问
        visited[i][j] = false;
        return false;
    }
}