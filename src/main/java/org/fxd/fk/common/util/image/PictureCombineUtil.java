package org.fxd.fk.common.util.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片合并工具
 * 
 *
 * @author 冯晓东 398479251@qq.com
 */
public class PictureCombineUtil {

	private Graphics2D g = null;

	/**
	 * 导入本地图片到缓冲区
	 */
	public BufferedImage loadImageLocal(String imgName) {
		try {
			return ImageIO.read(new File(imgName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {

		try {
			int w = b.getWidth();
			int h = b.getHeight();

			g = d.createGraphics();
			g.drawImage(b, 60, 30, w, h, null);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return d;
	}

	/**
	 * 生成新图片到本地
	 */
	public void writeImageLocal(String newImage, BufferedImage img) {
		if (newImage != null && img != null) {
			try {
				File outputfile = new File(newImage);
				ImageIO.write(img, "png", outputfile);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// 测试用例
	public static void main1(String[] args) {

		PictureCombineUtil tt = new PictureCombineUtil();

		BufferedImage d = tt.loadImageLocal("C:/a.png");
		BufferedImage b = tt.loadImageLocal("C:/b.png");

		tt.writeImageLocal("C:/c.png", tt.modifyImagetogeter(b, d));
		// 将多张图片合在一起
		System.out.println("success");
	}
}
