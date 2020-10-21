package leetcode.buildorder;

public class Father {

    public static int width = 100;

    public static int count;

    {
        System.out.println(count);
    }

    static {
        System.out.println(count);
    }

    Father() {
        System.out.println("1");
    }
}
