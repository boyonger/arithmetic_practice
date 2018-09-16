package writtenExam.huyaTest;

import java.util.*;

public class Main2 {
    //“中国”、“直播”、“游戏”、“游戏直播”、“综艺娱乐”、“互动直播平台”
    public static void main(String[] args) {
        Set<String> wordSet = new HashSet<>();
        Set<String> outPutSet = new TreeSet<>();
        List<String> outList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        wordSet.add("中国");
        wordSet.add("直播");
        wordSet.add("游戏");
        wordSet.add("游戏直播");
        wordSet.add("综艺娱乐");
        wordSet.add("互动直播平台");

        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i + 5; j >= i; j--) {
                while (j >= inputString.length()) {
                    j = j - 1;
                }
                String company = inputString.substring(i, j + 1);
                if (wordSet.contains(company)) {
                    //outPutSet.changeTo(company);
                        outList.add(company);
                    i = i + company.length() - 1;
                    break;
                }
            }
        }
        Iterator iterator = outList.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next() + ",");
        }
        String outPutString = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
        System.out.println(outPutString);
        input.close();
    }
}
