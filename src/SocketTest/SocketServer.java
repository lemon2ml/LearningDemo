package SocketTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketServer {
	public static void main(String[] args) throws IOException {
		// �˿ں�
		int port = 7000;
		// �ڶ˿��ϴ���һ���������׽���
		ServerSocket serverSocket = new ServerSocket(port);
		// �������Կͻ��˵�����
		Socket socket = serverSocket.accept();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		do {
			double length = dis.readDouble();
			System.out.println("���������յ��ı߳�����Ϊ��" + length);
			double result = length * length;
			dos.writeDouble(result);
			dos.flush();
		} while (dis.readInt() != 0);
		socket.close();
		serverSocket.close();
	}
}
