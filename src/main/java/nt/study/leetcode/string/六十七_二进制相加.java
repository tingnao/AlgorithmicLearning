package nt.study.leetcode.string;

public class 六十七_二进制相加 {
    /**
     * 模拟加法
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int len1 = a.length() - 1, len2 = b.length() - 1, add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(len1 >= 0 || len2 >= 0 || add != 0){
            int x = len1 >= 0 ? a.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? b.charAt(len2) - '0' : 0;
            add = add + x + y;
            stringBuilder.append(add % 2);
            add = add / 2;
            len2 --;
            len1 --;
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * 位操作 （存在溢出问题）
     */
    public static String addBinary2(String a, String b){
        int left = Integer.parseUnsignedInt(a, 2), right = Integer.parseUnsignedInt(b, 2);
        while(right != 0){
            int temp = left ^ right;
            right = (left & right) << 1;
            left = temp;
//            System.out.println(Integer.toBinaryString(left));
//            System.out.println(Integer.toBinaryString(right));
        }
        return Integer.toBinaryString(left);
    }

    public static void main(String[] args) {
        String s = addBinary("11110", "10101");
        System.out.println(addBinary2("111110", "1000"));
        System.out.println(s);
    }
}
