package meituan.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");
            int sum=0;
            for (int j=0;j<words.length;j++){
                sum+=Integer.parseInt(words[j]);
            }
            if (sum/2>=n){
                System.out.print("No");
            }else{
                System.out.print("Yes");
            }
        }
    }
}
