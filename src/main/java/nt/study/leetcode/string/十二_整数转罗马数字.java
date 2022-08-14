package nt.study.leetcode.string;

public class 十二_整数转罗马数字 {
    /**
     * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        String[] symbols = new String[]{
                "M","CM","D","CD","C","XC","L","XL","X","IX", "V", "IV","I"
        };
        int[] values = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < symbols.length; i++){
            while(num >= values[i]){
                stringBuilder.append(symbols[i]);
                num -= values[i];
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);
    }
}
