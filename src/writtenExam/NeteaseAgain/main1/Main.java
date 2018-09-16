package writtenExam.NeteaseAgain.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        int bCount = 0;
        int wCount = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == 'b') {
                bCount++;
            } else if (data.charAt(i) == 'w') {
                wCount++;
            }
        }
        if (bCount>wCount){
                System.out.println(wCount*2+1);
        }else if (wCount>bCount){
            System.out.println(bCount*2+1);
        }else{
            System.out.println(wCount*2);
        }
    }
}
