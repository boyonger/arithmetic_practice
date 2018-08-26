package wangyigame.tax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int pay = Integer.parseInt(br.readLine().trim());
            long tax = 0;
            if (pay > 5000) {
                int needTax = pay - 5000;
                if (needTax <= 3000) {
                    tax += Math.round(needTax * 0.03);
                } else {
                    tax += Math.round(3000 * 0.03);
                    needTax=needTax-3000;
                    if (needTax<=12000-3000){
                        tax += Math.round(needTax * 0.1);
                    }else{
                        tax += Math.round((12000-3000) * 0.1);
                        needTax=needTax-(12000-3000);
                        if (needTax<=25000-12000){
                            tax+=Math.round(needTax * 0.2);
                        }else{
                            tax+=Math.round((25000-12000) * 0.2);
                            needTax=needTax-(25000-12000);
                            if (needTax<=35000-25000){
                                tax+=Math.round(needTax * 0.25);
                            }else{
                                tax+=Math.round((35000-25000) * 0.25);
                                needTax=needTax-(35000-25000);
                                if (needTax<=55000-35000){
                                    tax+=Math.round(needTax * 0.3);
                                }else{
                                    tax+=Math.round((55000-35000) * 0.3);
                                    needTax=needTax-(55000-35000);
                                    if(needTax<=80000-55000){
                                        tax+=Math.round(needTax * 0.35);
                                    }else{
                                        tax+=Math.round((80000-55000) * 0.35);
                                        needTax=needTax-(80000-55000);
                                        tax+=Math.round((needTax * 0.45));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            list.add(tax);
        }
        for (Long a : list) {
            System.out.println(a);
        }
    }
}
