package nt.study.leetcode.array;

public class 三十六_有效的数独 {
    /**
     * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     *
     * 数字1-9在每一行只能出现一次。
     * 数字1-9在每一列只能出现一次。
     * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图)
     * 注意：
     *
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用'.'表示。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-sudoku
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isValidSudoku(char[][] board){
        // 存储数字行内出现的次数
        int[][] rows = new int[9][9];
        // 指定数字列内出现的次数
        int[][] columns = new int[9][9];
        // 指定数字九宫格内出现的次数
        int[][] squared = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                // 遍历数独中每一个元素
                char c = board[i][j];
                if(c != '.'){
                    // 得到元素的下标
                    int value = c - '0' - 1;
                    // 得到九宫格的下标
                    int index = i / 3 * 3 + j / 3;
                    // 数字行内、列内、九宫格内出现次数都加一
                    rows[i][value] ++;
                    columns[j][value] ++;
                    squared[index][value] ++;
                    // 如果出现次数大于1，数独就无效
                    if(rows[i][value] > 1 || columns[j][value] > 1 || squared[index][value] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
