package com.virt.Model;

public class VMAllocateModel {

	private int vmID;
	private String VMIp;
	private String VMStatus;
	
	public int getVmID() {
		return vmID;
	}
	public void setVmID(int vmID) {
		this.vmID = vmID;
	}
	public String getVMIp() {
		return VMIp;
	}
	public void setVMIp(String vMIp) {
		VMIp = vMIp;
	}
	public String getVMStatus() {
		return VMStatus;
	}
	public void setVMStatus(String vMStatus) {
		VMStatus = vMStatus;
	}
}
