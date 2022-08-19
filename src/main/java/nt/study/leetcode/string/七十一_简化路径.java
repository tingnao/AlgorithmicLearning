package nt.study.leetcode.string;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;

public class 七十一_简化路径 {
    /**
     * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     *
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     *
     * 请注意，返回的 规范路径 必须遵循下述格式：
     *
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/simplify-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static String simplifyPath(String path) {
        Stack charStack  = new Stack();
        int len = path.length();
        for (int i = 0; i < len; i++) {
            char ch =  path.charAt(i);
            switch (ch){
                case '/':
                    if(charStack.isEmpty()){
                        charStack.push(ch);
                        break;
                    }
                    char value = (char) charStack.peek();
                    if(value != '/' ) {
                        charStack.push(ch);
                    }
                    break;
                case '.':
                    char value2 = (char) charStack.peek();
                    if(value2 =='/'){
                        int j = i;
                        while(true){
                            if(path.charAt(j) != '.'&& path.charAt(j) != '/'){
                                charStack.push(ch);
                                break;
                            }
                            j++;
                            if(j == len  || path.charAt(j) == '/'){
                                int k = j - i ;
                                if(k > 2){
                                    charStack.push(ch);
                                    break;
                                }
                                i = j - 1;
                                int count = 0;
                                while(charStack.size() > 1 && count != k){
                                    if((char)charStack.peek() == '/'){
                                        count ++;
                                    }
                                    charStack.pop();

                                }
                                break;
                            }

                        }

                    }else{
                        charStack.push(ch);
                    }
                    break;
                default:
                    charStack.push(ch);
            }
        }
        while(charStack.size() > 1){
            if((char) charStack.peek() != '/'){
                break;
            }
            charStack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = charStack.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(charStack.pop());
        }
        return stringBuilder.reverse().toString();
    }


    public static String simplifyPath2(String path){
        String[] names = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String name : names) {
            if(Objects.equals("..", name)){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }else if(!Objects.equals(".", name) && name.length() > 0){
                deque.offerLast(name);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(deque.isEmpty()){
            stringBuilder.append("/");
        }else{
            for (String s : deque) {
                stringBuilder.append("/");
                stringBuilder.append(s);
            }
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(simplifyPath2("/../"));
    }
}
