package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
在自动化仓库中有若干障碍物，机器人需要从起点出发绕过这些障碍物到终点搬取货柜，现试求机器人从起点运动到终点用时最短的路径。
已知机器人只能沿着东西方向或南北方向移动，移动的速度为1m/s，机器人每转向90度需要花费1s。
 输入：
第一行：起点位置坐标及机器人朝向，如：
1 0 EAST
代表机器人初始坐标为x=1,y=0，机器人面朝东方
第二行：终点位置坐标及机器人朝向，如：
0 2 WEST
代表机器人需要移动至点x=0,y=2，且面朝西方
接下来输入的是地图：
首先是两个数字r,c，代表有地图数据有多少行与多少列，如：
2 3
0 1 0
0 0 0
其中，左上角为坐标原点，从左向右为x轴增大的方向是东方，从上到下为y轴增大的方向是南方。
地图中1代表有障碍物，机器人不能前往，0代表无障碍物机器人可以前往 地图中相邻的每两个点之间的距离为1m。
0 <= l,w <= 128
输出：
12
机器人从起点移动到终点所需要的最短秒数，当不可达时输出65535
1 0 EAST
0 2 WEST
2 3
0 1 0
0 0 0
 */
class Robot {
    public int map[][];
    public int visited[][];
    public int[] start;
    public int[] end;
    public int[] position; //从左至右分别为row,col,turn,time
    public List<Integer> timeList;

    public Robot(int map[][], int[] start, int[] end) {
        this.map = map;
        this.start = start;
        this.end = end;
        this.visited=new int[map.length][map[0].length];
        this.position = new int[4];
        position[0] = start[0];
        position[1] = start[1];
        position[2] = start[2];
        position[3] = 0;
        timeList = new ArrayList<>();
        timeList.add(65535);
    }

    //0不走1走
    public int[] step(int number, int[] positionOriginal) {
    /*数字表示：0：东  1：南  2：西  3：北*/
        int[] position = {positionOriginal[0], positionOriginal[1], positionOriginal[2], positionOriginal[3]};
        if (number == 1) {
            if (position[2] == 0) {
                position[1]++;
            } else if (position[2] == 1) {
                position[0]++;
            } else if (position[2] == 2) {
                position[1]--;
            } else if (position[2] == 3) {
                position[0]--;
            }
            position[3]++;
        }
        return position;
    }

    //转0到3次 0->3 顺时针+ 逆时针-
    public int[] turn(int number, int[] positionOriginal) {
        int position[] = {positionOriginal[0], positionOriginal[1], positionOriginal[2], positionOriginal[3]};
        switch (number) {
            case 0:
                break;
            case 1:
                if (position[2] == 3) {
                    position[2] = 0;
                    position[3]++;
                } else {
                    position[2]++;
                    position[3]++;
                }
                break;
            case 2:
                switch (position[2]) {
                    case 1:
                        position[2] = 3;
                        break;
                    case 2:
                        position[2] = 0;
                        break;
                    case 3:
                        position[2] = 1;
                        break;
                    case 0:
                        position[2] = 2;
                        break;
                }
                position[3] = position[3] + 2;
                break;
            case 3:
                if (position[2] == 0) {
                    position[2] = 3;
                    position[3]++;
                } else {
                    position[2]--;
                    position[3]++;
                }
                break;
            default:
                break;
        }
        return position;
    }

    //0没访问 1障碍或者访问过
    public void dfs(int[][] repertory, int[] position) {
        this.visited[position[0]][position[1]] = 1;
        for (int t = 0; t < 4; t++) {
            for (int k = 0; k < 2; k++) {
                int[] positionTemporary = this.step(k, this.turn(t, position));
                if (positionTemporary[0] == end[0] && positionTemporary[1] == end[1] && positionTemporary[2] == end[2]
                        && repertory[positionTemporary[0]][positionTemporary[1]] == 0) {
                    timeList.add(position[3]);
                } else if (positionTemporary[0] > -1 && positionTemporary[0] < repertory.length
                        && positionTemporary[1] > -1 && positionTemporary[1] < repertory[0].length  //确保不出界
                        && this.visited[positionTemporary[0]][positionTemporary[1]] == 0) {         //确保未访问过
                    dfs(repertory, positionTemporary);
                }
            }
        }
    }
}

public class RobotWalk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startString = br.readLine().split(" ");
        String[] endString = br.readLine().split(" ");
        String[] rc = br.readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        int[][] repertory = new int[r][c];
        for (int i = 0; i < repertory.length; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                repertory[i][j] = Integer.parseInt(data[j]);
            }
        }
        int[] start = {Integer.parseInt(startString[0]), Integer.parseInt(startString[1]), change(startString[2])};
        int[] end = {Integer.parseInt(endString[0]), Integer.parseInt(endString[1]), change(endString[2])};
        Robot robot = new Robot(repertory, start, end);
        robot.dfs(repertory, robot.position);
        System.out.println(Collections.min(robot.timeList));
    }

    /*
      数字表示：
      0：东
      1：南
      2：西
      3：北
      */
    public static int change(String a) {
        if (a.equals("EAST"))
            return 0;
        else if (a.equals("SOUTH"))
            return 1;
        else if (a.equals("WEST"))
            return 2;
        else if (a.equals("NORTH"))
            return 3;
        else return 4;
    }
}
