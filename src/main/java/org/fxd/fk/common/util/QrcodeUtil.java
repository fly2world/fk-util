package org.fxd.fk.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QrcodeUtil {

	public static String creatQrCode(String contents, int width, int height) {
		String binary = null;
		try {
			Hashtable<EncodeHintType, String> hints = new Hashtable<>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			// 1、读取文件转换为字节数组
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			BufferedImage image = toBufferedImage(bitMatrix);
			// 转换成png格式的IO流
			ImageIO.write(image, "png", out);
			byte[] bytes = out.toByteArray();

			// 2、将字节数组转为二进制
			binary = Base64.getEncoder().encodeToString(bytes);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3,加上图片前缀
		binary = "data:image/jpeg;base64," + binary;

		return binary;
	}

	/**
	 * image流数据处理
	 *
	 * @author ianly
	 */
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		return image;
	}

	public static void main2(String[] args) {
		String binary = QrcodeUtil.creatQrCode("https://blog.csdn.net/ianly123", 500, 500);
		System.out.println(binary);
	}
}