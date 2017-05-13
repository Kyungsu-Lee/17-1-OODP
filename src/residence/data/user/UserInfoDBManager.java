package residence.data.user;

import residence.data.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class UserInfoDBManager extends DBManager
{
	private static UserInfoDBManager instance;	//singleton pattern.

	private UserInfoDBManager()
	{

	}

	public static DBManager getInstance()
	{
		if(instance == null)
			instance = new UserInfoDBManager();

		return instance;
	}

	public boolean validate(String id, String pwd)
	{
		return containsKey(id) && pwd.equals(properties.get(id).getProperty(0));
	}

}
