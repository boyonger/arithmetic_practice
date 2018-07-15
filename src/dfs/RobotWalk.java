package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
机器人从起点移动到终点所需要的最短秒数，当不可达时输出65535
 */
class Robot {
    public int map[][];
    public int[] start;
    public int[] end;
    public int[] position;
    public int time;
    public List<Integer> timeList;

    public Robot(int map[][], int[] start, int[] end) {
        this.map = map;
        this.start = start;
        this.end = end;
        this.position = new int[3];
        timeList = new ArrayList<>();
    }

    public void step() {
    /*数字表示：0：东  1：南  2：西  3：北*/
        if (position[2] == 0) {
            position[1]++;
        } else if (position[2] == 1) {
            position[0]++;
        } else if (position[2] == 2) {
            position[1]--;
        } else if (position[2] == 3) {
            position[0]--;
        }
    }

    //转0到3次 0->3 顺时针+ 逆时针-
    public void turn(int number) {
        switch (number){
            case 0:break;
            case 1:
                if (position[2]==3){
                    position[2]=0;
                    time++;
                }else {
                    position[2]++;
                    time++;
                }
                break;
            case 2:
                switch (position[2]){
                    case 1:
                        position[2]=3;
                        break;
                    case 2:
                        position[2]=0;
                        break;
                    case 3:
                        position[2]=1;
                        break;
                    case 0:
                        position[2]=2;
                        break;
                }
                time=time+2;
                break;
            case 3:
                if (position[2]==0){
                    position[2]=3;
                    time++;
                }else {
                    position[2]--;
                    time++;
                }
                break;
            default:break;
        }
    }

    public void dfs(int[][] repertory){
        for (int i=0;i<repertory.length;i++){
            for (int j=0;j<repertory[0].length;j++){
                for (int t=0;t<4;t++){
                    this.turn(t);
                    this.step();
                    if (position[0]==end[0]&&position[1]==end[1]){
                        timeList.add(time);
                        time=0;
                    }
                }
            }
        }
    }
}

public class RobotWalk {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(" ");
        String[] end = br.readLine().split(" ");
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
