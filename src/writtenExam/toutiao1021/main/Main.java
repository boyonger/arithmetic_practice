package writtenExam.toutiao1021.main;
/*
3
variable
oneVariable
OneHTTPRequest
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String words = br.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            /*if (words.charAt(0) > 64 && words.charAt(0) < 91) {
                char c = (char) (words.charAt(0) + 32);
                stringBuilder.append(c);
            } else {
                stringBuilder.append(words.charAt(0));
            }*/
            for (int j = 0; j < words.length(); j++) {
                Character oneSpell = words.charAt(j);
                if (oneSpell > 64 && oneSpell < 91) {
                    if (j == 0) {
                        stringBuilder.append((char) (oneSpell + 32));
                    } else {
                        stringBuilder.append("_").append((char) (oneSpell + 32));
                    }
                    j++;
                    for (; j < words.length() && words.charAt(j) > 64 && words.charAt(j) < 91; j++) {
                        if (j + 1 < words.length() - 1) {
                            if (words.charAt(j + 1) > 96 && words.charAt(j + 1) < 127) {
                                stringBuilder.append("_").append((char) (words.charAt(j) + 32));
                            } else {
                                stringBuilder.append((char) (words.charAt(j) + 32));
                            }
                        } else {
                            stringBuilder.append((char) (words.charAt(j) + 32));
                        }
                    }
                    j--;
                } else {
                    stringBuilder.append(words.charAt(j));
                }
            }
            list.add(stringBuilder.toString());
        }
        for (String a : list) {
            System.out.println(a);
        }
    }
}
