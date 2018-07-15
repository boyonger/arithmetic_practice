package huyaTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, String> protectKey = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        protectKey.put("1", "2");
        protectKey.put("2", "4");
        protectKey.put("3", "1");
        protectKey.put("4", "5");
        protectKey.put("5", "3");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        String[] getInt = inputString.split(",");
        for (int i = 0; i < getInt.length; i++) {
            stringBuffer.append(protectKey.get(getInt[i])+",");
        }
        String outPut=stringBuffer.toString().substring(0, stringBuffer.length()-1);
        System.out.println(outPut);
        input.close();
    }
}
