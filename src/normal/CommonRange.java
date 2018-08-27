package normal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//输出交集
public class CommonRange {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> X = new HashMap<>();
        Map<Integer, Integer> Y = new HashMap<>();
        Map<Integer, Integer> common = new HashMap<>();
        X.put(5, 10);
        X.put(20, 30);
        Y.put(20, 25);

        for (Map.Entry<Integer, Integer> value1 : Y.entrySet()) {
            for (Map.Entry<Integer, Integer> value2 : X.entrySet()) {
                if (value1.getKey() > value2.getValue()) {
                    break;
                } else if (value1.getKey() >= value2.getKey() && value1.getKey() <= value2.getValue()) {
                    if (value1.getValue() >= value2.getValue()) {
                        common.put(value1.getKey(), value2.getValue());
                    } else {
                        common.put(value1.getKey(), value1.getValue());
                    }
                } else if (value2.getKey() >= value1.getKey() && value2.getKey() <= value1.getValue()) {
                    if (value2.getValue() >= value1.getValue()) {
                        common.put(value2.getKey(), value1.getValue());
                    } else {
                        common.put(value2.getKey(), value2.getValue());
                    }
                }
            }
        }

        System.out.println(common);
    }
}
