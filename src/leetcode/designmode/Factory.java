package leetcode.designmode;

/*
  抽象工厂(animal) 工厂方法模式
 */
abstract class AbstractFactory {
    abstract public Animal show();
}

/*
  factory 1:create ox factory
 */
class OxFactory extends AbstractFactory {
    public Animal show() {
        return new Ox();
    }
}

/*
factory 2:create horse factory
 */
class HorseFactory extends AbstractFactory {
    public Animal show() {
        return new Horse();
    }
}

/*
抽象动物类
 */
abstract class Animal {
    abstract public void create();
}

/*
具体生产类：牛
 */
class Ox extends Animal {
    public void create() {
        System.out.println("creat ox");
    }
}

class Horse extends Animal {
    public void create() {
        System.out.println("creat horse");
    }
}

public class Factory {
    public static void main(String[] args) {
        new HorseFactory().show().create();
    }
}
