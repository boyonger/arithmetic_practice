package wangyigame.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2first 1second 0third
        int peopleCount = Integer.parseInt(br.readLine().trim());
        Map<String, List> peopleMap = new HashMap<>();
        List<String> peopleName = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            String[] data = br.readLine().split(" ");
            List<Integer> status = new ArrayList<>(); //0 拥有者 1上下线
            status.add(Integer.parseInt(data[0]));
            status.add(0);
            peopleMap.put(data[1], status);
            peopleName.add(data[1]);
        }
        int changeCount = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < changeCount; i++) {
            String[] data = br.readLine().split(" ");
            List<Integer> mid = peopleMap.get(data[0]);
            mid.set(1, Integer.parseInt(data[1]));
            peopleMap.put(data[0], mid);
        }
        List<String> peopleEnd = new ArrayList<>();
        while (!peopleMap.isEmpty()) {
            String first = peopleName.get(0);
            List<Integer> midT = peopleMap.get(first);
            for (Map.Entry<String, List> entry : peopleMap.entrySet()) {
                List<Integer> midInMap = entry.getValue();
                if (midInMap.get(1).compareTo(midT.get(1)) == 1) {
                    first = entry.getKey();
                    midT = midInMap;
                } else if (midInMap.get(1).equals(midT.get(1)) && midInMap.get(0).compareTo(midT.get(0)) == 1) {
                    first = entry.getKey();
                    midT = midInMap;
                } else if (midInMap.get(1).equals(midT.get(1)) && midInMap.get(0).equals(midT.get(0)) && entry.getKey().compareTo(first) == -1) {
                    first = entry.getKey();
                    midT = midInMap;
                }
            }
            peopleEnd.add(first);
            peopleMap.remove(first);
            peopleName.remove(first);
        }

        for (int i = 0; i < peopleEnd.size(); i++) {
            if (i != peopleEnd.size() - 1) {
                System.out.println(peopleEnd.get(i));
            } else {
                System.out.print(peopleEnd.get(i));
            }
        }

    }
}

