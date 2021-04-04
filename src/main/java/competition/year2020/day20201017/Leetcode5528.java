package competition.year2020.day20201017;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201017
 * @ClassName: Leetcode5528
 * @Author: markey
 * @Description:
 * @Date: 2020/10/17 22:40
 * @Version: 1.0
 */
public class Leetcode5528 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        for (int i = 0; i < towers.length; i++) {
            int[] tower = towers[i];
            xMin = Math.min(xMin, tower[0]);
            xMax = Math.max(xMax, tower[0]);
            yMin = Math.min(yMin, tower[1]);
            yMax = Math.max(yMax, tower[1]);
        }
        int resX = 0, resY = 0;
        double max = Integer.MIN_VALUE;
        for (int i = xMin; i <= xMax ; i++) {
            for (int j = yMin; j <= yMax; j++) {
                int coordinate = 0;
                for (int k = 0; k < towers.length; k++) {
                    coordinate += coordinate(i, j, towers[k], radius);
                }
                if (coordinate > max) {
                    max = coordinate;
                    resX = i;
                    resY = j;
                }
                if (i == 7 || i == 48 ) {
                System.out.println(i + ":" + j + "->" +coordinate);
                }
            }
        }
        return new int[] {resX,  resY};
    }

    private double coordinate(int x, int y, int[] tower, int radius) {
        double d = Math.sqrt(Math.pow(x - tower[0], 2) + Math.pow(y - tower[1], 2));
        if (d <= radius) {
            return Math.floor(tower[2] / (d + 1));
        } else {
            return 0;
        }
    }
}
