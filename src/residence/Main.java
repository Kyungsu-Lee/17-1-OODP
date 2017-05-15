package residence;

import residence.data.*;
import residence.data.user.*;
import residence.data.hotel.*;
import residence.data.basket.*;
import java.util.Scanner;

public class Main
{
	private static Scanner sc = new Scanner(System.in);	

	public static void main(String[] args)	
	{
		BasketInfoDBManager db = (BasketInfoDBManager)BasketInfoDBManager.getInstance();

		db.delete(new BasketInfo("lmasi", args[0], "20170512", "5"));
	}
}
