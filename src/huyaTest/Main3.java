package huyaTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int[][] number=new int[a][2];
        for (int i=0;i<a;i++){
            for(int j=0;j<2;j++){
                number[i][j]=1;
            }
        }
        Map<Integer,Integer> d=new HashMap<>();
        for (int i = 0; i < b; i++) {
            int getNext1,getNext2;
            getNext1=input.nextInt();
            getNext2=input.nextInt();
            d.put(getNext1,getNext2);
            if (getNext1%a==0){
                number[getNext1/a][0]=0;
            }else {
                number[getNext1/a][1]=0;
            }
            if (getNext2%a==0){
                number[getNext2/a][0]=0;
            }else{
                number[getNext2/a][1]=0;
            }
        }

    }
}
