package nt.study.leetcode.string;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class 二十_有效的括号 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * 解题思路：将各种类型的左括号压入栈中，当扫描到右括号时，推出栈顶元素，判断两者是否匹配，
     * 不匹配直接返回false，最后判断栈内是否还存在元素，不存在返回true，否则返回false
     */

    /** 使用stack解决**/
    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        // 保存括号之间的匹配关系
        HashMap<Character, Character> bracketsHashMap = new HashMap<Character, Character>(3){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            // 如果map中存在该key，说明该括号为右括号，判断栈是否为空以及栈推出的内容是否等于该括号匹配的括号，如果不是，返回false，如果是，进行出栈操作
            if (bracketsHashMap.containsKey(ch)) {
                if (characterStack.isEmpty() || characterStack.pop() != bracketsHashMap.get(ch)) {
                    return false;
                }
            } else {
                // 左括号进栈
                characterStack.push(ch);
            }
        }
       return characterStack.isEmpty();
    }

    /** 使用数组 **/
    public boolean isValid3(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        char[] stack = new char[N];
        int size = 0;

        for (char cha : chars) {
            if (cha == '(' || cha == '[' || cha == '{') {
                stack[size++] = cha == '(' ? ')' : (cha == '[' ? ']' : '}');
            } else {
                if (size == 0){
                    return false;
                }
                if (stack[--size] != cha) {
                    return false;
                }
            }
        }
        return size == 0;
    }

    /**
     * 巧妙方式，但时间复杂度过高
     * @param s
     * @return
     */
    public static boolean isValid2(String s){
        while(true){
            int l=s.length();
            s=s.replace("()","");
            s=s.replace("{}","");
            s=s.replace("[]","");
            if(s.length()==l){return l==0;}
        }
    }


    public static void main(String[] args) {
        String str = "()";
        boolean valid = isValid(str);
//        String s = "{[[[(())]]]}()";
//        boolean valid2 = isValid2(s);
//        System.out.println(valid2);
        System.out.println(valid);
    }
}
