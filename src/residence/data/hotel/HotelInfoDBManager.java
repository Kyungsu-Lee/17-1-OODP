package residence.data.hotel;

import residence.data.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class HotelInfoDBManager extends DBManager
{
	private static HotelInfoDBManager instance = null;

	private HotelInfoDBManager()
	{
		
	}

	public static DBManager getInstance()
	{
		if(instance == null)
			instance = new HotelInfoDBManager();

		return instance;
	}

	public boolean validate(String key, String value)
	{
		return false;
	}
}
