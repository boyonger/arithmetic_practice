package writtenExam.xiecheng.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
2
p 1 1
p 2 2
g 1
p 2 102
p 3 3
g 1
g 2
g 3
*/
//一般情况下不要想着去结束输入输出流，如果没有限定输入行数则动态输出即可
public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> LRU = new HashMap<>(); // 0 频率 1数值
        Map<Integer, Integer> times = new HashMap<>();
        int size = 0;
        List<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine().trim());
        String str;
        while ((str = br.readLine()) != null) {
            String[] data = str.split(" ");
            if (data[0].equals("")){
                break;
            }
            if (data[0].equals("p")) {
                if (LRU.size() < size) {
                    int key = Integer.parseInt(data[1]);
                    int value = Integer.parseInt(data[2]);
                    if (LRU.containsKey(key)) {
                        LRU.put(key, value);
                    } else {
                        LRU.put(key, value);
                        Integer a = times.get(key);
                        if (a == null) {
                            times.put(key, 1);
                        } else {
                            times.put(key, a + 1);
                        }
                    }
                } else {
                    int key = Integer.parseInt(data[1]);
                    int value = Integer.parseInt(data[2]);
                    int sum = Integer.MAX_VALUE;
                    Integer twoKey = 0;
                    for (Map.Entry<Integer, Integer> entry : times.entrySet()) {
                        if (entry.getValue() < sum) {
                            sum = entry.getValue();
                            twoKey = entry.getKey();
                        }
                    }
                    times.remove(twoKey);
                    LRU.put(key, value);
                    times.put(key, 1);
                }
            } else if (data[0].equals("g")) {
                Integer a = LRU.get(Integer.parseInt(data[1]));
                Integer b = times.get(a);
                if (a == null) {
                    times.put(b, 1);
                } else {
                    times.put(b, a + 1);
                }
                /*System.out.println(a);*/
                result.add(a);
            }
        }

        for (Integer a : result) {
            System.out.println(a);
        }
    }
}
