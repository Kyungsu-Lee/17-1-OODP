package residence.user;

import java.util.*;
import java.io.*;
import java.net.*;

public class UserInfoDBManager
{
	private static UserInfoDBManager instance;	//singleton pattern.

	private HashSet<String> ids = new HashSet<String>();
	private HashMap<String, UserInfo> userInfo = new HashMap<String, UserInfo>();	//key id, value : userinfo

	private UserInfoDBManager()
	{

	}

	public static UserInfoDBManager getInstance()
	{
		if(instance == null)
			instance = new UserInfoDBManager();

		return instance;
	}

	private void addId(String id) throws UserInfoException
	{
		if(contains(id))
			throw new UserInfoException("User Id is already Exist");

		ids.add(id);
	}

	public void addInfo(UserInfo userInfo) throws UserInfoException
	{
		addId(userInfo.getId());
		this.userInfo.put(userInfo.getId(), userInfo);
	}

	public void addInfo(String id, String pwd, String name, String age) throws UserInfoException
	{
		addId(id);
		this.userInfo.put(id, new UserInfo(id, pwd, name, age));
	}

	public boolean contains(String id)
	{
		return ids.contains(id);
	}

	public void readInfo(String fileName)
	{
		try
		{
			URL dataStream = new URL("http://119.202.36.218/applet/" + fileName);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataStream.openStream()));

			String s;

			/*
			 *	file format : id pwd name age
			 *	token : \t
			 */
			while ((s = in.readLine()) != null) {
				String[] tmp = s.split("\t");
				new UserInfo(tmp[0], tmp[1], tmp[2], tmp[3]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean validateUser(String id, String pwd)
	{
		try
		{
			return contains(id) && pwd.equals(userInfo.get(id).getPassWd());
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		String str = "";
		for(String id : ids)
			str += userInfo.get(id) + "\n";

		return str;
	}

	public String toFormatString()
	{
		String str = "";
		for(String id : ids)
			str += userInfo.get(id).toFormatString() + "\n";

		return str;
	}
}
