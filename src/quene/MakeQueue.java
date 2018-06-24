package quene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MakeQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bf.readLine());
            //Queue<Integer> queue = new ArrayBlockingQueue<Integer>(2 * n);
            List<Integer> list=new ArrayList<>();
            for (int j = n; j > 0; j--) {
                list.add(0,j);
                int tail=list.remove(list.size()-1);
                list.add(0,tail);
            }
            StringBuffer output=new StringBuffer();
            for(Integer a:list){
                output.append(a).append(" ");
            }
            System.out.println(output.substring(0,output.length()-1));
        }
    }
}
