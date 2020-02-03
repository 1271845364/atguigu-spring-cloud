package com.yejinhui.java2;

/**
 * 解析调用中的虚方法和非虚方法
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/2 14:52
 */
class Father{
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father普通方法");
    }
}
public class Son extends Father{

    public Son() {
        super();
    }
    public Son(int age) {
        this();
    }

    //不是重写的父类的静态方法，因为静态方法是不能被重写的
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private " + str);
    }

    public void show() {
        //invokestatic
        showStatic("yejinhui.com");
        //invokestatic
        super.showStatic("good!");
        //invokespecial
        showPrivate("hello!");
        //invokespecial
        super.showCommon();
        //invokevirtual
        //因为此方法声明有final，不能被子类重写，所以也认为此方法是非虚方法
        showFinal();

        //虚方法如下：
        //invokevirtual
        showCommon();
        //invokevirtual
        info();

        MethodInterface in = null;
        //invokeinterface
        in.methodA();
    }

    public void info(){

    }

    public void display(Father father) {
        father.showCommon();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}
interface MethodInterface{
    void methodA();
}