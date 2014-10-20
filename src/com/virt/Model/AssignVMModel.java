package com.virt.Model;

public class AssignVMModel {
private int vmAssignId;
private int loginId;
private String VMIp;
private String usage;

public int getLoginId() {
	return loginId;
}
public void setLoginId(int loginId) {
	this.loginId = loginId;
}
public String getVMIp() {
	return VMIp;
}
public void setVMIp(String vMIp) {
	VMIp = vMIp;
}
public int getVmAssignId() {
	return vmAssignId;
}
public void setVmAssignId(int vmAssignId) {
	this.vmAssignId = vmAssignId;
}
public String getUsage() {
	return usage;
}
public void setUsage(String usage) {
	this.usage = usage;
}
}
