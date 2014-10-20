package com.virt.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import util.Connections;

public class SocketCreation 
{
	static ServerSocket server=null;
	static Socket soc;
	static BufferedReader din,dinfile;
	static InputStream in,infile;
	static OutputStream out;
	public void CreateSocketConn()
	{
        try {
			server=new ServerSocket(Connections.port);
			System.out.println("myPort"+Connections.port);
			System.out.println("Socket Created");
			soc=server.accept();
//			in=soc.getInputStream();
//			din=new BufferedReader(new InputStreamReader(in));
//			out=soc.getOutputStream();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try
					{
						while(true)
						{
					FileInputStream fin=new FileInputStream(new File("/home/usr/Programs/manage_cloud/VirtualSmartPhSer/WebContent/Screens/screen.png"));
					 byte buf1[]=new byte[fin.available()];
					 fin.read(buf1);
					 sendbytes(buf1);
						Thread.sleep(500);
						MasterService mstServ =new MasterService();
						mstServ.TakeScreenShot("screen.png");
						Thread.sleep(1000);
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
			}).start();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
public  void sendbytes(byte[] data) throws IOException {
	    
	    boolean result = false;
//	    System.out.println("Sending byte data::"+ new String(data,0,data.length));
	    
	    OutputStream out = soc.getOutputStream();
	    DataOutputStream dos = new DataOutputStream(out);
	    int len = data.length;
	    dos.writeInt(len);
	    if (len > 0) {
	        dos.write(data, 0, len);
	    }

	    
	    System.out.println("Byte data Sent");
	    
	    
	}

}
