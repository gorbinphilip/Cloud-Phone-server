package util;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.virt.Service.ProcessCommands;

public class AdbCommandUtil {
	
	public void commandTouch(String x, String y) {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("shell");
		commands.add("input");
		commands.add("tap");
		commands.add(x);
		commands.add(y);
	
		try {
			ProcessCommands.sendAdbCommands(commands);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void commandSwipe(String x1, String y1,String x2,String y2) {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("shell");
		commands.add("input");
		commands.add("swipe");
		commands.add(x1);
		commands.add(y1);
		commands.add(x2);
		commands.add(y2);
	
		try {
			ProcessCommands.sendAdbCommands(commands);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void commandpushFile(String fileName) {
		ArrayList<String> commands = new ArrayList<String>();
		commands.add("push");
		commands.add(Connections.screenShotsPath);
		commands.add(fileName);
		commands.add("storage/sdcard0");
		
	System.out.println("FIleName (Process CMD)"+fileName);
		try {
			ProcessCommands.sendAdbCommands(commands);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
