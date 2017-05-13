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
		db.readInfo("data", "user");

		System.out.println(new UserInfo("aaa", "aaa", "aaa", "1").toFormatString());
	}
}
