package writtenExam.didi1026.main1;

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int find_cheapest_path(int n, int m, int[][] flights) {
        return 0;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _flights_rows = 0;
        int _flights_cols = 0;
        _flights_rows = Integer.parseInt(in.nextLine().trim());
        _flights_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _flights = new int[_flights_rows][_flights_cols];
        for(int _flights_i=0; _flights_i<_flights_rows; _flights_i++) {
            for(int _flights_j=0; _flights_j<_flights_cols; _flights_j++) {
                _flights[_flights_i][_flights_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = find_cheapest_path(_n, _m, _flights);
        System.out.println(String.valueOf(res));

    }
}
