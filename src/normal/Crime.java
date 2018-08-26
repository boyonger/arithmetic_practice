package normal;

/*
        C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，
        市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？
        输入描述:
        第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
        输出描述:
        一行输出答案。
*/
import java.util.Scanner;

public class Crime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int c = scanner.nextInt();
            int[] crimeValue = new int[n];
            for (int i = 0; i < n; i++) {
                crimeValue[i] = scanner.nextInt();
            }
            int sum = 0;
            int allCur = 0;
            for (int i = 0; i < crimeValue.length + 1 - c; i++) {
                for (int j = i; j < i + c; j++) {
                    sum += crimeValue[j];
                }
                if (sum <= t)
                    allCur++;
                sum = 0;
            }
            System.out.println(allCur);
        }
    }
}

