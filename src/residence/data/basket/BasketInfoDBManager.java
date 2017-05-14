package residence.data.basket;

import java.util.*;
import java.io.*;
import java.net.*;

import residence.data.user.*;
import residence.data.hotel.*;
import residence.data.*;

public class BasketInfoDBManager extends DBManager
{
	public static final String TYPE = "user";
	public static final String[] PROPERTIESNAME = 
	{
		"id",
		"hotel_name",
		"date",
		"number"
	};

	public String getType() { return this.TYPE; };
	public String[] getPropertiesName() { return this.PROPERTIESNAME; }

	private static BasketInfoDBManager instance = null;

	private BasketInfoDBManager()
	{
	}

	public static DBManager getInstace()
	{
		if(instance == null)
			instance = new BasketInfoDBManager();

		return instance;
	}

	public boolean validate(String key, String value)
	{
		return false;
	}
}
