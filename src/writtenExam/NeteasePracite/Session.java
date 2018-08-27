package writtenExam.NeteasePracite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Session {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number; i++) { //组数
            int countIn = Integer.parseInt(br.readLine());
            List<Integer> sessionList = new ArrayList<>();
            String[] data = br.readLine().split(" ");
            for (String a : data) {
                Integer b = Integer.parseInt(a);
                boolean flag = false;
                for (int j = 0; j < sessionList.size(); j++) {
                    if (sessionList.get(j).equals(b)) {
                        sessionList.remove(j);
                        sessionList.add(0, b);
                        flag = true;
                    }
                }
                if (flag == false) {
                    sessionList.add(0, b);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Integer numberInSession : sessionList) {
                stringBuffer.append(numberInSession).append(" ");
            }
            list.add(stringBuffer.substring(0, stringBuffer.length() - 1));
        }
        for (String a : list) {
            System.out.println(a);
        }
    }
}
