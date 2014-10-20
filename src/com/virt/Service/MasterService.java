package com.virt.Service;

import java.io.DataOutputStream;

import util.Connections;

public class MasterService {
Boolean flag=true;
	public MasterService() {
		// TODO Auto-generated constructor stub
	}
	public void PauseThread()
	{
		flag=false;
		
	}
	public void ResumeThread()
	{
		flag=true;
		
	}

	public void startThread() {
		 new Thread(new Runnable() {

			@Override
			public void run() {
				

				while (flag) {
	
					try
					{
						
						TakeScreenShot("screen.png");
				
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					//File file=new File("/root/Desktop/arjun.png");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						}
			
			}
		}).start();

		
	}

	public static void main(String[] args) {
	//InputTap("90", "300");
	}
	public void TakeScreenShot(String fileName)
	{

		String adbPath=Connections.adbPathadb;
		System.setProperty("user.dir", adbPath);
		try {
			Process ppush = Runtime.getRuntime().exec("su");
			DataOutputStream os = new DataOutputStream(ppush.getOutputStream());
			//os.writeBytes("mount -o remount,rw -t yaffs2 /dev/block/mtdblock4 /system\n");
			os.writeBytes(adbPath+"adb shell screencap -p |dos2unix >  "+Connections.screenShotsPath+fileName);
		//	Process p = Runtime.getRuntime().exec(adbPath+"adb shell screencap -p |dos2unix >  /root/Desktop/scrcccc.png");
			//System.out.println(p.toString());
			os.writeBytes("\nexit\n");
			os.flush();
			System.out.println("capturing"+fileName);

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
