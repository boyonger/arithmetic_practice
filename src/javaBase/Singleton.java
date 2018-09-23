package javaBase;

class Student {
    private String name;
    private Long schoolId;

    public Student() {
        this.name = "yong";
        this.schoolId = 20152100188l;
    }
}
//懒汉 线程非安全
class Singleton1{
    private static Student student;
    private Singleton1(){

    }

    public static Student getInstance(){
        if (student==null){
            student=new Student();
        }
        return student;
    }
}

//线程安全
public class Singleton {
    private static volatile Student student;

    private Singleton() {

    }

    public Student getInstance() {
        if (student==null){
            synchronized (student){
                if (student==null){
                    student=new Student();
                }
            }
        }
        return student;
    }
}
//饿汉式
class Singleton3{
    private static final Student student=new Student();
    //使用类加载器加载，不会出现同步问题
    private Singleton3(){

    }
    public Student getInstance(){
        return student;
    }
}

//内部类饿汉式
class Singleton4{
    static class SingletonHolder{
        private static final Student student=new Student();  //非静态内部类不能使用非编译期生成的对象
    }

    private Singleton4(){

    }
    //加上final不能被重写
    public final Student  getInstance(){
        return SingletonHolder.student;
    }
}

//枚举
enum Singleton5{
    Student;
}

