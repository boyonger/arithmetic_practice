package dynamicPrograme;

//返回最长子数组
//n {31,-41,59,26,-53,58,97,-93,-23,-84}
public class MaxContainArray {
    public static void main(String[] args){
        int[] a={31,-41,59,26,-53,58,97,-93,-23,-84};
        int sum=0,maxArray=0;
        //小于0舍弃，大于0可以继续算
        for (int i=1;i<a.length;i++){
            if (maxArray>0){
                maxArray+=a[i];
            }
            else{
                maxArray=a[i];
                if (sum<maxArray){
                    sum=maxArray;
                }
            }
        }
        System.out.println(sum);
    }
}
