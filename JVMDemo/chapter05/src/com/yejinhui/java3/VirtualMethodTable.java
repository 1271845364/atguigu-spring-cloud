package com.yejinhui.java3;

/**
 * 虛方法表
 *
 * @author ye.jinhui
 * @description
 * @program JVMDemo
 * @create 2020/2/2 16:57
 */
interface Friendly {
    void sayHello();
    void sayGoodbye();
}
class Dog{
    public void sayHello(){

    }

    @Override
    public String toString() {
        return "Dog";
    }
}
class Cat implements Friendly {

    public void eat() {

    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodbye() {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
class CockerSpaniel extends Dog implements Friendly {

    @Override
    public void sayHello() {
        super.sayHello();
    }

    @Override
    public void sayGoodbye() {

    }
}
public class VirtualMethodTable {

}
