package competition.day20200404;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200404
 * @ClassName: Geometric5361
 * @Author: markey
 * @Description:
 * 5361. 圆和矩形是否有重叠 显示英文描述
 * 用户通过次数27
 * 用户尝试次数74
 * 通过次数28
 * 提交次数105
 * 题目难度Medium
 * 给你一个以 (radius, x_center, y_center) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2)，其中 (x1, y1) 是矩形左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果圆和矩形有重叠的部分，请你返回 True ，否则返回 False 。
 *
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形有公共点 (1,0)
 * 示例 2：
 *
 *
 *
 * 输入：radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3
 * 输出：true
 * 示例 4：
 *
 * 输入：radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= radius <= 2000
 * -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4
 * x1 < x2
 * y1 < y2
 * @Date: 2020/4/4 22:54
 * @Version: 1.0
 */
public class Geometric5361 {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int lengthX = (x2 - x1) / 2, lengthY = (y2 - y1) / 2; // 矩形长宽
        int rectangleX = x1 + lengthX, rectangleY = y1 + lengthX; // 矩形中心位置y
        double distance = Math.sqrt((x_center - rectangleX) * (x_center - rectangleX) + (y_center - rectangleY) * (y_center - rectangleY)); // 矩形和圆形的中心距离
        // 圆在矩形内部
        if (x_center > x1 && x_center < x2 ) {
            if (y_center - radius < y2 && y_center > y2
                    || y_center > y1 && y_center - radius < y1
                    || y_center > y1 && y_center < y2) {
                return true;
            } else {
                return false;
            }
        }
        // 根据圆形与矩形的相对位置来判断 他们的中心距离是否符合要求
        if (x_center <= x1) {
            if (x1 - x_center <= radius && y_center <= y2 && y_center >= y1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (x_center - x2 <= radius && y_center <= y2 && y_center >= y1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
