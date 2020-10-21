package leetcode.buildorder;

public class Son extends Father {
    {
        System.out.println(count);
    }

    static {
        System.out.println("2");
    }

    public static int count = 6;

    Son() {
        System.out.println(count);
    }

    static {
        System.out.println("3");
    }

    public static void main(String[] args) {
        System.out.println("5");
        Son a = new Son();
    }
}
