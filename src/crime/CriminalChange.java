package crime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CriminalChange {
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Integer number = 0;
        while ((str = bf.readLine()) != null) {
        //while (in.hasNext()){
            number = Integer.parseInt(str); //number = in.nextInt();
            int[][] save = new int[number][2];
            for (int i = 0; i < number&& ((str = bf.readLine()) != null) ; i++) {     //&&
                String[] data = str.split(" ");
                save[i][0] = Integer.parseInt(data[0]);  //in.nextInt();
                save[i][1] = Integer.parseInt(data[1]);  //in.nextInt();
            }

            int maxx = save[0][0];
            int maxy = save[0][1];
            int minx = save[0][0];
            int miny = save[0][1];
            for (int i = 0; i < save.length; i++) {
                if (maxx < save[i][0]) {
                    maxx = save[i][0];
                } else if (minx > save[i][0]) {
                    minx = save[i][0];
                }
                if (maxy < save[i][1]) {
                    maxy = save[i][1];
                } else if (miny > save[i][1]) { //=save[i][0] ???
                    miny = save[i][1];
                }
            }
            int xsquare = (maxx - minx) * (maxx - minx);
            int ysquare = (maxy - miny) * (maxy - miny);

            if (xsquare > ysquare)
                System.out.println(xsquare);
            else System.out.println(ysquare);
        }
    }
}
