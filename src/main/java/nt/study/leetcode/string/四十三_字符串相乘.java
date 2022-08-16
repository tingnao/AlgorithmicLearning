package nt.study.leetcode.string;



public class 四十三_字符串相乘 {
    /**
     *给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/multiply-strin]
     *
     * gs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        String ans = "0";
        for (int i = len1 - 1; i >= 0 ; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = len1 - 1; j > i; j--){
                stringBuilder.append(0);
            }
            int add = 0;
            for(int j = len2 - 1; j >= 0; j--){
                add = add + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                stringBuilder.append(add % 10);
                add = add / 10;
            }
            if(add !=  0){
                stringBuilder.append(add);
            }
            ans = addStrings(ans, stringBuilder.reverse().toString());
        }
        return ans;
    }


    public static String addStrings(String num1, String num2){
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(i >=0 ||  j >= 0 || add  != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            add = add + x + y;
            stringBuilder.append(add % 10);
            add = add / 10;
            i--;
            j--;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1", num2 = "456";
        String s = multiply(num1, num2);
        System.out.println(s);
    }



}
