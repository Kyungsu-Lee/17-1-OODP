package residence;

import residence.user.*;
import java.util.Scanner;

public class Main
{
	private static Scanner sc = new Scanner(System.in);	
	private static UserInfoDBManager db = UserInfoDBManager.getInstance();

	public static void main(String[] args)	
	{
		try
		{
			db.readInfo(args[0]);

			System.out.println(db);

			
		}

		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error");
		}
	}
}
