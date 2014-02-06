import java.net.*;
import java.io.*;

class SockServer5 {
	public static void main (String args[]) throws Exception {

		int count = 0;
		ServerSocket    serv = null;
		InputStream in = null;
		OutputStream out = null;
		Socket sock = null;

		try {
			serv = new ServerSocket(8888);
		} catch(Exception e) {
			e.printStackTrace();
		}
		while (serv.isBound() && !serv.isClosed()) {
			System.out.println("Ready...");
			try {
				sock = serv.accept();
				in = sock.getInputStream();
				out = sock.getOutputStream();

				int x = in.read();
				int y = in.read();
				System.out.println("Server received " + x +" "+ y);
				out.write(x + y);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (out != null)  out.close();
				if (in != null)   in.close();
				if (sock != null) sock.close();
			}
		}
	}
	
	class RequestProcessor extends Thread {
		static final int BUF_MAX = 256;
		void processRequest(Socket sock) throws IOException {
			// This method gets the data off the input stream
			InputStream in = sock.getInputStream();
			byte[] buf = new byte[BUF_MAX];
			int numBytes = in.read(buf);
			// not looping as we assuming it is an upper bound
			// first byte is client id
			
			
			
		}
	}
}

