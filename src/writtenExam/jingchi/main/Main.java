package writtenExam.jingchi.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            int[] number1 = new int[5];
            int[] number2 = new int[5];
            Map<Integer, Integer> pokerMap1 = new HashMap<>();
            Map<Integer, Integer> pokerMap2 = new HashMap<>();
            for (int j = 0; j < data.length; j++) {
                number1[j] = Integer.parseInt(data[j]);
            }
            data = br.readLine().split(" ");
            for (int j = 0; j < data.length; j++) {
                number2[j] = Integer.parseInt(data[j]);
            }
            int n1 = judge(number1, pokerMap1);
            int n2 = judge(number2, pokerMap2);
            if (n1 < n2) {
                list.add(1);
            } else if (n2 < n1) {
                list.add(2);
            } else {
                list.add(equalNumber(number1, number2, n1, pokerMap1, pokerMap2));
            }
        }
        for (int a : list) {
            System.out.println(a);
        }
    }

    //  1：4条 2：葫芦 3：顺子 4：三条 5：两对 6：一对 7：散牌
    public static int judge(int[] poker, Map<Integer, Integer> pokerMap) {
        for (int i = 0; i < poker.length; i++) {
            if (!pokerMap.containsKey(poker[i])) {
                pokerMap.put(poker[i], 1);
            } else {
                pokerMap.put(poker[i], pokerMap.get(poker[i]) + 1);
            }
        }
        if (pokerMap.size() == 2 && pokerMap.containsValue(4) && pokerMap.containsValue(1)) {
            return 1;
        }
        if (pokerMap.size() == 2 && pokerMap.containsValue(3) && pokerMap.containsValue(2)) {
            return 2;
        } else if (pokerMap.size() == 5) {
            List<Integer> sortList = new ArrayList<>();
            for (int i = 0; i < poker.length; i++) {
                sortList.add(poker[i]);
            }
            Collections.sort(sortList);
            boolean flag = true;
            for (int i = 1; i < sortList.size(); i++) {
                if (sortList.get(i) - sortList.get(i - 1) != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return 3;
            } else {
                if (sortList.contains(14)) {
                    sortList.remove((Integer) 14);
                    sortList.add(1);
                    Collections.sort(sortList);
                    flag = true;
                    for (int i = 1; i < sortList.size(); i++) {
                        if (sortList.get(i) - sortList.get(i - 1) != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return 3;
                    }
                }
            }
        } else if (pokerMap.size() == 3 && pokerMap.containsValue(3) && pokerMap.containsValue(1)) {
            return 4;
        } else if (pokerMap.size() == 3 && pokerMap.containsValue(2) && pokerMap.containsValue(1)) {
            return 5;
        } else if (pokerMap.size() == 4 && pokerMap.containsValue(2)) {
            return 6;
        }
        return 7;
    }

    //  1：4条 2：葫芦 3：顺子 4：三条 5：两对 6：一对 7：散牌
    public static int equalNumber(int[] n1, int[] n2, int number, Map<Integer, Integer> pokerMap1, Map<Integer, Integer> pokerMap2) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        switch (number) {
            case 1:
                for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                    if (a.getValue() == 4) {
                        c1 = a.getKey();
                    }
                }
                for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                    if (a.getValue() == 4) {
                        c2 = a.getKey();
                    }
                }
                if (c1 > c2) return 1;
                else if (c2 > c1) return 2;
                else {
                    for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                        if (a.getValue() == 1) {
                            c3 = a.getKey();
                        }
                    }
                    for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                        if (a.getValue() == 1) {
                            c4 = a.getKey();
                        }
                    }
                    if (c3 > c4) return 1;
                    else if (c4 > c3) return 2;
                }
                return 0;

            case 2:
                for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                    if (a.getValue() == 3) {
                        c1 = a.getKey();
                    }
                }
                for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                    if (a.getValue() == 3) {
                        c2 = a.getKey();
                    }
                }
                if (c1 > c2) return 1;
                else if (c2 > c1) return 2;
                else {
                    for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                        if (a.getValue() == 2) {
                            c3 = a.getKey();
                        }
                    }
                    for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                        if (a.getValue() == 2) {
                            c4 = a.getKey();
                        }
                    }
                    if (c3 > c4) return 1;
                    else if (c4 > c3) return 2;
                }
                return 0;
            case 3:
                List<Integer> sort1 = new ArrayList<>();
                List<Integer> sort2 = new ArrayList<>();
                for (int i = 0; i < n1.length; i++) {
                    sort1.add(n1[i]);
                }
                for (int i = 0; i < n2.length; i++) {
                    sort2.add(n2[i]);
                }
                Collections.sort(sort1);
                Collections.sort(sort2);
                boolean flag = true;
                for (int i = 1; i < sort1.size(); i++) {
                    if (sort1.get(i) - sort1.get(i - 1) != 1) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    if (sort1.contains(14)) {
                        sort1.remove((Integer) 14);
                        sort1.add(1);
                        Collections.sort(sort1);
                    }
                }
                flag = true;
                for (int i = 1; i < sort2.size(); i++) {
                    if (sort2.get(i) - sort2.get(i - 1) != 1) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    if (sort2.contains(14)) {
                        sort2.remove((Integer) 14);
                        sort2.add(1);
                        Collections.sort(sort2);
                    }
                }
                while (true) {
                    if (sort1.size() == 1) {
                        if (Collections.max(sort1) > Collections.max(sort2)) {
                            return 1;
                        } else if (Collections.max(sort1) > Collections.max(sort2)) {
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                    if (Collections.max(sort1) > Collections.max(sort2)) {
                        return 1;
                    } else if (Collections.max(sort1) > Collections.max(sort2)) {
                        return 2;
                    }
                    sort1.remove(Collections.max(sort1));
                    sort2.remove(Collections.max(sort2));
                }
            case 4:
                for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                    if (a.getValue() == 3) {
                        c1 = a.getKey();
                    }
                }
                for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                    if (a.getValue() == 3) {
                        c2 = a.getKey();
                    }
                }
                if (c1 > c2) return 1;
                else if (c2 > c1) return 2;
                else {
                    List<Integer> l1 = new ArrayList<>();
                    List<Integer> l2 = new ArrayList<>();
                    for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                        if (a.getValue() == 1) {
                            l1.add(a.getKey());
                        }
                    }
                    for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                        if (a.getValue() == 1) {
                            l2.add(a.getKey());
                        }
                    }
                    if (Collections.max(l1) > Collections.max(l2)) return 1;
                    else if (Collections.max(l1) < Collections.max(l2)) return 2;
                    else {
                        l1.remove(Collections.max(l1));
                        l2.remove(Collections.max(l2));
                        if (Collections.max(l1) > Collections.max(l2)) return 1;
                        else if (Collections.max(l1) < Collections.max(l2)) return 2;
                        else return 0;
                    }
                }
            case 5:
                List<Integer> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                    if (a.getValue() == 2) {
                        l1.add(a.getKey());
                    }
                }
                for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                    if (a.getValue() == 2) {
                        l2.add(a.getKey());
                    }
                }
                if (Collections.max(l1) > Collections.max(l2)) return 1;
                else if (Collections.max(l1) < Collections.max(l2)) return 2;
                else {
                    l1.remove(Collections.max(l1));
                    l2.remove(Collections.max(l2));
                    if (Collections.max(l1) > Collections.max(l2)) return 1;
                    else if (Collections.max(l1) < Collections.max(l2)) return 2;
                    else {
                        for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                            if (a.getValue() == 1) {
                                c1 = a.getKey();
                            }
                        }
                        for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                            if (a.getValue() == 1) {
                                c2 = a.getKey();
                            }
                        }
                        if (c1 > c2) return 1;
                        else if (c2 > c1) return 2;
                        else {
                            return 0;
                        }
                    }
                }
            case 6:
                List<Integer> l3 = new ArrayList<>();
                List<Integer> l4 = new ArrayList<>();
                for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                    if (a.getValue() == 2) {
                        c1 = a.getKey();
                    }
                }
                for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                    if (a.getValue() == 2) {
                        c2 = a.getKey();
                    }
                }
                if (c1 > c2) return 1;
                else if (c2 > c1) return 2;
                else {
                    for (Map.Entry<Integer, Integer> a : pokerMap1.entrySet()) {
                        if (a.getValue() == 1) {
                            l3.add(a.getKey());
                        }
                    }
                    for (Map.Entry<Integer, Integer> a : pokerMap2.entrySet()) {
                        if (a.getValue() == 1) {
                            l4.add(a.getKey());
                        }
                    }
                    while (true) {
                        if (l3.size() == 1) {
                            if (Collections.max(l3) > Collections.max(l4)) {
                                return 1;
                            } else if (Collections.max(l4) > Collections.max(l3)) {
                                return 2;
                            } else {
                                return 0;
                            }
                        }
                        if (Collections.max(l3) > Collections.max(l4)) {
                            return 1;
                        } else if (Collections.max(l4) > Collections.max(l3)) {
                            return 2;
                        }
                        l3.remove(Collections.max(l3));
                        l4.remove(Collections.max(l4));
                    }
                }
            case 7:
                List<Integer> l5 = new ArrayList<>();
                List<Integer> l6 = new ArrayList<>();
                for (int i = 0; i < n1.length; i++) {
                    l5.add(n1[i]);
                }
                for (int i = 0; i < n2.length; i++) {
                    l6.add(n2[i]);
                }
                while (true) {
                    if (l5.size() == 1) {
                        if (Collections.max(l5) > Collections.max(l6)) {
                            return 1;
                        } else if (Collections.max(l6) > Collections.max(l5)) {
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                    if (Collections.max(l5) > Collections.max(l6)) {
                        return 1;
                    } else if (Collections.max(l6) > Collections.max(l5)) {
                        return 2;
                    }
                    l5.remove(Collections.max(l5));
                    l6.remove(Collections.max(l6));
                }
        }
        return 0;
    }
}
