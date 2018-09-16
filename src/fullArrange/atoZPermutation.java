package fullArrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//n个a m个z aazz 开始字典排序 azaz azza
public class atoZPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] countString = br.readLine().trim().split(" ");
        int n = Integer.parseInt(countString[0]);
        int m = Integer.parseInt(countString[1]);
        int k = Integer.parseInt(countString[2]);
        List<Character> spellList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            spellList.add('a');
        }
        /*for (int i=0;i<m;i++){
            spellList.changeTo('z');
        }*/
        int t = k % m;
        int number = k / m;
        if (n < t) {
            System.out.print(-1);
        } else {

        }


    }
}
