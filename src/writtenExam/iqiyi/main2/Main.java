package writtenExam.iqiyi.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().trim().split(" ");
        int n = Integer.parseInt(words[0]);
        int m = Integer.parseInt(words[1]);
        int p = Integer.parseInt(words[2]);
        words = br.readLine().trim().split(" ");
        int ai[] = new int[words.length];
        for (int i = 0; i < ai.length; i++) {
            ai[i] = Integer.parseInt(words[i]);
        }
        for (int i=0;i<m;i++){
            words=br.readLine().trim().split(" ");
            if (words[0].equals("A")){
                ai[Integer.parseInt(words[1])-1]++;
            }else if (words[0].equals("B")){
                ai[Integer.parseInt(words[1])-1]--;
            }
        }
        int count=ai[p-1];
        int score=1;
        for (int i=0;i<ai.length;i++){
            if (ai[i]>count){
                score++;
            }
        }
        System.out.println(score);
    }

}
