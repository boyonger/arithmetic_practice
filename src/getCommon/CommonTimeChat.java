package getCommon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CommonTimeChat {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] data = str.split(" ");
            int p = Integer.parseInt(data[0]);
            int q = Integer.parseInt(data[1]);
            int l = Integer.parseInt(data[2]);
            int r = Integer.parseInt(data[3]);
            int[][] aSpareTime = new int[p][2];
            int[][] bSpareTime = new int[q][2];
            Set<Integer> numberSet = new HashSet<>();
            int sum = 0;
            for (int i = 0; i < p && (str = bf.readLine()) != null; i++) {
                String[] aSpareData = str.split(" ");
                aSpareTime[i][0] = Integer.parseInt(aSpareData[0]);
                aSpareTime[i][1] = Integer.parseInt(aSpareData[1]);
            }
            for (int i = 0; i < q && (str = bf.readLine()) != null; i++) {
                String[] bSpareData = str.split(" ");
                int bSpareBegin = Integer.parseInt(bSpareData[0]);
                int bSpareEnd = Integer.parseInt(bSpareData[1]);
                int beginTimeCommon = 0;
                int endTimeCommon = 0;
                int commonTime = 0;
                for (int j = 0; j < p; j++) {
                    int beginMinUpTime = aSpareTime[j][0] - bSpareBegin;
                    int beginMaxUpTime = aSpareTime[j][1] - bSpareBegin;
                    if (beginMinUpTime < l) {
                        beginMinUpTime = l;
                    }
                    if (beginMaxUpTime > r) {
                        beginMaxUpTime = r;
                    }
                    if (beginMaxUpTime > beginMinUpTime) {
                        for (int t = beginMinUpTime; t <= beginMaxUpTime; t++) {
                            numberSet.add(t);
                        }
                    }
                    int endMinUpTime = aSpareTime[j][0] - bSpareEnd;
                    int endMaxUpTime = aSpareTime[j][1] - bSpareEnd;
                    if (endMinUpTime < l) {
                        endMinUpTime = l;
                    }
                    if (endMaxUpTime > r) {
                        endMaxUpTime = r;
                    }
                    if (endMaxUpTime > endMinUpTime) {
                        for (int t = endMinUpTime; t <= endMaxUpTime; t++) {
                            numberSet.add(t);
                        }
                    }
                    if (beginTimeCommon > 0) {
                        sum += beginTimeCommon;
                    }
                    if (endTimeCommon > 0) {
                        sum += endTimeCommon;
                    }
                }
            }
            System.out.println(numberSet.size());
        }
    }
}


    /*if (aSpareTime[j][0] - bSpareBegin > l) {
        beginTimeCommon = aSpareTime[j][0];
    } else {
        beginTimeCommon = bSpareBegin + l;
    }
    if (aSpareTime[j][1] - bSpareEnd < r) {
        endTimeCommon = aSpareTime[j][1];
    } else {
        endTimeCommon = bSpareEnd + r;
    }
    commonTime = endTimeCommon - beginTimeCommon + 1;
    if (commonTime > 0) {
        sum += commonTime;
    }*/
    //上面是算会有多少共同时间 算法不对 应该算有多少个满足有共同时间的交集
