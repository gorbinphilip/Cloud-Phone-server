package com.virt.Service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.virt.Model.LoginModel;

import util.DBConnection;

public class UsrLoginService {
DBConnection db=new DBConnection();
Connection con=db.getConnection();
PreparedStatement pst=null;
ResultSet rst=null;
public int insert(LoginModel lgMOd)
{
	int id=0;
	try {
			pst=con.prepareStatement("insert into Tbl_UserLOgin(UserName,Password,email) values (?,?,?)",java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, lgMOd.getUserName());
			pst.setString(2, lgMOd.getPassword());
			pst.setString(3, lgMOd.geteMail());
			pst.execute();
			rst=pst.getGeneratedKeys();
			while(rst.next())
			{
				id=rst.getInt(1);
				
			}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return id;
	

}
public int LoginCheck(LoginModel lgMod)
{
int id=0;

try {
	
	pst=con.prepareStatement("select * from Tbl_UserLOgin where UserName=? and Password=?");
	pst.setString(1, lgMod.getUserName());
	pst.setString(2, lgMod.getPassword());
	rst=pst.executeQuery();
	while(rst.next())
	{
		id=rst.getInt(1);
		
	}
} catch (Exception e) {
	e.printStackTrace();
	// TODO: handle exception
}
return id;
}	

}
