package pony.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        int sum=0;
        for (int i=1;i<words.length()-1;i++){
            if (i+2<words.length()&&i+1<words.length()){
                if (words.charAt(i+1)==words.charAt(i+2)&& words.charAt(i)==words.charAt(i+1)){
                   sum++;
                   i++;
                   i++;
                }
            }
            else if (words.charAt(i)==words.charAt(i+1)||words.charAt(i)==words.charAt(i-1)) {
                sum++;
                i++;
            }
        }
        System.out.println(sum);
    }
}
