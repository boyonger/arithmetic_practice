package javaBase;

import java.io.IOException;

final class AnotherTest {
    //public static final String a = new String("Final String");
    static {
        System.out.println("static block");
    }

    {
        System.out.println("not static block");
    }

    public AnotherTest() {
        System.out.println("construction block");
    }

    //public static final String a = "Final String";
    //public static final String a = new String("Final String");
}

public class StaticTest {

    static int i = 1;
    static {
        i = 0;
        System.out.println(i);//Error：Cannot reference a field before it is defined（非法向前应用）
    }


    public static void main(String[] args) throws IOException {
        //System.out.println(AnotherTest.a);  //类经过 加载、验证、准备、解析、初始化  （在初始化会执行static代码块，但是不执行构造方法，因为仍未实例化）
    }
}
