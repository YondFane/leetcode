package src.question733;

import java.util.Arrays;

/*
 * 733. 图像渲染
 * @author YFAN
 * @date 2021/9/26/026
有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
最后返回经过上色渲染后的图像。
示例 1:
输入:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出: [[2,2,2],[2,2,0],[2,0,1]]
解析:
在图像的正中间，(坐标(sr,sc)=(1,1)),
在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，
因为它不是在上下左右四个方向上与初始点相连的像素点。
注意:
image 和 image[0] 的长度在范围 [1, 50] 内。
给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 */
public class LeetCode733 {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Solution2 solution = new Solution2();
        solution.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(image));
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        def(visited, image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    /*
     * 深度遍历
     * @author YFAN
     * @date 2021/9/26/026
     * @param visited 记录访问位置
     * @param image
     * @param x 当前横坐标位置
     * @param y 当前纵坐标位置
     * @param target 目标值
     * @param newColor 染色
     * @return void
     */
    private void def(boolean visited[][], int[][] image, int x, int y, int target, int newColor) {
        if (!visited[x][y]) {
            // 标记访问
            visited[x][y] = true;
            if (image[x][y] == target) {
                image[x][y] = newColor;
                // 上 下 左 右移动
                if (x - 1 >= 0 && image[x - 1][y] == target) {
                    def(visited, image, x - 1, y, target, newColor);
                }
                if (x + 1 < image.length && image[x + 1][y] == target) {
                    def(visited, image, x + 1, y, target, newColor);
                }
                if (y - 1 >= 0 && image[x][y - 1] == target) {
                    def(visited, image, x, y - 1, target, newColor);
                }
                if (y + 1 < image[0].length && image[x][y + 1] == target) {
                    def(visited, image, x, y + 1, target, newColor);
                }
            }
        }
    }
}

/*
 * 优化
 * @author YFAN
 * @date 2021/9/26/026
 * @param  * @param null
 * @return
 */
class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            def(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    /*
     * 深度遍历
     * @author YFAN
     * @date 2021/9/26/026
     * @param visited 记录访问位置
     * @param image
     * @param x 当前横坐标位置
     * @param y 当前纵坐标位置
     * @param target 目标值
     * @param newColor 染色
     * @return void
     */
    private void def(int[][] image, int x, int y, int target, int newColor) {
        if (image[x][y] == target) {
            image[x][y] = newColor;
            // 上 下 左 右移动
            if (x - 1 >= 0) {
                def(image, x - 1, y, target, newColor);
            }
            if (x + 1 < image.length) {
                def(image, x + 1, y, target, newColor);
            }
            if (y - 1 >= 0) {
                def(image, x, y - 1, target, newColor);
            }
            if (y + 1 < image[0].length) {
                def(image, x, y + 1, target, newColor);
            }
        }
    }
}