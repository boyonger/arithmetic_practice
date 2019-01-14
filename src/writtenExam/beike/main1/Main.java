package writtenExam.beike.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public  static  int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        int n = Integer.parseInt(words[0]);
        int m =Integer.parseInt(words[1]);
        dfs(n-1,m);
        System.out.println(sum);
    }
    public static void dfs(int n,int m){
        if (n==0){
            sum=(sum+1)%100000007;
        }else {
            for (int i=1;i<=m;i++){
                if (m%i==0){
                    dfs(n-1,i);
                }
            }
        }
    }
}
