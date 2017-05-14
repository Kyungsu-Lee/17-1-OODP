package residence.data.hotel;

import residence.data.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class HotelInfoDBManager extends DBManager
{
	public static final String TYPE = "hotel";
	public static final String[] PROPERTIESNAME = 
	{
		"name",
		"location",
		"number",
		"price",
		"imageURL"
	};

	public String getType() { return this.TYPE; };
	public String[] getPropertiesName() { return this.PROPERTIESNAME; }

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
