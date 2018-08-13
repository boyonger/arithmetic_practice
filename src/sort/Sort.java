package sort;

import java.io.IOException;

public class Sort {

    public static void slip(int start,int end,int[] numberList){ //从0开始，end结束（不包括end）
        int x=numberList[start];
        int xPosition=start;
        int j=start;
        for (int i=start+1;i<end;i++){
            if (numberList[i]<x){
                xPosition++;
            }

        }

    }

    public static void main(String[] args) throws IOException {

    }

}
