package com.yejinhui.nio.one;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO写大文件比较
 *
 * @author ye.jinhui
 * @project nio
 * @description
 * @create 2018/12/11 18:47
 */
public class WriteBigFileComparison {

    //每次写数据块大小
    private static final int DATA_CHUNK = 128 * 1024 * 1024;//128M

    //总数据大小
    private static final long LEN = 2L * 1024 * 1024 * 1024;//2g

    /**
     * 用通道写文件
     *
     * @param url
     */
    public static void writeWithFileChannel(String url) throws IOException {
        File file = new File(url);
        if(file.exists()) {
           file.delete();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = raf.getChannel();

        byte[] data = null;
        long len = LEN;
        ByteBuffer buf = ByteBuffer.allocate(DATA_CHUNK);
        int dataChunk = DATA_CHUNK / (1024 * 1024);
        while (len >= DATA_CHUNK) {
            System.out.println("write a data chunk: " + dataChunk + "MB");

            buf.clear(); // clear for re-write
            data = new byte[DATA_CHUNK];
            for (int i = 0; i < DATA_CHUNK; i++) {
                buf.put(data[i]);
            }

            data = null;

            buf.flip(); // switches a Buffer from writing mode to reading mode
            fileChannel.write(buf);
            fileChannel.force(true);

            len -= DATA_CHUNK;
        }

        if (len > 0) {
            System.out.println("write rest data chunk: " + len + "B");
            buf = ByteBuffer.allocateDirect((int) len);
            data = new byte[(int) len];
            for (int i = 0; i < len; i++) {
                buf.put(data[i]);
            }

            buf.flip(); // switches a Buffer from writing mode to reading mode, position to 0, limit not changed
            fileChannel.write(buf);
            fileChannel.force(true);
            data = null;
        }

        fileChannel.close();
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        writeWithFileChannel("G:/a.txt");
    }

}
