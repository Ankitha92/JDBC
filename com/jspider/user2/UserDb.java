package com.jspider.user2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.userentity.User;


public class UserDb 
{
	private final String dbUrl = "jdbc:mysql://127.0.0.1:3306/";
	private final String username = "root";
	private final String password = "Ammuanku92@";
	private Connection con = null;// SingleTon
	
	
	
	private final String schemaName = "userdb";
	public void setDBConnection() throws SQLException {
		if (con == null) {
			con = DriverManager.getConnection(dbUrl + schemaName, username, password);
		}
	}
	public int insert(User std) throws SQLException 
	{
		
		String insertQuery = "insert into userdb.user values(?,?,?,?,?);";
		
		PreparedStatement psm = con.prepareStatement(insertQuery);
		psm.setInt(1, 0);
		
		psm.setString(2, std.getName());
		psm.setString(3, std.getEmail());
		psm.setString(4, std.getMob());
		psm.setString(5, std.getPass());

		int count = psm.executeUpdate();
		return count;

	}
	public boolean loginstatus(String mob,String pass)throws SQLException
	{
		boolean islogn=false;
		String e="select mob,password from userdb.user where mob=?;";
		
		PreparedStatement psm=con.prepareStatement(e);
		psm.setString(1,mob);
		
		ResultSet res=psm.executeQuery();
		
		String em="";
		String pm="";
		
		while(res.next())
		{
			em=res.getString("mob");
			pm=res.getString("password");
			
			if(pm.equals(pass))
			{
				islogn=true;
			}
		}
		
		
	
		return islogn;
	}
	public User selectbyEmail(String email)throws SQLException
	{
		String selectQuery="select name,email,mob from userdb.user where email=?;";
		PreparedStatement psm = con.prepareStatement(selectQuery);
		psm.setString(1, email);

		ResultSet rs = psm.executeQuery();// exectute Select query and copy the result to ResultSet
		rs.next();// move the cursor to first record/row

		
		String name = rs.getString("name");
		System.out.println(name);
		String sEmail = rs.getString("email");
		String mob = rs.getString("mob");
		
		User std = new User(name, sEmail, mob);
		return std;
	}
	public User searchOthers(String mobile) throws SQLException
	{
		String selectN="select name from userdb.user where mob=?;";
		PreparedStatement psm=con.prepareStatement(selectN);
		psm.setString(1, mobile);
		
		ResultSet rs=psm.executeQuery();
		rs.next();
		String sname=rs.getString("name");
		
		User std=new User(sname);
		return std;
	}
	public void updateEm(String curEmail, String newEmail)throws SQLException
	{
		String updateQuery="update userdb.user set email=? where email=?;";
		PreparedStatement psm = con.prepareStatement(updateQuery);
		psm.setString(1, newEmail);
		psm.setString(2, curEmail);

		int count = psm.executeUpdate();

		if (count == 0) {
			SQLException sqlex = new SQLException("email id do not exist");
			throw sqlex;
		}
		
	}
	public void updateMo(String curMob,String newMob)throws SQLException
	{
		String updateQuery="update userdb.user set mob=? where mob=?;";
		PreparedStatement psm = con.prepareStatement(updateQuery);
		psm.setString(1, newMob);
		psm.setString(2, curMob);

		int count = psm.executeUpdate();

		if (count == 0) {
			SQLException sqlex = new SQLException("email id do not exist");
			throw sqlex;
		}
	}
	public void deleteA(String demail)throws SQLException
	{
		String deleteQuery="delete from userdb.user where mob=?;";
		PreparedStatement psm=con.prepareStatement(deleteQuery);
		psm.setString(1, demail);
		
		int count=psm.executeUpdate();
		
		if(count==0)
		{
			SQLException sq=new SQLException("email id not exist");
			throw sq;
		}
		
	}
	public void disconnect() throws SQLException{
		con.close();
		
	}
	
}
