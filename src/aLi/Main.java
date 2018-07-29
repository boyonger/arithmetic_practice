package aLi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。
假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 */
class CarRoad {
    public int map[][];
    public int visited[][];
    public int[] position; //从左至右分别为row,col,time,记录所有2的点的次数
    public List<Integer> timeList;

    public CarRoad(int map[][], int number) {
        this.map = map;
        this.visited = new int[map.length][map[0].length];
        this.position = new int[4];
        position[3] = 0;
        position[4] = number;
        timeList = new ArrayList<>();
        timeList.add(65535);
    }

    public int[] step(int[] positionOriginal, int number) { //上 下 左 右
        int[] position = {positionOriginal[0], positionOriginal[1], positionOriginal[2],positionOriginal[3]};
        if (number == 0) {
            position[0]++;
        } else if (number == 1) {
            position[0]--;
        } else if (number == 2) {
            position[1]--;
        } else if (number == 3) {
            position[1]++;
        }
        position[2]++;
        return position;
    }


    //0没访问 1访问过 2表示那个点
    public void dfs(int[][] repertory, int[] position) {
        this.visited[position[0]][position[1]] = 1;
        for (int t = 0; t < 4; t++) {
            int[] positionTemporary = this.step(position, t);
            if (repertory[positionTemporary[0]][positionTemporary[1]] == 2) {
                positionTemporary[3]--;
                if (positionTemporary[3] <= 0) {
                    timeList.add(position[3]);
                }
            } else if (positionTemporary[0] > -1 && positionTemporary[0] < repertory.length
                    && positionTemporary[1] > -1 && positionTemporary[1] < repertory[0].length  //确保不出界
                    && this.visited[positionTemporary[0]][positionTemporary[1]] == 0) {         //确保未访问过
                dfs(repertory, positionTemporary);
            }
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine().trim());
        int[][] b = new int[a][2];
        int max = 0;
        for (int i = 0; i < a; i++) {
            String[] data = br.readLine().split(",");
            b[i][0] = Integer.parseInt(data[0]);
            if (b[i][0] > max) {
                max = b[i][0];
            }
            b[i][1] = Integer.parseInt(data[1]);
            if (b[i][1] > max) {
                max = b[i][1];
            }
        }
        int[][] map = new int[max][max];
        for (int i = 0; i < b.length; i++) {
            map[b[i][0]][b[i][1]] = 2;
        }
        CarRoad carRoad = new CarRoad(map, a);
        carRoad.dfs(map,carRoad.position);
        System.out.println(Collections.min(carRoad.timeList));
    }

}
