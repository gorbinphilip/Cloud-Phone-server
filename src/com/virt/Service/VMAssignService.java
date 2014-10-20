package com.virt.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virt.Model.AssignVMModel;

import util.DBConnection;

public class VMAssignService {

	DBConnection db=new DBConnection();
	Connection con=db.getConnection();
	PreparedStatement pst=null;
	ResultSet rst=null;
	
	public void insert(AssignVMModel model)
	{
		try {
			pst=con.prepareStatement("insert into Tbl_AssignVM(VMassignID,VmIP,Usage,UserID)values(?,?,?,?)");
		    pst.setInt(1,model.getVmAssignId());
		    pst.setString(2,model.getVMIp());
		    pst.setString(3,model.getUsage());
		    pst.setInt(4,model.getLoginId());
		    pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Update(AssignVMModel model)
	{
		try {
			pst=con.prepareStatement("update Tbl_AssignVM set Usage=? where UserID=?");
			pst.setString(1, model.getUsage());
			pst.setInt(2, model.getLoginId());
			pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
