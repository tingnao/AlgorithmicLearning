package nt.study.leetcode.string;

import java.util.*;

public class DFA算法 {
    /**
     * DFA(Deterministic Finite Automaton，即确定有穷自动机)
     * 算法是通过提前构造出一个 树状查找结构(实际上应该说是一个 森林)，之后根据输入在该树状结构中就可以进行非常高效的查找。
     *
     * 设我们有一个敏感词库，词酷中的词汇为：
     * 我爱你
     * 我爱他
     * 我爱她
     * 我爱你呀
     * 我爱他呀
     * 我爱她呀
     * 我爱她啊
     *
     * 那么就可以构造出这样的树状结构：
     *                          -> 呀
     *                    -> 你 -> end
     *
     *                          ->呀
     *  节点 -> 我  -> 爱  -> 他  ->end
     *
     *                          ->呀
     *                    -> 她 ->end
     *                          ->啊
     *
     *                          设玩家输入的字符串为：白菊我爱你呀哈哈哈
     *
     * 我们遍历玩家输入的字符串 str，并设指针 i 指向树状结构的根节点，即最左边的空白节点：
     * str[0] = ‘白’ 时，此时 tree[i] 没有指向值为 ‘白’ 的节点，所以不满足匹配条件，继续往下遍历
     * str[1] = ‘菊’，同样不满足匹配条件，继续遍历
     * str[2] = ‘我’，此时 tree[i] 有一条路径连接着 ‘我’ 这个节点，满足匹配条件，i 指向 ‘我’ 这个节点，然后继续遍历
     * str[3] = ‘爱’，此时 tree[i] 有一条路径连着 ‘爱’ 这个节点，满足匹配条件，i 指向 ‘爱’，继续遍历
     * str[4] = ‘你’，同样有路径，i 指向 ‘你’，继续遍历
     * str[5] = ‘呀’，同样有路径，i 指向 ‘呀’
     * 此时，我们的指针 i 已经指向了树状结构的末尾，即此时已经完成了一次敏感词判断。我们可以用变量来记录下这次敏感词匹配开始时玩家输入字符串的下标，和匹配结束时的下标，然后再遍历一次将字符替换为 * 即可。
     * 结束一次匹配后，我们把指针 i 重新指向树状结构的根节点处。
     * 此时我们玩家输入的字符串还没有遍历到头，所以继续遍历：
     * str[6] = ‘哈’，不满足匹配条件，继续遍历
     * str[7] = ‘哈’ …
     * str[8] = ‘哈’ …
     *
     *
     * 我们还可以直接用 哈希表来作为森林的入口节点：
     * 该哈希表中存放着 一系列 Key 为 不同的敏感词开头字符 Value 为 表示该字符的节点 的键值对
     * 并且因为哈希表可以存放不同类型对象的特点(只要继承自 object)，我们还可以存放可一个 Key 为 ‘IsEnd’ Value 为 false 的键值对。 Value 为 false 表示当前节点不为结构的末尾， Value 为 true 表示当前节点为结构的末尾。
     * 那么对于结构中的其它节点，同样可以用哈希表来构造。 对于该节点表示的字符，我们在其父节点中包含的键值对中已经存储了(因为我们的结构最终有一个空白根节点，其里面的键值对，Key 存储了敏感词汇的开头字符，
     * Value 就又是一个哈希表 即其子节点)
     * 并且每个节点，也就是哈希表，里面也存储一个 Kye 为 “isEnd” Value 为 0/1 的键值对。 然后也存储了一系列的 Key 为其子节点表示的字符， Value 为其子节点(哈希表) 的键值对
     */

    private static HashMap<String, Object> hashMap;

    /**
     * 初始化敏感字符森林
     * @param words
     */
    private static void initFilter(List<String> words){
        // 避免重复构造
        if(!Objects.isNull(hashMap)){
            return ;
        }
        // 无意义参数过滤
        if (Objects.isNull(words) || words.size() == 0){
            return ;
        }
        // 减少扩容消耗
        hashMap = new HashMap<>(words.size());
        HashMap indexMap;
        for (String word : words) {
            indexMap = hashMap;
            // 遍历敏感词
            for (int i = 0; i < word.length(); i++) {
                // 得到当前敏感字符
                char c = word.charAt(i);
                // 如果当前hashMap中包含该字符，获取下一个敏感字符的节点
                if(indexMap.containsKey(c)){
                    indexMap = (HashMap) indexMap.get(c);
                }else{
                // 如果不包含，创建一个hashMap，以敏感字符作为key，hashMap作为value存放到当前map中
                    HashMap<String, Object> characterHashtableHashtable = new HashMap<>();
                    // 添加结尾标识符
                    characterHashtableHashtable.put("IsEnd", false);
                    indexMap.put(c, characterHashtableHashtable);
                    // 获取下一个敏感字符的节点进行下一次敏感字符的构造
                    indexMap = characterHashtableHashtable;
                }
                // 如果到达敏感字符的末尾，设置结尾标识符为true
                if(i == word.length() - 1){
                    indexMap.put("IsEnd", true);
                }
            }
        }
    }

    /**
     * 检查是否在beginIndex到txt.length - 1的范围内是否存在以beginIndex为开头的敏感词
     * @param txt
     * @param beginIndex
     * @return
     */
    private static int checkFilterWord(String txt, int beginIndex){
        if(Objects.isNull(txt) || beginIndex < 0 || beginIndex >= txt.length()){
            return 0;
        }
        int len = txt.length(), left = beginIndex, size = 0;
        boolean existFlag = false;
        HashMap currentMap = hashMap;
        while(left < len){
             HashMap tempMap= (HashMap)currentMap.get(txt.charAt(left));
             if(!Objects.isNull(tempMap)){
                currentMap = tempMap;
                if((boolean)currentMap.get("IsEnd")){
                    existFlag = true;
                }
                size ++;
            }else{
                 break;
             }
             left ++;
        }
        return existFlag ? size : 0;
    }

    /**
     * 遍历txt，进行搜查敏感词并替换
     * @param txt
     * @return
     */
    public static String SerachFilterWordAndReplace(String txt)
    {
        if(Objects.isNull(txt)){
            return null;
        }
        int len = txt.length(), i = 0;
        while(i < len){
            int size  = checkFilterWord(txt, i);
            if(size != 0){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(txt, 0, i);
                for (int j = 0; j < size; j++) {
                    stringBuilder.append("*");
                }
                stringBuilder.append(txt, i + size, len);
                txt = stringBuilder.toString();
                i += size;
            }else{
                i++;
            }
        }
        return txt;
    }

    public static void main(String[] args) {
        List<String> sensitiveWords = new ArrayList<String>(){{
            add("尼玛死了");
            add("fw");
            add("孤儿");
            add("操");
            add("草");
            add("你妈死了");
            add("nmsl");
            add("妈的");
        }};
        initFilter(sensitiveWords);
        System.out.println(hashMap);
        System.out.println(SerachFilterWordAndReplace("nmsl,尼玛死了，铁孤儿，fw，操，草，妈的，没意思"));
    }




}
