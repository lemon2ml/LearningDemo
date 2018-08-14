package com.lei.tests;
//package test;
//import java.io.*;
//import java.util.Date;
//import java.awt.*;
//import java.awt.image.*;
//import javax.imageio.ImageIO;
//import com.sun.image.codec.jpeg.*;
///**
// * ͼƬѹ������
// * @author ����ǿ
// */
//public class ImgCompress {
//	private Image img;
//	private int width;
//	private int height;
//	@SuppressWarnings("deprecation")
////	public static void main(String[] args) throws Exception {
////		System.out.println("��ʼ��" + new Date().);
////		ImgCompress imgCom = new ImgCompress("C:\\temp\\pic123.jpg");
////		imgCom.resizeFix(400, 400);
////		System.out.println("������" + new Date().toLocaleString());
////	}
//	/**
//	 * ���캯��
//	 */
//	public ImgCompress(String fileName) throws IOException {
//		File file = new File(fileName);// �����ļ�
//		img = ImageIO.read(file);      // ����Image����
//		width = img.getWidth(null);    // �õ�Դͼ��
//		height = img.getHeight(null);  // �õ�Դͼ��
//	}
//	/**
//	 * ���տ�Ȼ��Ǹ߶Ƚ���ѹ��
//	 * @param w int �����
//	 * @param h int ���߶�
//	 */
//	public void resizeFix(int w, int h) throws IOException {
//		if (width / height > w / h) {
//			resizeByWidth(w);
//		} else {
//			resizeByHeight(h);
//		}
//	}
//	/**
//	 * �Կ��Ϊ��׼���ȱ�������ͼƬ
//	 * @param w int �¿��
//	 */
//	public void resizeByWidth(int w) throws IOException {
//		int h = (int) (height * w / width);
//		resize(w, h);
//	}
//	/**
//	 * �Ը߶�Ϊ��׼���ȱ�������ͼƬ
//	 * @param h int �¸߶�
//	 */
//	public void resizeByHeight(int h) throws IOException {
//		int w = (int) (width * h / height);
//		resize(w, h);
//	}
//	/**
//	 * ǿ��ѹ��/�Ŵ�ͼƬ���̶��Ĵ�С
//	 * @param w int �¿��
//	 * @param h int �¸߶�
//	 */
//	public void resize(int w, int h) throws IOException {
//		// SCALE_SMOOTH �������㷨 ��������ͼƬ��ƽ���ȵ� ���ȼ����ٶȸ� ���ɵ�ͼƬ�����ȽϺ� ���ٶ���
//		BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB ); 
//		image.getGraphics().drawImage(img, 0, 0, w, h, null); // ������С���ͼ
//		File destFile = new File("C:\\temp\\456.jpg");
//		FileOutputStream out = new FileOutputStream(destFile); // ������ļ���
//		// ��������ʵ��bmp��png��gifתjpg
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		encoder.encode(image); // JPEG����
//		out.close();
//	}
//}