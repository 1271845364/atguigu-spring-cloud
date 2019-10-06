package com.yejinhui.nio.two;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;

/**
 * @author ye.jinhui
 * @create 2017-03-25 15:20
 */
public class TestNIO_2 {

    /**
     * 自动资源管理：自动关闭实现AutoCloseable接口的资源
     */
    @Test
    public void test8() {
        try(FileChannel inChannel = FileChannel.open(Paths.get("1.png"),StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("2.png"),StandardOpenOption.WRITE,StandardOpenOption.CREATE)){

            ByteBuffer buf = ByteBuffer.allocate(1024);
            inChannel.read(buf);
            buf.flip();
            outChannel.write(buf);
        }catch (IOException e) {

        }
    }

    /**
     * Files常用方法：用于操作内容
     *      SeekableByteChannel newByteChannel(Path path,OpenOption ... how):获取与指定文件的连接，how指定打开方式
     *      DirctoryStream newDirectoryStream(Path path):打开path指定的目录
     *      InputStream newInputStream(Path path,OpenOption ... how):获取InputStream对象
     *      OutputStream newOutputStream(Path path,OpenOption ... how):获取OutputStream对象
     */
    @Test
    public void test7() throws IOException {
        SeekableByteChannel seekableByteChannel = Files.newByteChannel(Paths.get("1.png"),StandardOpenOption.READ);

        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("d:/"));
        for (Path path:paths) {
            System.out.println(path);
        }
    }


    /**
     * Files常用方法：用于判断
     *      boolean exists(Path path,LinkOption ... opts):判断文件是否存在
     *      boolean isDirectory(Path path,LinkOption ... ops):判断是否是目录
     *      boolean isExecutorable(Path path):判断是否是可执行文件
     *      boolean isHidden(Path path):判断是否是隐藏文件
     *      boolean isReadable(Path path):判断文件是否可读
     *      boolean isWriteable(Path path):判断文件是否可写
     *      boolean notExists(Path path,LinkOption ... ops):判断文件是否不存在
     */
    @Test
    public void test6() throws IOException {
        Path path = Paths.get("d:/nio/hello7.txt");
        System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
        BasicFileAttributes readAttributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

        System.out.println(readAttributes.creationTime());
        System.out.println(readAttributes.lastModifiedTime());

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        fileAttributeView.setHidden(true);
    }

    /**
     * Files常用方法：
     *      Path copy(Path src,Path dest,CopyOption ...how):文件的复制
     *      Path createDirectory(Path path,FileAttribute<?> ...attr):创建一个目录
     *      Path createFile(Path path,FileAttribute<?> ...attr):创建一个文件
     *      void delete(Path path):删除一个文件
     *      Path move(Path src,Path dest,CopyOption ...how):将src移动到dest位置
     *      long size(Path path):返回Path指定文件的大小
     */
    @Test
    public void test5() throws IOException {
        Path path1 = Paths.get("d:/softinfo.xml");
        Path path2 = Paths.get("d:/softinfo1.xml");

        System.out.println(Files.size(path1));

//        Files.move(path1,path2,StandardCopyOption.ATOMIC_MOVE);
        Files.deleteIfExists(path2);
    }

    @Test
    public void test4() throws IOException {
//        Path dir = Paths.get("d:/nio/nio2");
//        Files.createDirectory(dir);

        Path file = Paths.get("d:/softinfo1.xml");
//        Files.createFile(file);

        Files.deleteIfExists(file);
    }

    @Test
    public void test3() throws IOException {
        Path path1 = Paths.get("d:/softinfo.xml");
        Path path2 = Paths.get("d:/softinfo-bak.xml");

        Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Paths提供的get()方法用来获取Path对象：
     *  Path get(String first,String ...more):用于将多个字符串连成路径。
     * Path常用方法：
     *  boolean endsWith(String path):判断是否以path路径结束
     *  boolean startsWith(String path):判断是否以path路径开始
     *  boolean isAbsolute():判断是否是绝对路径
     *  Path getFileName():返回与调用Path对象关联的文件名
     *  Path getName(int idx):返回指定索引位置idx的路径名称
     *  int getNameCount():返回Path根目录后面元素的数量
     *  Path getParent():返回Path对象包含整个路径，不包含Path对象指定的文件路径
     *  Path getRoot():返回调用Path的根路径
     *  Path resolve(Path p):将相对路径解析为绝对路径
     *  Path toAbsolutePath():作为绝对路径返回调用Path对象
     *  String toString():返回调用Path对象的字符串表示形式
     */
    @Test
    public void test2() {
        Path path = Paths.get("d:/softinfo.xml");

        System.out.println(path.getParent());
        System.out.println(path.getRoot());

        Path path2 = Paths.get("1.png");
        Path newPath = path2.toAbsolutePath();
        System.out.println(newPath);

        System.out.println(path2.toString());
    }

    @Test
    public void test1() {
        Path path = Paths.get("d:/","softinfo.xml");

        System.out.println(path.endsWith("softinfo.xml"));
        System.out.println(path.startsWith("d:/"));

        System.out.println(path.isAbsolute());
        System.out.println(path.getFileName());

        for(int i=0;i<path.getNameCount();i++) {
            System.out.println(path.getName(i));
        }
    }
}
