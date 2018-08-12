package wangyigame.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2first 1second 0third
        int peopleCount = Integer.parseInt(br.readLine().trim());
        List<List<String>> peopleName = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            String[] data = br.readLine().split(" ");
            List<String> status = new ArrayList<>(); // name 0 拥有者 1上下线
            status.add(data[1]);
            status.add(data[0]);
            status.add(0 + "");
            boolean flag = false;
            for (int j = 0; j < peopleName.size(); j++) {
                if (status.get(0).compareTo(peopleName.get(j).get(0)) <0) {
                    peopleName.add(j, status);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                peopleName.add(status);
            }
        }
        int changeCount = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < changeCount; i++) {
            String[] data = br.readLine().split(" ");
            List<String> midName = new ArrayList<>();
            for (int j = 0; j < peopleName.size(); j++) {
                if (peopleName.get(j).get(0).equals(data[0])) {
                    midName = peopleName.remove(j);
                    break;
                }
            }
            midName.set(2, data[1]);
            boolean flag = false;
            for (int j = 0; j < peopleName.size(); j++) {
                if (midName.get(2).compareTo(peopleName.get(j).get(2)) == 1) {
                    peopleName.add(j, midName);
                    flag = true;
                    break;
                } else if (midName.get(2).equals(peopleName.get(j).get(2)) && midName.get(1).compareTo(peopleName.get(j).get(1)) == 1) {
                    peopleName.add(j, midName);
                    flag = true;
                    break;
                } else if (midName.get(2).equals(peopleName.get(j).get(2)) && midName.get(1).equals(peopleName.get(j).get(1))
                        && midName.get(0).compareTo(peopleName.get(j).get(0)) <0) {
                    peopleName.add(j, midName);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                peopleName.add(midName);
            }
        }
        for (List<String> a : peopleName) {
            System.out.println(a.get(0));
        }
    }
}