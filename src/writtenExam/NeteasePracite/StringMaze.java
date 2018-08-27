package writtenExam.NeteasePracite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//15.37 17.02
public class StringMaze {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String[] data = br.readLine().split(" ");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            Character[][] maze = new Character[row][col];
            for (int j = 0; j < row; j++) {
                String str = br.readLine();
                for (int t = 0; t < col; t++) {
                    maze[j][t] = str.charAt(t);
                }
            }
            int[] position = {0, 0};
            String word = br.readLine().trim();
            int sum = dfs(word, maze);
            list.add(sum + "");
        }
        for (String a : list) {
            System.out.println(a);
        }
    }


    public static boolean judge(int[] position, int row, int col) {
        if (position[0] >= row || position[1] >= col) {
            return false;
        } else {
            return true;
        }
    }

    public static int dfs(String word, Character[][] maze) { //[0] [1]
        int sum = 0;
        for (int k = 0; k < maze.length; k++) {
            for (int p = 0; p < maze[0].length; p++) {
                int[] position = {k, p};
                if (maze[position[0]][position[1]] == word.charAt(0)) {
                    //three
                    boolean[] trueList = {true, true, true};
                    for (int i = 1; i < word.length(); i++) {
                        position[0]++;
                        if (!judge(position, maze.length, maze[0].length)) {
                            trueList[0] = false;
                            break;
                        }
                        if (maze[position[0]][position[1]] != word.charAt(i)) {
                            trueList[0] = false;
                            break;
                        }
                    }
                    position[0] = k;
                    position[1] = p;
                    for (int i = 1; i < word.length(); i++) {
                        position[1]++;
                        if (!judge(position, maze.length, maze[0].length)) {
                            trueList[1] = false;
                            break;
                        }
                        if (maze[position[0]][position[1]] != word.charAt(i)) {
                            trueList[1] = false;
                            break;
                        }
                    }
                    position[0] = k;
                    position[1] = p;
                    for (int i = 1; i < word.length(); i++) {
                        position[0]++;
                        position[1]++;
                        if (!judge(position, maze.length, maze[0].length)) {
                            trueList[2] = false;
                            break;
                        }
                        if (maze[position[0]][position[1]] != word.charAt(i)) {
                            trueList[2] = false;
                            break;
                        }
                    }
                    for (boolean a : trueList) {
                        if (a == true) {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
