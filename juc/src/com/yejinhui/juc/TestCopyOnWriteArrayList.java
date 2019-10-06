package com.yejinhui.juc;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet:“写入并复制” = 每次写入时都复制    并发迭代的时候使用
 * 注意：添加操作多时，效率低，因为每次添加的时都会进行复制，开销非常大，并发迭代操作多时可以选择提高效率。
 * @author ye.jinhui
 * @create 2017-02-25 17:58
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        HelloThread ht = new HelloThread();

        for(int i=0;i<10;i++) {
            new Thread(ht).start();
        }
    }
}

class HelloThread implements Runnable {

//    private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static List<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
            if(list.size() == 3) {
                list.add("AA");
            }
        }
    }
}
