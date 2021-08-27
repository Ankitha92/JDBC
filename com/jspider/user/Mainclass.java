package com.jspider.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.user1.UserDaoImpl;
import com.jspider.userentity.User;

public class Mainclass {

	static final Scanner sc=new Scanner(System.in);
	static final UserDaoImpl udi=new UserDaoImpl();
	private static final String String = null;
	public static void signup()
	{
		System.out.println("enter the name");
		String name=sc.next();
		
		System.out.println("enter the email");
		String email=sc.next();
		
		System.out.println("enter the mob");
		String mob=sc.next();
		
		System.out.println("enter the password");
		String pass=sc.next();
		
		User us=new User(name,email,mob,pass);
		try {
			udi.addUser(us);
		} catch (SQLException e) {
			System.out.println();
			System.out.println("Oops!! Error in inserting"+" "+us.getName());
		}
		
	}
	public static void menu()
	{
		while(true)
		{
		System.out.println("1. signup ");
		System.out.println("2. login");
		int c=sc.nextInt();
		if(c==1)
		{
		try {
				udi.openApp();
		} catch (SQLException e) {
			System.out.println("connect");
		}
		System.out.println("add users");
		signup();
		
		}
		else if(c==2)
		{
			try {
				udi.openApp();
			} catch (SQLException e) {
				System.out.println("connect");
			}
			Boolean b=loginpage();
			if(b)
			{
				System.out.println("login Successfully");
				while(true)
				{
					System.out.println("1.view Profile");
					System.out.println("2.search for other user");
					System.out.println("3.update email");
					System.out.println("4.update mobile number");
					System.out.println("5.delete account");
					System.out.println("6.logout");
					
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:viewUser();
						break;
					case 2: searchUser();
						break;
					case 3:updateEmail();
						break;
					case 4:updateMob();
						break;
					case 5:deleteAcc();
						break;
					case 6:logout();
						break;
					default :try {
						udi.closeApp();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					}
				}
			}else {
				try {
					udi.closeApp();
					System.out.println("login not possible");
				} catch (SQLException e) {
					
				}
			}
		}
		}
	}
	private static void logout()
	{
		
		menu();
	}
	private static void deleteAcc()
	{
		
		System.out.println("enter mobile no");
		String mob=sc.next();
		
		try {
			udi.delete(mob);
			System.out.println("deleted successfully");
		} catch (SQLException e) {
			System.out.println("Oops!! not able to delete");
		}
	}
	private static void updateMob() {
		System.out.println("enter current mobile number");
		String curMob=sc.next();
		
		System.out.println("enter new mobile number ");
		String newMob=sc.next();
		try {
			udi.updateMob(curMob,newMob);
		} catch (SQLException e) {
			System.out.println("Oops error in updating");
		}
		
	}
	private static void updateEmail() 
	{
		System.out.println("enter current email");
		String cuurEmail=sc.next();
		
		System.out.println("enter new email");
		String newEmail=sc.next();
		try {
			udi.updateEmail(cuurEmail,newEmail);
			System.out.println("email id changed successfully");
		} catch (SQLException e) {
			System.out.println("Oops! update not possible");
		}
		
	}
	private static void searchUser() 
	{
		System.out.println("enter the mobile number");
		String mob=sc.next();
		
		try {
			User u=udi.search(mob);
			System.out.println(u.getName());
		} catch (SQLException e) {
			System.out.println("Oops!! name doesn't exit in a database");
		}
	}
	private static void viewUser() {
		System.out.println("enter email");
		String email=sc.next();
		try {
			User ua=udi.view(email);
			
			System.out.println(ua.toString());
		} catch (SQLException e) {
			System.out.println();
			System.out.println("Oops!! email not found");
		}
		
	}
	private static boolean loginpage()
	{
		boolean b=false;
		System.out.println("enter mobile number");
		String Mob=sc.next();
		
		System.out.println("enter password");
		String lnpass=sc.next();
		try {
				b=udi.login(Mob,lnpass);
				
		} catch (SQLException e) {
			System.out.println();
			System.out.println("invalid email id or password");
		}
		return b;
	}
	private static String getMob(String mob) {
		
		return mob;
	}
	public static void main(String[] args) 
	{
		
		menu();
	}
}	
