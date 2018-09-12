package javaBase;

import java.io.IOException;

class Fruit {
    public int a;
    public void method1(){
        System.out.println("fruit method");
    }
}
class Apple extends Fruit {
    public int a=20;
    public void method1(){
        System.out.println("apple method");
    }
}
class Orange extends Fruit {

}
class RedApple extends Apple{

}
public class ExtendTest {
    public static void main(String[] args) throws IOException {
        Fruit[] fruits=new Apple[10];
        try {
            fruits[0]=new Apple();
            System.out.println("apple ok");
        }catch (Exception e){
            System.out.println("apple wrong");
        }
        try {
            fruits[0]=new Orange();
            System.out.println("orange ok");
        }catch (Exception e){
            System.out.println("orange wrong");
        }
        try {
            fruits[0]=new Fruit();
            System.out.println("fruit ok");
        }catch (Exception e){
            System.out.println("fruit wrong");
        }
        fruits[0].method1();
        System.out.println(fruits[0].a);
    }
}
