package com.virt.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import util.Connections;

public class ProcessCommands {

	private static ProcessBuilder pb;
	// private static final String adbPath =
	// "/root/adt-bundle-linux-x86-20131030/sdk/platform-tools/adb";
	// private static final String vmIPAddress = "";
	private static int counter = 3;

	public static void main(String[] args) {
		try {
			sendAdbCommands(new ArrayList<String>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					/*
					 * add("300"); add("200");
					 */
				}
			});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String sendAdbCommands(List<String> varArgs) throws Exception {
		Connections conn = new Connections();
		List<String> commands = new ArrayList<String>();
		commands.add(conn.adbPath);
		for (String command : varArgs) {
			commands.add(command);
		}

		String result = runCommand(commands);
		System.out.println("In Process Command");
		
		if (result.contains("device not found")) {
			counter--;
			List<String> connectCommands = new ArrayList<String>();
			connectCommands.add(conn.adbPath);
			connectCommands.add("connect");
			connectCommands.add(conn.vmIPAddress);
			runCommand(connectCommands);
			sendAdbCommands(varArgs);
			if (counter <= 0) {
				throw new Exception("Cannot Connect to Device");
			}
		} else {
			counter = 3;// reset counter
		}
		return result;
	}

	public static String runCommand(List<String> commands) throws IOException {

		pb = new ProcessBuilder(commands);
	//	pb.directory(new File(Connections.screenShotsPath));
		pb.redirectErrorStream(true);
		Process process = pb.start();
		StringBuilder out = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		String line = null, previous = null;
		while ((line = br.readLine()) != null)
			if (!line.equals(previous)) {
				previous = line;
				out.append(line).append('\n');

			}
		return out.toString();

	}

}