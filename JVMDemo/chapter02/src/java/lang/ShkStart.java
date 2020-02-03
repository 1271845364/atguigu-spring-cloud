package java.lang;

/**
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/1/31 18:57
 */
public class ShkStart {

    //java.lang.SecurityException: Prohibited package name: java.lang
    //java.lang包是需要权限的，起到保护作用；防止把引导类加载器整挂了
    public static void main(String[] args) {
        System.out.println("hello!");
    }
}
