package javaBase.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JdkInvocationHandler implements InvocationHandler {
    private ProductService target;

    public Object getInstance (ProductService target){
        this.target=target;
        Class clazz=this.target.getClass();
        //参数1：被代理类加载器 参数二：被代理类的接口 参数三
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }

    public Object invoke(Object proxy, Method method,Object[] args) throws InvocationTargetException, IllegalAccessException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String currentDate=simpleDateFormat.format(new Date());
        System.out.println("日期 "+currentDate+" 加入了产品");
        return method.invoke(this.target,args);
    }
}
