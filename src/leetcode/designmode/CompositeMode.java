package leetcode.designmode;

import java.util.ArrayList;
import java.util.List;

/*
组合模式
 */
interface Father {
    void add(Father f);
    void remove(Father f);
    void operation();
}
class Branch implements Father{
    public List<Father> children=new ArrayList<>();

    @Override
    public void add(Father f) {
        children.add(f);
    }

    @Override
    public void remove(Father f) {
        children.remove(f);
    }

    @Override
    public void operation() {
        for (Father f:children){
            if (f instanceof Left){
                f.operation();
            }
        }
    }
}

class Left implements Father{
    @Override
    public void add(Father f) {
        
    }

    @Override
    public void remove(Father f) {
        
    }

    @Override
    public void operation() {
        System.out.println("树叶被访问");
    }
}
public class CompositeMode {}
