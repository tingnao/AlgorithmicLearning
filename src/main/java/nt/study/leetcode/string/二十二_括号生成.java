package nt.study.leetcode.string;


import java.util.ArrayList;
import java.util.List;

public class 二十二_括号生成 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> lists = new ArrayList<>();
        // 调用自己写的回溯
        backTrack(lists,  n, n, "");
        // 调用官方编写的回溯
       // backTrack(lists, 0, 0, n, new StringBuilder());
        return lists;
    }

    /**
     * 自己编写的回溯
     * @param lists
     * @param leftNum
     * @param rightNum
     * @param str
     */
    public static void backTrack(List<String> lists, int leftNum, int rightNum, String str){
        if(leftNum == 0 && rightNum == 0){
            lists.add(str);
            return;
        }
        if((leftNum > 0 && rightNum > 0 && leftNum < rightNum) || (leftNum == 0 && rightNum > 0)){
            // 添加右括号
            backTrack(lists, leftNum, rightNum - 1, str + ")");
        }
        if((leftNum > 0 && rightNum > 0 &&leftNum <= rightNum) ){
            // 添加左括号
            backTrack(lists, leftNum - 1, rightNum, str + "(");
        }
    }

    /**
     * leetcode参考回溯，真的强
     *
     */
    public static void backTrack(List<String> lists, int leftNum, int rightNum, int max, StringBuilder cur){
        if(cur.length() == max * 2){
            lists.add(cur.toString());
            return;
        }
        if(leftNum < max){
            // 加左括号
            cur.append("(");
            backTrack(lists, leftNum + 1, rightNum, max, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(rightNum < leftNum){
            // 加右括号
            cur.append(")");
            backTrack(lists, leftNum , rightNum + 1, max, cur);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}
