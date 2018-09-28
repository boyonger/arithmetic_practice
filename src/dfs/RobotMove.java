package dfs;

/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

 */
public class RobotMove {
    public static void main(String[] args) {
        int k = 18;
        int[][] matrix = new int[2][2];
        int[][] visited = new int[2][2];
        System.out.println(dfs(matrix, visited, 0, 0, k));
    }

    public static int dfs(int[][] matrix, int[][] visited, int row, int col, int k) {
        if (move(visited, row, col, k)) {
            return dfs(matrix, visited, row - 1, col, k) + dfs(matrix, visited, row + 1, col, k) + dfs(matrix, visited, row, col + 1, k)
                    + dfs(matrix, visited, row, col - 1, k) + 1;
        } else {
            return 0;
        }
    }

    public static boolean move(int[][] visited, int row, int col, int k) {    // 0 left 1 right 2 up 3 down
        if (row < 0 || col < 0 || row > visited.length - 1 || col > visited[0].length - 1) {
            return false;
        } else if (visited[row][col] == 1) {
            return false;
        } else {
            int sum = 0;
            while (row != 0) {
                sum += row % 10;
                row /= 10;
            }
            while (col != 0) {
                sum += col % 10;
                col /= 10;
            }
            if (sum > k)
                return false;
        }
        visited[row][col] = 1;
        return true;
    }
}
