package leetcode.dfs;

/*
leetcode 63
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。
说明：m 和 n 的值均不超过 100。
示例 1:
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
public class DifferentRoad {

    public int count = 0;

    /* 深度遍历超时
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 递归dfs
        // 先设置访问过的矩阵
        int[][] visited = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = 0;
            }
        }
        dfs(0, 0, obstacleGrid, visited);
        return count;
    }

    // 所在位置必定是0
    public void dfs(int x, int y, int[][] obstacleGrid, int[][] visited) {
        int xLengthPos = obstacleGrid.length - 1;
        int yLengthPos = obstacleGrid[0].length - 1;
        if (x > xLengthPos || y > yLengthPos) {
            // 越界返回
            return;
        }
        if (obstacleGrid[x][y] == 1 || visited[x][y] == 1) {
            return;
        }
        if (x == xLengthPos && y == yLengthPos) {
            count++;
        } else {
            // 访问过
            //visited[x][y] = 1;
            // 向右
            dfs(x + 1, y, obstacleGrid, visited);
            // 向下
            dfs(x, y + 1, obstacleGrid, visited);
        }
    }
     */

    // 尝试使用动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // lcs 动态规划
        int[][] lcs = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1 || (j > 0 && lcs[i][j - 1] == 0)) {
                        lcs[i][j] = 0;
                    } else {
                        lcs[i][j] = 1;
                    }
                }
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1 || (i > 0 && lcs[i - 1][j] == 0)) {
                        lcs[i][j] = 0;
                    } else {
                        lcs[i][j] = 1;
                    }
                }
                if (i != 0 && j != 0) {
                    // 对应的obstacleGrid需要0
                    if (obstacleGrid[i][j] == 1) {
                        lcs[i][j] = 0;
                    } else {
                        lcs[i][j] = lcs[i - 1][j] + lcs[i][j - 1];
                    }
                }
            }
        }
        return lcs[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(new DifferentRoad().uniquePathsWithObstacles(a));
    }
}
