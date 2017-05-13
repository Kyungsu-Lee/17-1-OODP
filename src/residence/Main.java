package residence;

import residence.user.*;
import residence.hotel.*;
import java.util.Scanner;

public class Main
{
	private static Scanner sc = new Scanner(System.in);	
	private static HotelInfoDBManager db = HotelInfoDBManager.getInstance();
	private static UserInfoDBManager user = UserInfoDBManager.getInstance();

	public static void main(String[] args)	
	{
		try
		{

			db.readInfo(args[0]);
			user.readInfo(args[1]);

			System.out.println(db.toString());
			System.out.println(user.toString());

		
		}

		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error");
		}
	}
}
