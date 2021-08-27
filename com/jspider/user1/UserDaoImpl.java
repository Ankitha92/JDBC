package com.jspider.user1;

import java.sql.SQLException;

import com.jspider.user2.UserDb;
import com.jspider.userentity.User;

public class UserDaoImpl implements UserDao
{
	UserDb db=new UserDb();
	@Override
	public void openApp() throws SQLException
	{
		db.setDBConnection();
	}

	@Override
	public void addUser(User us) throws SQLException 
	{
		System.out.println("user");
		int count=db.insert(us);
		
		if(count>0)
		{
			System.out.println(us.getName()+" "+"was created");
		}
	}

	@Override
	public User view(String email) throws SQLException
	{
		User ud=db.selectbyEmail(email);
		return ud;
		
	}

	@Override
	public User search(String Mob) throws SQLException
	{
		User un=db.searchOthers(Mob);
	
		return un;
	}

	@Override
	public void updateEmail(String curEmail,String newEmail) throws SQLException{
		
		db.updateEm(curEmail,newEmail);
	}

	@Override
	public void delete(String dEmail) throws SQLException
	{
		db.deleteA(dEmail);
		
	}

	@Override
	public void updateMob(String curMob, String newMob) throws SQLException {
		db.updateMo(curMob,newMob);
		
	}

	@Override
	public void logout() {
		
		
	}

	@Override
	public boolean login(String mob,String pass) throws SQLException {
		boolean b=db.loginstatus(mob,pass);
		return b;
	}

	@Override
	public void closeApp() throws SQLException{
		db.disconnect();
		
	}
	
}
