package nt.study.leetcode.string;


import java.util.HashMap;
import java.util.Map;

public class 八_字符串转换整数 {
    /**
     * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * 函数myAtoi(string s) 的算法如下：
     *
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
     * 返回整数作为最终结果。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        int len = s.length(), index = 0;
        long value = 0;
        char ch = '\0';
        String str = "";
        if(len == 0){
            return 0;
        }
        for(index = 0; index < len; index++){
            if(s.charAt(index) != ' '){
                break;
            }
        }
        if(index == len){
            return 0;
        }
        ch = s.charAt(index);
        if(ch == '-' || ch == '+' ){
            index ++;
        }
        str = s.substring(index, len);
        for(index = 0; index < str.length(); index++){
            if(str.charAt(index) < '0' || str.charAt(index) > '9'){
                break;
            }
        }
        if(index != len){
            str = str.substring(0, index);
        }

        for(int i = 0; i < index; i++){
            value += Math.pow(10, index - i - 1) * (str.charAt(i) - '0');
        }
        if(ch == '-'){
            value = value * -1;
        }
        if(value < Math.pow(-2, 31)){
            return (int) Math.pow(-2, 31);
        }
        if(value > Math.pow(2, 31) - 1){
            return (int) (Math.pow(2, 31) - 1);
        }
        return (int)value;

    }


    /**
     * 使用有限自动机解决字符串转换整数问题
     * @param s
     * @return
     */
    public static int leetcodeMyAtoi(String s){
        int len = s.length();
        MyAutoi myAutoi = new MyAutoi();
        for (int i = 0; i < len; i++) {
            myAutoi.get(s.charAt(i));
        }
        return (int) (myAutoi.symbol * myAutoi.answer);
    }

    public static void main(String[] args) {
        String s = "-9999999999999999999999";
        int i = leetcodeMyAtoi(s);
        System.out.println(i);
    }
}

class MyAutoi{
    int symbol = 1;
    long answer = 0;
    String state = "start";
    Map<String, String[]> stateMap =  new HashMap<String, String[]>(){{
       put("start", new String[]{"start", "signed", "in_number", "end"});
       put("signed", new String[]{"end", "end", "in_number", "end"});
       put("in_number", new String[]{"end", "end", "in_number", "end"});
       put("end", new String[]{"end", "end", "end", "end"});
    }};
    public void get(char c){
        state = stateMap.get(state)[getState(c)];
        if(state == "signed"){
            symbol = c == '-' ? -1 : 1;
        }else if(state == "in_number"){
            answer = answer * 10 + c - '0';
            answer = symbol == 1 ? Math.min(answer, Integer.MAX_VALUE) : Math.min(answer, -(long) Integer.MIN_VALUE);
        }

    }

    public int getState(char c){
        if( c == ' '){
            return 0;
        }else if (c == '+' || c == '-'){
            return 1;
        }else if (Character.isDigit(c)){
            return 2;
        }else{
            return 3;
        }
    }
}
