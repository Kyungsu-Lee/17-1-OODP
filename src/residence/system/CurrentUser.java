package residence.system;

import residence.data.user.UserInfoDBManager;

public class CurrentUser
{
	private String id;

	private static CurrentUser instance;

	private CurrentUser()
	{
		
	}

	public static CurrentUser getInstance()
	{
		if(instance == null)
			instance = new CurrentUser();

		return instance;
	}

	public void setId(String id) { this.id = id; }
	public String getId(){ return this.id; }

	public boolean logIn(String id, String pwd)
	{
		boolean flag = UserInfoDBManager.getInstance().validate(id, pwd);

		if(flag)
			setId(id);
	
		return flag;
	}
}
