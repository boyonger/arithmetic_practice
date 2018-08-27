package writtenExam.youdao;

import java.io.*;

public class TextSql {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\method2in802.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String str;
        int sum=0;
        StringBuffer sb=new StringBuffer("( ");
        while ((str=br.readLine())!=null){
            str=str.replace(" ","");
            sum++;
            boolean flag=false;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)=='|'){
                    if (flag==false){
                        flag=true;
                    }
                    else {
                        sb.append(",");
                    }
                }else {
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println(sb);
        System.out.println(sum);
    }
}
