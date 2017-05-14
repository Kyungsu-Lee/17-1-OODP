package residence;

import residence.data.*;
import residence.data.user.*;
import residence.data.hotel.*;
import java.util.Scanner;

public class Main
{
	private static Scanner sc = new Scanner(System.in);	

	public static void main(String[] args)	
	{
		DBManager db = UserInfoDBManager.getInstance();

		db.writeInfo(new UserInfo("lee", "asd", "name", "20"));
	}
}
