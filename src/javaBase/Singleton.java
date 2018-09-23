package javaBase;

class Student {
    private String name;
    private Long schoolId;

    public Student() {
        this.name = "yong";
        this.schoolId = 20152100188l;
    }
}

public class Singleton {
    private static Student student;

    private Singleton() {

    }

    public Student getInstance() {
        if (student!=null){
            return student;
        }
        synchronized {

        }
        if (student == null) {
            synchronized (student) {
                student = new Student();
                return student;
            }
        } else {
            return student;
        }
    }

}


