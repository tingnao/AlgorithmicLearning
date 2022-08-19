package nt.study.leetcode.array;


public class test {
    public static void test(String str){
        StringBuilder stringBuilder = new StringBuilder();
        int len = str.length();
        stringBuilder.append(str.charAt(0));
        for (int i = 0; i < len - 1; i++) {
            if(str.charAt(i) != str.charAt(i + 1)){
                stringBuilder.append(str.charAt(i + 1));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String str = "ttest2tttajjaa";
        test(str);
    }
}
