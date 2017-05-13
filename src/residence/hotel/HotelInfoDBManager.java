package residence.hotel;

import java.util.*;
import java.io.*;
import java.net.*;

public class HotelInfoDBManager
{
	private static HotelInfoDBManager instance = null;

	private HashSet<String> names = new HashSet<String>();
	private HashMap<String, HotelInfo> hotelInfo = new HashMap<String, HotelInfo>();	//key name, value : hotelinfo

	private HotelInfoDBManager()
	{
		
	}

	public static HotelInfoDBManager getInstance()
	{
		if(instance == null)
			instance = new HotelInfoDBManager();

		return instance;
	}

	private void addName(String name)
	{
		this.names.add(name);
	}

	public boolean contains(String name)
	{
		return names.contains(name);
	}

	public void addInfo(HotelInfo hotelInfo) 
	{
		addName(hotelInfo.getName());
		this.hotelInfo.put(hotelInfo.getName(), hotelInfo);
	}

	public void addInfo(String name, String location, int number, String price, String imageURL) 
	{
		addName(name);
		this.hotelInfo.put(name, new HotelInfo(name, location, number, price, imageURL));
	}
	
	public int getCount()
	{
		return this.names.size();
	}

	public void readInfo(String fileName)
	{
		try
		{
			URL dataStream = new URL("http://119.202.36.218/applet/" + fileName);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataStream.openStream(), "UTF-8") );

			String s;

			/*
			 *	file format : name, location, number, price, imageURL 
			 *	token : \t
			 */
			while ((s = in.readLine()) != null) {
				String[] tmp = s.split("\t");
				addInfo(new HotelInfo(tmp[1], tmp[2], Integer.parseInt(tmp[3]), tmp[4], ""));	//add imageURL
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String toString()
	{
		String str = "";
		for(String name : names)
			str += hotelInfo.get(name) + "\n";

		return str;
	}

	public String toFormatString()
	{
		String str = "";
		for(String name : names)
			str += hotelInfo.get(name).toFormatString() + "\n";

		return str;
	}

	public Object[] getNames()
	{
		ArrayList<String> tmp = new ArrayList<String>();
		for(String name : names)
			tmp.add(name);

		return tmp.toArray();
	}

	public HotelInfo getInfos(String name)
	{
		return hotelInfo.get(name);
	}
}
