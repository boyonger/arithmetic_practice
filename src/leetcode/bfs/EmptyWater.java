package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/*
leetcode 365
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例 1: (From the famous "Die Hard" example)
输入: x = 3, y = 5, z = 4
输出: True
示例 2:
输入: x = 2, y = 6, z = 5
输出: False
 */
public class EmptyWater {

    public static class State {

        public int x;
        public int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || getClass() != this.getClass()) {
                return false;
            }
            if (obj instanceof State) {
                return this.x == ((State) obj).x && y == ((State) obj).y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean canMeasureWater_BFS(int x, int y, int z) {
        Set<State> set = new HashSet<>();
        Queue<State> queue = new ArrayDeque<>();
        State state = new State(0, 0);
        set.add(state);
        // begin
        queue.offer(state);
        while (!queue.isEmpty()) {
            State beginState = queue.poll();
            if (beginState.x == z || beginState.y == z || beginState.x + beginState.y == z) {
                return true;
            }
            int xState = beginState.x;
            int yState = beginState.y;
            // 尝试遍历所有可能倒水情况
            // 第一种：将x装满(只有x不满的情况有意义)
            if (xState < x) {
                addState(x, yState, set, queue);
            }
            // 将x倒空
            if (xState > 0) {
                addState(0, yState, set, queue);
            }
            if (yState < y) {
                addState(xState, y, set, queue);
            }
            if (yState > 0) {
                addState(xState, 0, set, queue);
            }
            // x倒入y的情况 分为x倒空和x未倒空（未倒空的时候y已经满了）
            // x倒空了
            if (xState > 0) {
                if (xState <= y - yState) {
                    addState(0, yState + xState, set, queue);
                }
                // x未倒空
                else {
                    addState(xState - (y - yState), y, set, queue);
                }
            }
            // y倒入x的情况
            if (yState > 0) {
                if (yState <= x - xState) {
                    addState(xState + yState, 0, set, queue);
                } else {
                    addState(x, yState - (x - xState), set, queue);
                }
            }
        }
        return false;
    }

    public void addState(int xState, int yState, Set<State> set, Queue<State> queue) {
        State state1 = new State(xState, yState);
        if (set.add(state1)) {
            queue.offer(state1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new EmptyWater().canMeasureWater_BFS(2, 6, 5));
    }

}
