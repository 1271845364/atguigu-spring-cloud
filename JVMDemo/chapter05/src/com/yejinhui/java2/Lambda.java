package com.yejinhui.java2;

/**
 * 体验invokedynamic指令
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/2 15:57
 */
@FunctionalInterface
interface Func{
    boolean func(String str);
}
public class Lambda {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        Func func = s->{
            return true;
        };
        lambda.lambda(func);

        lambda.lambda(s->{
            return true;
        });
    }
}
