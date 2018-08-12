package before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SugarList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        Set<Integer> sugarSet = new HashSet<>();
        for (String a:data){
            sugarSet.add(Integer.parseInt(a));
        }

        int sum=0;
        for (int s:sugarSet){
            sum+=s+1;
        }
        System.out.println(sum);



    }
}
