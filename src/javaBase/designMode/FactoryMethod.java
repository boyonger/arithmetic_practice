package javaBase.designMode;

public class FactoryMethod {
    public static void main(String args[]){
        new NexProduce().produce().run();
    }
}
//抽象工厂方法
interface vivoPhone{
    void run();
}

//生成方法
interface ProduceFactory{
    vivoPhone produce();
}

//具体产品
class Pro5 implements vivoPhone{

    @Override
    public void run() {
        System.out.println("我是一台pro5");
    }
}

class Nex implements vivoPhone{

    @Override
    public void run() {
        System.out.println("我是一台nex");
    }
}

class x23 implements vivoPhone{

    @Override
    public void run() {
        System.out.println("我是一台x23");
    }
}

class Pro5Produce implements ProduceFactory{

    @Override
    public vivoPhone produce() {
        return new Pro5();
    }
}

class NexProduce implements ProduceFactory{

    @Override
    public vivoPhone produce() {
        return new Nex();
    }
}



