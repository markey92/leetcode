package competition.year2020.day20200613;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200613
 * @ClassName: Matrix5422
 * @Author: markey
 * @Description:
 * @Date: 2020/6/13 22:36
 * @Version: 1.0
 */
public class Matrix5422 {
    class SubrectangleQueries {
        int[][] rectangle;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    rectangle[i][j] = newValue;
                }

            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }
}
