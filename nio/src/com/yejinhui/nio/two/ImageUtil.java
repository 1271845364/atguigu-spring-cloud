package com.yejinhui.nio.two;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

/**
 * 给图片加水印，高并发场景
 * 
 * @author ye.jinhui
 * @date 2017年12月5日
 */
public class ImageUtil {

	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException {

		Thread.sleep(2000);
		long start = System.currentTimeMillis();
		// 启动十个线程，模拟同时请求生成邀请卡
		for (int i = 0; i < 30; i++) {
			final int t = i;
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 20; j++) {
						mark("d:/a/a" + t + j + ".png", Color.red, "" + t + j, t);
					}
				}
			};
			//在未来的某个时间执行给定的命令。命令可以在一个新的线程上执行
			executorService.execute(runnable);
		}
		executorService.shutdown();
		System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
	}

	private static BufferedImage bufImg0 = null;
	private static BufferedImage bufImg1 = null;
	private static BufferedImage bufImg2 = null;
	private static BufferedImage bufImg3 = null;
	private static BufferedImage bufImg4 = null;
	private static Image srcImg = null;
	private static int srcImgWidth = 200;
	private static int srcImgHeight = 200;

	// 静态代码块，在程序启动的时候加载进来
	static {
		Path path = Paths.get("1.png");
		String srcImgPath = path.toAbsolutePath().toString();
		System.out.println(srcImgPath);
		// 读取原图片信息
		File srcImgFile = new File(srcImgPath);
		try {
			srcImg = ImageIO.read(srcImgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		srcImgWidth = srcImg.getWidth(null);
		srcImgHeight = srcImg.getHeight(null);
		// 加水印
		bufImg0 = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
		bufImg1 = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
		bufImg2 = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
		bufImg3 = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
		bufImg4 = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
	}

	/**
	 * 图片添加水印
	 * 
	 * @param outImgPath
	 *            添加水印后图片输出路径
	 * @param markContentColor
	 *            水印文字的颜色
	 * @param waterMarkContent
	 *            水印的文字
	 */
	private synchronized static void mark(String outImgPath, Color markContentColor, String waterMarkContent, int count) {
		try {
			int num = count % 5;
			BufferedImage bufImg = null;
			switch (num) {
			case 0:
				bufImg = bufImg0;
				break;
			case 1:
				bufImg = bufImg1;
				break;
			case 2:
				bufImg = bufImg2;
				break;
			case 3:
				bufImg = bufImg3;
				break;
			default:
				bufImg = bufImg4;
				break;
			}
			Graphics2D g = bufImg.createGraphics();
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			// Font font = new Font("Courier New", Font.PLAIN, 12);
			Font font = new Font("宋体", Font.PLAIN, 50);
			g.setColor(markContentColor); // 根据图片的背景设置水印颜色

			g.setFont(font);
			int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
			int y = srcImgHeight - 3;
			// int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
			// int y = srcImgHeight / 2;
			g.drawString(waterMarkContent, x, y);
			g.dispose();
			// 输出图片
			FileOutputStream outImgStream = new FileOutputStream(outImgPath);
			ImageIO.write(bufImg, "jpg", outImgStream);
			outImgStream.flush();
			outImgStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取水印文字总长度
	 * 
	 * @param waterMarkContent
	 *            水印的文字
	 * @param g
	 * @return 水印文字总长度
	 */
	private synchronized static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
		return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
	}

}