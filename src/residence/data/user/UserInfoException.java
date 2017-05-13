package residence.data.user;

public class UserInfoException extends Exception
{
	public UserInfoException()
	{
		super("UserInfo is not defined");
	}

	public UserInfoException(String msg)
	{
		super(msg);
	}
}
