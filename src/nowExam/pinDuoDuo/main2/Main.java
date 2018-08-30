package nowExam.pinDuoDuo.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split("");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        // o:wood x:obstacle .:none
        Character[][] matrix = new Character[n][m];
        for (int i = 0; i < n; i++) {
            data = br.readLine().trim().split("");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = data[j].charAt(0);
            }
        }

        for (int i = 0; i < m; i++) { //col
            int pos = n - 1;
            while (matrix[pos][i] != 'o') {
                pos--;
            }
            if (matrix[pos][i] == 'o') {
                if (pos == n - 1) {
                    matrix[pos][i] = '.';
                }
                if (pos > 0 && pos + 1 < n) {
                    if (matrix[pos + 1][i] == '.') {
                        matrix[pos][i] = '.';
                        matrix[pos][i + 1] = 'o';
                    }
                }
            }


        }
    }

}
