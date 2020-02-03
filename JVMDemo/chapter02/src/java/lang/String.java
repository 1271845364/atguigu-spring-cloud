package java.lang;

public class String {

    //<clinit>()构造器方法中
    static{
        System.out.println("我是自定义的String类的静态代码块");
    }

    //运行出现错误原因，需要加载当前的类，最终委托给引导类加载器，加载了rt.jar中的String，执行main()没有这个方法
    public static void main(String[] args) {
        System.out.println("hello,String");
    }
}
