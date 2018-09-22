package writtenExam.shunfen.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
6789  11s9 2m22 240cm 10.5M
8901  12s 9.7M 2m18 260cm
0002  2m22 10M 258cm 11s5
5678  11.1M 266cm 2m10 12s3
7890  12s4 10.2M 270cm 2m08
end
样例输出
NO.	100M	800M	JUMP	BALL
6789	GREAT	GOOD	FAIL	GREAT
0002	GREAT	GOOD	GOOD	GOOD
8901	GREAT	GOOD	GOOD	GOOD
5678	GOOD	GREAT	GREAT	GREAT
7890	GOOD	GREAT	GREAT	GOOD
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0:100m  1:800m 2:jump 3:ball
        Map<Integer, Map<Integer, String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        String str = null;
        while (!(str = br.readLine()).equals("end")) {
            String[] data = str.split(" |  ");
            Map<Integer, String> mapIn = new HashMap<>();
            List<String> smallList = new ArrayList<>();
            smallList.add(data[0]);
            for (int i = 1; i < data.length; i++) {
                if (data[i].equals("") || data[i].equals(" ")) {
                    continue;
                }
                if (data[i].matches(".*s.*")) {
                    String a = data[i];
                    double b = Double.parseDouble(a.replace("s", "."));
                    if (b <= 12) {
                        smallList.add("GREAT");
                    }
                    if (b >= 12.1 && b <= 12.4) {
                        smallList.add("GOOD");
                    }
                    if (b >= 12.5 && b <= 12.9) {
                        smallList.add("PASS");
                    }
                    if (b >= 13) {
                        smallList.add("FAIL");
                    }
                } else if (data[i].matches(".*cm.*")) {
                    String a = data[i];
                    Double b = Double.parseDouble(a.replace("cm", ""));
                    if (b >= 266) {
                        smallList.add("GREAT");
                    }
                    if (b >= 256 && b <= 265) {
                        smallList.add("GOOD");
                    }
                    if (b >= 246 && b <= 255) {
                        smallList.add("PASS");
                    }
                    if (b <= 245) {
                        smallList.add("FAIL");
                    }
                } else if (data[i].matches(".*m.*")) {
                    String a = data[i];
                    Double b = Double.parseDouble(a.replace("m", "."));
                    if (b <= 2.15) {
                        smallList.add("GREAT");
                    }
                    if (b >= 2.16 && b <= 2.24) {
                        smallList.add("GOOD");
                    }
                    if (b >= 2.25 && b <= 2.31) {
                        smallList.add("PASS");
                    }
                    if (b >= 2.32) {
                        smallList.add("FAIL");
                    }
                } else if (data[i].matches(".*M.*")) {
                    String a = data[i];
                    Double b = Double.parseDouble(a.replace("M", ""));
                    if (b >= 10.4) {
                        smallList.add("GREAT");
                    }
                    if (b >= 9.6 && b <= 10.3) {
                        smallList.add("GOOD");
                    }
                    if (b >= 8.7 && b <= 9.5) {
                        smallList.add("PASS");
                    }
                    if (b <= 8.6) {
                        smallList.add("FAIL");
                    }
                } else {
                    smallList.add("ERROR");
                    break;
                }
            }
            lists.add(smallList);
        }
        Collections.sort(lists, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int sumGreat1 = 0, sumGood1 = 0, sumPass1 = 0, sumFail1 = 0;
                int sumGreat2 = 0, sumGood2 = 0, sumPass2 = 0, sumFail2 = 0;
                for (String a : o1) {
                    if (a.equals("GREAT")) sumGreat1++;
                    if (a.equals("GOOD")) sumGood1++;
                    if (a.equals("PASS")) sumPass1++;
                    if (a.equals("FAIL")) sumFail1++;
                }
                int i = 0;
                while (i < o2.size()) {
                    String b = o2.get(i);
                    if (b.equals("GREAT")) sumGreat2++;
                    if (b.equals("GOOD")) sumGood2++;
                    if (b.equals("PASS")) sumPass2++;
                    if (b.equals("FAIL")) sumFail2++;
                    i++;
                }
                if (sumGreat1 > sumGreat2) return 1;
                else if (sumGreat2 > sumGreat1) return -1;
                else if (sumGood1 > sumGood2) return 1;
                else if (sumGood1 < sumGood2) return -1;
                else if (sumPass1 > sumPass2) return 1;
                else if (sumPass1 < sumPass2) return -1;
                else if (Integer.parseInt(o1.get(0)) < Integer.parseInt(o2.get(0)))
                    return 1;
                else {
                    return -1;
                }
            }
        });
        System.out.println("NO.	100M	800M	JUMP	BALL");
        for (List<String> c : lists) {
            for (String d : c) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
