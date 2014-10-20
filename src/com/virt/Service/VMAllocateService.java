package com.virt.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virt.Model.VMAllocateModel;

import util.DBConnection;

public class VMAllocateService {
	DBConnection db=new DBConnection();
	Connection con=db.getConnection();
	PreparedStatement pst=null;
	ResultSet rst=null;
	 
	public void insert(VMAllocateModel model)
	{
		try {
			pst=con.prepareStatement("insert into Tbl_VMAllocate(VmID,VmIP,VNStatus)values(?,?,?)");
			pst.setInt(1,model.getVmID());
			pst.setString(2,model.getVMIp());
			pst.setString(3,model.getVMStatus());
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
