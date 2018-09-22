package javaBase;

public class tryDfs {

    public static void main(String[] args) {

    }


    public static boolean hasPath(Character[][] matrix, int rows, int cols, int row, int col, String str, int pathLength, boolean[] visited) {
        if (str.length() == pathLength) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(pathLength) && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;
            hasPath = hasPath(matrix, rows, cols, row, col - 1, str, pathLength, visited) ||
                    hasPath(matrix, rows, cols, row, col, str, pathLength, visited);

        }


        if (!hasPath) {
            pathLength--;
            visited[row * cols + col] = false;
        }
        return hasPath;
    }

}
