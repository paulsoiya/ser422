import java.net.*;
import java.io.*;

class SockServer1 {
    public static void main (String args[]) throws Exception {
        int count = 0;
        ServerSocket    serv = null;
        InputStream in = null;
        OutputStream out = null;
        Socket sock = null;
        
	int total = 0;

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

		char c = (char)in.read();
                int x = in.read();
		System.out.print("Server received " + c + " " + x);
		if (c == 't') { 
		    total += x;
		    out.write(total);
		} else {
		    int y = in.read();
		    System.out.print(" " + y);
		    out.write(x + y);
		}
		System.out.println("");
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
}

