package javaBase.dynamicProxy;

public class ProductServiceImpl implements ProductService{

    @Override
    public void addProduct(String productName) {
        System.out.println(productName);
    }
}
