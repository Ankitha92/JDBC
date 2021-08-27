package com.jspider.userentity;

public class User 
{
	private Integer id;
	private String name;
	private String email;
	private String mob;
	private String pass;
	
	public User()
	{
		super();
	}
	public User(String name, String email, String mob,String pass)
	{
		this.name=name;
		this.email=email;
		this.mob=mob;
		this.pass=pass;
	}
	public User(String name, String email, String mob)
	{
		this.name=name;
		this.email=email;
		this.mob=mob;
	}
	
	public User(String name)
	{
		this.name=name;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public String getName()
	{
		for(int i=0;i<name.length();i++)
		{
			if((name.charAt(i)>'a' && name.charAt(i)<'z')|| (name.charAt(i)>'A' && name.charAt(i)<'Z'))
			{
				return name;
			}
		}
		return null;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getEmail()
	{ 
		for(int i=0;i<email.length();i++)
		{
			if(email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]"))
			{
				return email;
			}
		}
		return null;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getMob()
	{
		if(mob.length()==10)
		{
			return mob;
		}
		return null;
	}
	public void setMob(String mob)
	{
		this.mob=mob;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass=pass;
	}
	@Override
	public String toString() {
		return "name : " + name + " email : " + email + " mob : " + mob;
	}
	
}
