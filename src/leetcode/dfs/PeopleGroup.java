package leetcode.dfs;

import java.io.IOException;

/*
示例 1:
输入:
OKKKO
OKKKO
OKKKO
OKKOO
输出: 1
示例 2:
输入:
KKOOO
KOOOO
OKOKO
KOOOO
输出: 4
 */
public class PeopleGroup {

    public int judgeIntGroup(int[][] group) {
        // 深度遍历
        int[][] visit = new int[group.length][group[0].length];
        for (int i = 0; i < visit.length; i++) {
            for (int j = 0; j < visit[0].length; j++) {
                visit[i][j] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < group[0].length; j++) {
                if (group[i][j] == 1 && visit[i][j] == 0) {
                    dfs(i, j, group, visit);
                    count++;
                }
            }
        }
        return count;
    }

    public int judgeGroup(String[][] groupString) {
        int[][] group = changeEnglishToNumber(groupString);
        return judgeIntGroup(group);
    }

    public void dfs(int i, int j, int[][] group, int[][] visit) {
        // 第一次传进来的一定为1 must be people
        if (i < 0 || i >= group.length || j < 0 || j >= group[0].length) {
            return;
        }
        if (visit[i][j] == 1) {
            return;
        }
        // 如果为人群 继续遍历
        if (group[i][j] == 1) {
            visit[i][j] = 1;
            dfs(i + 1, j, group, visit);
            dfs(i, j + 1, group, visit);
        }
    }

    public int[][] changeEnglishToNumber(String[][] group) {
        // 将字母换成数字 1代表有人 0代表无人
        int[][] numberGroup = new int[group.length][group[0].length];
        for (int i = 0; i < numberGroup.length; i++) {
            for (int j = 0; j < numberGroup[0].length; j++) {
                if (group[i][j].equals("O")) {
                    numberGroup[i][j] = 0;
                } else {
                    numberGroup[i][j] = 1;
                }
            }
        }
        return numberGroup;
    }

    public static void main(String[] args) throws IOException {
        String[] a = new String[]{"OKKKO", "OKKKO", "OKKKO", "OKKOO"};
        String[][] group = new String[a.length][a[0].length()];
        int[][] intGroup = new int[][]{{0, 1, 1, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 1, 1, 0}};
        int[][] intGroup2 = new int[][]{{1, 0, 0, 0, 0, 0}, {1, 0, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 1}, {0, 0, 1, 1, 1, 0}, {0, 0, 0, 0, 1, 1}};
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                group[i][j] = a[i].charAt(j) + "";
            }
        }
        //int c = new PeopleGroup().judgeGroup(group);
        int c = new PeopleGroup().judgeIntGroup(intGroup2);
        System.out.println(c);
    }

}









