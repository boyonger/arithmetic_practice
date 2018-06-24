package greed;

import java.io.IOException;

/**
 * 从小明家所在公交站出发有n路公交到公司，现给出每路公交的停站数(不包括起点和终点)，及每次停的时间(一路车在每个站停的时间相同)和发车的间隔，
 * 先假定每辆车同时在相对时间0分开始发车，且所有车在相邻两个站之间的耗时相同,都为5分钟。给定小明起床的相对时间(相对0的分钟数)，请计算他最早
 * 到达公司的相对时间。给定每路车的停站数stops,停站时间period,发车间隔interval及公交路数n，出发时间s。请返回最早到达时间。保证公交路数小于等
 * 于500，停站数小于等于50。
 */
public class ChooseBus {
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        // write code here
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int missTime = s % interval[i];  //发车最多等interval[i]，当小于1轮时，是interval[i]-s，当大于1轮时，用interval[i]-s%interval[i]
            int waitCost = missTime == 0 ? 0 : interval[i] - missTime;
            min = Math.min(min, waitCost + (stops[i] + 1) * 5 + stops[i] * period[i]);
        }
        return min + s;
    }


}
