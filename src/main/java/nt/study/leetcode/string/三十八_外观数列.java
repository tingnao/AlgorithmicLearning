package nt.study.leetcode.string;


public class 三十八_外观数列 {
    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * 前五项如下：
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/count-and-say
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        backTrack(stringBuilder, 1, n);
        return stringBuilder.toString();
    }

    public static void backTrack(StringBuilder stringBuilder, int layers, int end){
        if(layers == end){
            return ;
        }
        String str = stringBuilder.toString();
        stringBuilder = stringBuilder.delete(0, stringBuilder.length());
        int len = str.length(), count = 1;
        char mark = '#';
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == mark){
                count++;
            }else{
                if(mark != '#'){
                    stringBuilder.append(count).append(mark);
                }
                count = 1;
                // 切换标记字符
                mark = str.charAt(i);
            }
            if(i == len - 1){
                stringBuilder.append(count).append(mark);
            }
        }
        backTrack(stringBuilder, layers + 1, end);
    }

    public String newCountAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
