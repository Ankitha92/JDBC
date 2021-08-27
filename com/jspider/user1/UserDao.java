package com.jspider.user1;

import java.sql.SQLException;

import com.jspider.userentity.User;

public interface UserDao 
{
	public void openApp() throws SQLException;
	public void addUser(User us) throws SQLException;
	public User view(String email) throws SQLException;
	public User search(String name) throws SQLException;
	public void updateEmail(String curEmail,String newEmail) throws SQLException;
	public void delete(String dEmail) throws SQLException;
	public void updateMob(String curMob,String newMob) throws SQLException;
	public void logout();
	public boolean login(String email, String pass) throws SQLException;
	public void closeApp() throws SQLException;
}
