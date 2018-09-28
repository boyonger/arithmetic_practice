package mi.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Set<Integer>> allNumberList = new ArrayList<>();
        String[] data;
        for (int i = 0; i < n; i++) {
            Set<Integer> inSet = new HashSet<>();
            data = br.readLine().split(" ");
            for (int j = 0; j < data.length; j++) {
                inSet.add(Integer.parseInt(data[j]));
            }
            allNumberList.add(inSet);
        }

        if (allNumberList.size() > 1) {
            for (int i = 0; i < allNumberList.size() - 1; i++) {
                for (int j = i + 1; j < allNumberList.size(); j++) {
                    Set<Integer> checkSet = new HashSet<>();
                    checkSet.addAll(allNumberList.get(i));
                    checkSet.addAll(allNumberList.get(j));
                    if (checkSet.size() < allNumberList.get(i).size() + allNumberList.get(j).size()) {
                        allNumberList.remove(i);
                        allNumberList.remove(j - 1);
                        allNumberList.add(i, checkSet);
                        i = 0;
                    }
                }
            }
        }
        int max = 0;
        for (Set<Integer> c : allNumberList) {
            if (c.size() > max) {
                max = c.size();
            }
        }
        System.out.println(allNumberList.size());
        System.out.print(max);
    }
}
