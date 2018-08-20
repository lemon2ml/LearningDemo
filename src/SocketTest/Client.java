package SocketTest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * client side
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		//��������
		Scanner sc = new Scanner(System.in);
		System.out.println("������������֣�");
		String name = sc.next();
		
		Socket socket = new Socket("localhost", 9999);
		System.out.println("------" + name + "������------");
		
		//��socket����������ﴫ����Ӧ���߳���
		ThreadReader tr = new ThreadReader(socket.getInputStream());
		ThreadWriter tw = new ThreadWriter(socket.getOutputStream());
		
		tr.setName(name);
		tw.setName(name);
		tr.start();
		tw.start();
	}

}

/**
 * Processing client's inputstream
 * @author Administrator
 */

class ThreadReader extends Thread{
	private InputStream is;
	
	public ThreadReader(InputStream is) {
		this.is  = is;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				byte[] b = new byte[1024];
				int len = is.read(b);
				String mess = new String(b, 0, len);
				System.out.println("��������" +mess);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Processing client's outputstream
 */

class ThreadWriter extends Thread{
	private OutputStream os;
	
	public ThreadWriter(OutputStream os) {
		this.os = os;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			while(true) {
				System.out.println("��������Ϣ��");
				String mess = sc.next();
				String info = sdf.format(new Date()) + " " + Thread.currentThread().getName() + "˵��" + mess;
				os.write(info.getBytes());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}


