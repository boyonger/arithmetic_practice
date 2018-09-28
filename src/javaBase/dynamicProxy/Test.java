package javaBase.dynamicProxy;

public class Test {
    public static void main(String[] args){
        ProductService productService=new ProductServiceImpl();
        ProductService proxy= (ProductService) new JdkInvocationHandler().getInstance(productService);
        proxy.addProduct("iphone");

    }
}
