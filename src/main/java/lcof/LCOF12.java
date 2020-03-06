package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF12
 * @Author: markey
 * @Description:面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/2 22:21
 * @Version: 1.0
 */
public class LCOF12 {
    // 先找到开头，然后递归找剩下的字母，因为每一节点不能重入，需要保存已经走过的节点
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<int[]> locations = new ArrayList<>();
                    res = exist(locations, board, word, i, j);
                }
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(List<int[]> locations, char[][] board, String word, int x, int y) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            System.out.println("x:" + x + "y:" + y + "out of range" + word.charAt(0));
            return false;
        }

        if (word.length() == 1) {
            if (!locationHas(locations, x, y) && board[x][y] == word.charAt(0)) {
                return true;
            }
            return false;
        }

        if (locationHas(locations, x, y) || board[x][y] != word.charAt(0)) {
            System.out.println("x:" + x + "y:" + y + "!=" + word.charAt(0));
            return false;
        }

        List<int[]> newLocations = new ArrayList<>(Arrays.asList(new int[locations.size()][]));
        Collections.copy(newLocations, locations);
        newLocations.add(new int[] {x, y});
        System.out.println(locations);
        return exist(newLocations, board, word.substring(1), x+1, y) || exist(newLocations, board, word.substring(1), x-1, y)
                || exist(newLocations, board, word.substring(1), x, y+1)
                || exist(newLocations, board, word.substring(1), x, y-1);
    }

    public boolean locationHas(List<int[]> locations, int x, int y) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i)[0] == x && locations.get(i)[1] == y) {
                return true;
            }
        }
        return false;
    }
}
