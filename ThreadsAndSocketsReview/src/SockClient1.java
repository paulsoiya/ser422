import java.net.*;
import java.io.*;

class SockClient1 {
     public static void main (String args[]) throws Exception {
        Socket          sock = null;
        OutputStream    out = null;
        InputStream     in = null;
	int i1=0, i2=0;
	char cmd = ' ';

	if (args.length != 2 && args.length != 3) {
	    System.out.println("USAGE: java SockClient char int1 [int2]");
	    System.exit(1);
	}
	try {
	    cmd = args[0].charAt(0);
	    i1 = Integer.parseInt(args[1]);
	    if (args.length > 2) {
		i2 = Integer.parseInt(args[2]);
	    }
	} catch (NumberFormatException nfe) {
	    System.out.println("Command line args must be integers");
	    System.exit(2);
	}
        try {
            sock = new Socket("localhost", 8888);
            out = sock.getOutputStream();
            in = sock.getInputStream();

	    out.write(cmd);
            out.write(i1);
	    if (cmd != 't') {
		out.write(i2);
	    }
            int result = in.read();
            System.out.println("Result is " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null)  out.close();
            if (in != null)   in.close();
            if (sock != null) sock.close();
        }
    }
}
