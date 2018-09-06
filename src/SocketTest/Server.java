package SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Server Side
 * @author Administrator
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(9999);
		System.out.println("-------服务器端已启动-----");
		List<Socket> list = new ArrayList<Socket>();
		while(true) {
			Socket socket = server.accept();
			list.add(socket);
			ThreadSocket ts = new ThreadSocket(socket, list);
			ts.start();
		}
	}
}


/**
 * 服务器处理socket线程
 * @author Administrator
 */

class ThreadSocket extends Thread{
	private Socket socket;
	private List<Socket> list;
	
	public ThreadSocket(Socket socket, List list) {
		this.socket = socket;
		this.list = list;
	}
	
	@Override
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			while(true) {
				is = socket.getInputStream();
				
				byte[] b = new byte[1024];
				int len = is.read(b);
				String mess = new String(b, 0, len);
				System.out.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
				System.out.println(mess);
				
				for(Socket s : list) {
					os = s.getOutputStream();
					os.write(mess.getBytes());
				}
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}



