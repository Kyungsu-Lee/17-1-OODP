package residence.user;

public class UserInfo
{
	private String id = "";
	private String passwd = "";
	private String name = "";
	private int age = -1;

	public UserInfo(String id, String pwd, String name, String age) throws UserInfoException
	{
		setId(id);
		setPasswd(pwd);
		setName(name);
		setAge(age);
	
		UserInfoDBManager.getInstance().addInfo(this);
	}

	public UserInfo(String id, String pwd, String name, int age) throws UserInfoException
	{
		setId(id);
		setPasswd(pwd);
		setName(name);
		setAge(age);

		UserInfoDBManager.getInstance().addInfo(this);
	}

	public void setPasswd(String passwd)	{ this.passwd = passwd; }
	public void setName(String name)	{ this.name = name; }
	public void setAge(int age)		{ this.age = age; }

	public void setId(String id) throws UserInfoException
	{ 
		this.id = id;
	} 

	public void setAge(String age) throws UserInfoException
	{
		try
		{
			this.age = Integer.parseInt(age);
		}
		catch(Exception e)
		{
			throw new UserInfoException();
		}
	}

	public String getId() throws UserInfoException
	{
		if(id.equals(""))
			throw new UserInfoException();

		return this.id;
	}	

	public String getPassWd() throws UserInfoException
	{
		if(passwd.equals(""))
			throw new UserInfoException();

		return this.passwd;
	}

	public String getName() throws UserInfoException
	{
		if(name.equals(""))
			throw new UserInfoException();

		return this.name;
	}

	public int getAge() throws UserInfoException
	{
		if(this.age == -1)
			throw new UserInfoException();

		return this.age;
	}

	@Override
	public String toString()
	{
		return "(" + id + ", " + passwd + ", " + name + ", " + age + ")";
	}

	public String toFormatString()
	{
		return id + "\t" + passwd + "\t" + name + "\t" + age;
	}

	@Override
		public boolean equals(Object o)
		{
			if(!(o instanceof UserInfo))
				return false;

			UserInfo other = (UserInfo)o;

			try
			{

				return 	this.id.equals(other.getId())
					& this.getPassWd().equals(other.getPassWd())
					& this.getName().equals(other.getName())
					& this.getAge() == other.getAge()
					;
			}
			catch(Exception e)
			{
				return false;
			}
		}	
}
