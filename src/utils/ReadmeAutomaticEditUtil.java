package src.utils;

import java.io.*;
import java.util.Objects;

/**
 * README.md 文件自动编辑工具类
 */
public class ReadmeAutomaticEditUtil {

    /**
     * 例如第809题 809-情感丰富的文字
     * <p>
     * 参数 number传 809
     * 参数 tile 传 情感丰富的文字
     * 参数 leetcodeUrl 传 https://leetcode.cn/problems/expressive-words
     *
     * @param number      序号
     * @param tile        题目名称
     * @param leetcodeUrl 题目地址
     */
    public static void automatic(String number, String tile, String leetcodeUrl) {

        String readmePath = "README.md";
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        // [2336-无限集中的最小数字](src/question2336/LeetCode2336.java)--->[leetcode链接](https://leetcode.cn/problems/smallest-number-in-infinite-set)
        try {
            fr = new FileReader(readmePath);
            br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            boolean writeFlag = false;
            while (br.ready()) {
                String readLine = br.readLine();
                if (readLine.length() == 0 || readLine.startsWith("#")) {
                    sb.append(readLine + "\n");
                    continue;
                }
                // 获取题目序号
                String currentNumber = readLine.substring(1, readLine.indexOf("-"));
                // 如果已经存在不处理
                if (Objects.equals(currentNumber, number)) {
                    throw new RuntimeException("题目已经存在");
                }
                int currentNum = Integer.parseInt(currentNumber);
                int num = Integer.parseInt(number);
                if (currentNum > num && !writeFlag) {
                    // 填充记录
                    String newLine = "[#num#-#title#](src/question#num#/LeetCode#num#.java)--->[leetcode链接](#url#)";
                    newLine = newLine.replaceAll("#num#", number).replace("#title#", tile).replace("#url#", leetcodeUrl);
                    System.out.println( "填充记录 : " + newLine);
                    writeFlag = true;
                    sb.append(newLine + "\n\n");
                }
                sb.append(readLine + "\n");
                //System.out.println(currentNum);
                //System.out.println(readLine);
            }

            // 判断写入内容
            if (writeFlag) {
                fw = new FileWriter(readmePath);
                bw = new BufferedWriter(fw);
                bw.write(sb.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        automatic("808", "测试", "https://leetcode.cn/problems/expressive-words");
    }
}
