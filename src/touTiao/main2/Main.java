package touTiao.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
5
1 0 0 1 1
1 0 0 1 1
0 0 1 0 0
0 0 1 0 0
0 0 1 0 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        List<List<List<Integer>>> numberPos = new ArrayList<>(); //get 0 横坐标 get 1纵坐标  0开始
        for (int i = 0; i < count; i++) {
            String[] data = br.readLine().trim().split(" ");
            for (int j = 0; j < data.length; j++) {
                if (data[j].equals("1")) {
                    boolean flag = false;
                    for (int t = 0; t < numberPos.size(); t++) {
                        boolean flag2 = false;
                        for (int inT = 0; inT < numberPos.get(t).size(); inT++) {
                            List<Integer> list = numberPos.get(t).get(inT);
                            if (((list.get(0) + 1) == i && (list.get(1)) == j)
                                    || (list.get(1) + 1 == j && list.get(0) == i)) {
                                flag = true;
                                flag2 = true;
                                List<Integer> list1 = new ArrayList<>();
                                list1.add(i);
                                list1.add(j);
                                List<List<Integer>> secList = numberPos.get(t);
                                secList.add(list1);
                                //numberPos.remove(t);
                                //numberPos.add(secList);
                                break;
                            }
                        }
                        if (flag2 == true) {
                            break;
                        }
                    }
                    if (flag == false) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        List<List<Integer>> secList = new ArrayList<>();
                        secList.add(list);
                        numberPos.add(secList);
                    }
                }
            }
        }
        System.out.println(numberPos.size());
    }
}

