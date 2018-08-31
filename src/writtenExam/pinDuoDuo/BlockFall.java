package writtenExam.pinDuoDuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
4 6
. o . . o o
o . o x o o
. . . o o .
x . x . x o
 ->
 ....o.
 ..xxo.
 o...o.
 x.x.x.
 */
public class BlockFall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        // o:wood x:obstacle .:none
        Character[][] matrix = new Character[n][m];
        for (int i = 0; i < n; i++) {
            data = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = data[j].charAt(0);
            }
        }
        //11.51
        for (int i = 0; i < m; i++) { //col
            for (int pos = n - 1; pos > -1; ) {
                if (matrix[pos][i] == 'o') {
                    if (pos == n - 1) {
                        matrix[pos][i] = '.';
                        pos--;
                    } else if (matrix[pos + 1][i] == '.') {
                        matrix[pos][i] = '.';
                        matrix[pos + 1][i] = 'o';
                        pos++;
                    } else {
                        pos--;
                    }
                } else {
                    pos--;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }

            /*int pos = n - 1;
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
            }*/


    }

}
