import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;

public class MultiThreadedServer implements Runnable{

	protected int          serverPort   = 5000;
	protected ServerSocket serverSocket = null;
	protected boolean      isStopped    = false;
	protected Thread       runningThread= null;

	public MultiThreadedServer(int port){
		this.serverPort = port;
	}

	public void run(){
		synchronized(this){
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		while(! isStopped()){
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if(isStopped()) {
					System.out.println("Server Stopped.") ;
					return;
				}
				throw new RuntimeException(
						"Error accepting client connection", e);
			}
			new Thread(
					new WorkerRunnable(
						clientSocket, "Multithreaded Server")
				  ).start();
		}
		System.out.println("Server Stopped.") ;
	}


	private synchronized boolean isStopped() {
		return this.isStopped;
	}

	public synchronized void stop(){
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}

	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			throw new RuntimeException("Cannot open port 8080", e);
		}
	}

	public static void main(String[] args)
	{
		MultiThreadedServer server = new MultiThreadedServer(5000);
		new Thread(server).start();
	}

}

class WorkerRunnable implements Runnable{

	protected Socket clientSocket = null;
	protected String serverText   = null;

	public WorkerRunnable(Socket clientSocket, String serverText) {
		this.clientSocket = clientSocket;
		this.serverText   = serverText;
	}

	public void run() {
		try {
			InputStream input  = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();

			InputStreamReader isr = null;
			BufferedReader br = null;

			isr = new InputStreamReader(input);
			br = new BufferedReader(isr);
			// 클라이언트로부터 데이터를 받기 위한 InputStream 선언

			File f = new File("/var/www/html/applet/data");
			PrintWriter pww= new PrintWriter(new BufferedWriter(new FileWriter(f, true)));

			String data=null;
			while((data=br.readLine()) != null)
			{
				System.out.println("클라이언트로 부터 받은 데이터:" + data);
				pww.print(data + "\n");
				pww.close();
			}

		} catch (IOException e) {
			//report exception somewhere.
			e.printStackTrace();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
