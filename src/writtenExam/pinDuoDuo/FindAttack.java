package writtenExam.pinDuoDuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FindAttack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double HP = Double.parseDouble(br.readLine().trim());
        double normalAttack = Double.parseDouble(br.readLine().trim());
        double buffedAttack = Double.parseDouble(br.readLine().trim());
        double round1 = Math.ceil(HP / normalAttack);
        double round2;
        double mid = HP % buffedAttack;
        if (mid == 0) {
            round2 = Math.ceil((HP / buffedAttack));
        } else if (mid <= normalAttack) {
            round2 = (HP / buffedAttack) * 2+1;
        } else {
            round2 = Math.ceil(HP*2 /buffedAttack);
        }
        /*if (HP % 2 == 0) {
            if (Math.ceil(HP * 2 / buffedAttack) < round2) {
                round2 = Math.ceil(HP * 2 / buffedAttack);
            }
        } else {
            if (Math.ceil((HP - normalAttack) * 2 / buffedAttack) + 1 < round2) {
                round2 = Math.ceil((HP - normalAttack) * 2 / buffedAttack) + 1;
            }
        }*/
        System.out.println((int) Math.min(round1,round2));
    }
}
