package com.virt.Service;

import java.io.DataOutputStream;

import util.Connections;

public class Test {
public static void captureScreenShot(final String filename) {
	

	String adbPath="/root/adt-bundle-linux-x86-20131030/sdk/platform-tools/";
	System.setProperty("user.dir", adbPath);
	try {
		Process ppush = Runtime.getRuntime().exec("su");
		DataOutputStream os = new DataOutputStream(ppush.getOutputStream());
		//os.writeBytes("mount -o remount,rw -t yaffs2 /dev/block/mtdblock4 /system\n");
		os.writeBytes(adbPath+"adb push"+Connections.screenShotsPath+"screen.png storage/sdcard0");
	//	Process p = Runtime.getRuntime().exec(adbPath+"adb shell screencap -p |dos2unix >  /root/Desktop/scrcccc.png");
		//System.out.println(p.toString());
		os.writeBytes("\nexit\n");
		os.flush();
		System.out.println("capturing"+filename);	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}
public static void main(String[] args) {
/*	new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
	
		while(true){
			
			captureScreenShot("ScreenCap.png");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}}).start();
		*/
	captureScreenShot("ScreenCap.png");

}
}
