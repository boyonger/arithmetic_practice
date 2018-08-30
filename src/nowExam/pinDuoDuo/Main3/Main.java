package nowExam.pinDuoDuo.Main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
3 4
CAKE
TORN
SHOW
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int n = Integer.parseInt(data[0]);
        int l = Integer.parseInt(data[1]);
        String[] getName = new String[l];
        for (int i=0;i<l;i++){
            getName[i]="";
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < l; j++) {
                getName[j] = getName[j] + s.charAt(j);
            }
        }
        for (int i=0;i<getName.length;i++){
            Character[] mid=bubbleSort(getName[i]);
            StringBuffer stringBuffer=new StringBuffer();
            for (int j=0;j<mid.length;j++){
                stringBuffer.append(mid[j]);
            }
            getName[i]=stringBuffer.toString();
        }
        /*for (int i=0;i<getName.length;i++){
            System.out.println(getName[i]);
        }*/
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<getName.length;i++){
            stringBuffer.append(getName[i].charAt(0));
        }
        System.out.println(stringBuffer.toString());
    }

    public static Character[] bubbleSort(String str) {
        Character[] a=new Character[str.length()];
        for (int i=0;i<a.length;i++){
            a[i]=str.charAt(i);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    char mid = a[i];
                    a[i] = a[j];
                    a[j] = mid;
                }
            }
        }
        return a;
    }
}
