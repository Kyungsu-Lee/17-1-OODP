package residence.data.user;

import residence.data.*;

public class UserInfo extends DBInfo
{
	public UserInfo()
	{
		this.properties = new String[3];
	}

	public UserInfo(String id, String pwd, String name, String age)
	{
		this.key = id;
		this.properties = new String[4];	//pwd, name, age
		this.properties[0] = id;
		this.properties[1] = pwd;
		this.properties[2] = name;
		this.properties[3] = age;

		UserInfoDBManager.getInstance().addInfo(this);
	}

	public UserInfo(String[] args)
	{
		if(args.length < 4) 
			return;	

		this.key = args[0];
		this.properties = new String[4];	//pwd, name, age
		this.properties[0] = args[0];
		this.properties[1] = args[1];
		this.properties[2] = args[2];
		this.properties[3] = args[3];

		UserInfoDBManager.getInstance().addInfo(this);
	}

	public DBInfo set(String[] args)
	{
		this.key = args[0];
		this.properties = new String[4];	//pwd, name, age
		this.properties[0] = args[0];
		this.properties[1] = args[1];
		this.properties[2] = args[2];
		this.properties[3] = args[3];

		return this;
	}

	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof UserInfo))
			return false;

		boolean flag = true;
		UserInfo other = (UserInfo)o;
		
		flag &= (key.equals(other.getKey()));

		for(int i=0; i<properties.length; i++)
			flag &= (properties[i].equals(other.getProperty(i)));

		return flag;
	}	
}
