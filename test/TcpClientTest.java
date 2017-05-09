// TcpClientTest.java

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;


public class TcpClientTest {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String serverIP = "119.202.36.218"; // 127.0.0.1 & localhost 본인
			System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);
			OutputStream os = null;
			OutputStreamWriter osw =null;
			BufferedWriter bw = null;

			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIP, 5000);

			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);  

			bw.write(sc.nextLine());
			bw.newLine();
			bw.flush();



			// 스트림과 소켓을 닫는다.
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} // try - catch
	} // main
} // TcpClientTest



