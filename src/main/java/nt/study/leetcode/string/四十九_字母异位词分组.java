package nt.study.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 四十九_字母异位词分组 {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /** 两种方式，一种对字符串进行排序后作为hashmap的key，另一种使用数组记录每个字符出现的次数，通过迭代数组将次数不为0的字符顺序拼接作为hashmap的key
     * hashmap key为String，value为String List;
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        // 判空处理
        if(strs == null || strs.length == 0){
            return resultList;
        }
        HashMap<String, List> resultHashMap = new HashMap<>();
        for (String str : strs) {
            String sortStr = stringSort(str);
            if(resultHashMap.containsKey(sortStr)){
                resultHashMap.get(sortStr).add(str);
            }else{
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                resultHashMap.put(sortStr, arrayList);
            }
        }
        for (String s : resultHashMap.keySet()) {
            resultList.add(resultHashMap.get(s));
        }
        return resultList;
    }

    public static String stringSort(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        quickSort(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void quickSort(char[] chars, int left, int right) {
        if(left >= right){
            return;
        }
        int partition = partition(chars, left, right);
        quickSort(chars, left, partition - 1);
        quickSort(chars, partition + 1, right);
    }

    private static int partition(char[] chars, int left, int right){
        int point = left, index = point + 1;
        for(int i = index ; i <= right; i++){
            if(chars[i] <= chars[point]){
                swap(chars, i, point);
            }
        }
        swap(chars, -- index, point);
        return index;
    }

    private static  void swap(char[] chars, int left, int right){
        if(left == right){
            return ;
        }
        chars[left] = (char)(chars[left] ^ chars[right]);
        chars[right] = (char)(chars[left] ^ chars[right]);
        chars[left] = (char)(chars[left] ^ chars[right]);
    }

    public static void main(String[] args) {
        String hello = stringSort("bcad");
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

}
