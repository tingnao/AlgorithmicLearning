package nt.study.leetcode.string;

public class 六_Z字形变换 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        // 如果排成一行或者第一列可以排完，直接返回
        if(numRows == 1 || s.length() <= numRows){
            return s;
        }
        // 找到一个周期所需要的字符个数， 个数为numRows + (numsRows - 2);
        int t = numRows * 2 - 2;
        // 列数 = [总字符（s.length)/一个周期所需的字符个数(t)] * 一个周期占用的列数, []表示向上取整，所以需要加1
        int c = (s.length()/t + 1) * (numRows - 1);
        // 用于存放字符
        char[][] arrs = new char[numRows][c];
        int columnIndex = 0, rowIndex = -1;
        boolean  flag = false;
        for (int i = 0; i < s.length(); i++) {
            // 如果处于斜向上的范围内，flag就为true，否则为false
            if(flag){
                rowIndex --;
                columnIndex ++;
                arrs[rowIndex][columnIndex] = s.charAt(i);
                if(rowIndex == 0){
                    flag = false;
                }
            }else{
                rowIndex ++;
                arrs[rowIndex][columnIndex] = s.charAt(i);
                if(rowIndex == numRows - 1) {
                    flag = true;
                }
            }
        }
        // 输出转换后的内容
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <c; j++) {
                if(arrs[i][j] != '\0'){
                    stringBuilder.append(arrs[i][j]);
                }
            }
        }
        return stringBuilder.toString();

    }

    public static String leetcodeConvert(String s, int numRows){
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            // 根据周期判断是否处于斜向上的范围内
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
