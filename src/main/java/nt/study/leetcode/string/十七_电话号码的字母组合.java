package nt.study.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 十七_电话号码的字母组合 {
    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static List<String> letterCombinations(String digits) {
        List<String> combinedResults = new ArrayList<>();
        if(digits.length()  ==0){
            return combinedResults;
        }
        Map<Character, String> digit2Letter = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder combinedResult = new StringBuilder();
        backTrack(combinedResults, digits, 0, combinedResult, digit2Letter);
        return combinedResults;
    }

    /** 回溯 **/
    public static void backTrack(List<String> combinedResults, String digits, int index, StringBuilder combinedResult, Map<Character, String> digit2Letter){
        if(index == digits.length()){
            combinedResults.add(combinedResult.toString());
        }else{
            String letters = digit2Letter.get(digits.charAt(index));
            int len = letters.length();
            for (int i = 0; i < len; i++) {
                char c = letters.charAt(i);
                combinedResult.append(c);
                backTrack(combinedResults, digits, index + 1, combinedResult, digit2Letter);
                combinedResult.deleteCharAt(index);
            }
        }
        
    }


    public static void main(String[] args) {
        String str = "";
        System.out.println(letterCombinations(str));
    }
}
