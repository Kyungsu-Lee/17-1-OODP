package residence.data.hotel;

import residence.data.*;

public class HotelInfo extends DBInfo
{
	/*
	*	key : name
	*	property
	*		name
	*		location
	*		number
	*		price
	*		imageURL
	*/
	public HotelInfo()
	{
		properties = new String[5];
	}

	public HotelInfo(String name, String location, int number, String price, String imageURL)
	{
		key = name;
		properties = new String[4];

		properties[0] = name;
		properties[1] = location;
		properties[2] = number;
		properties[3] = price;
		properties[4] = imageURL;
	}

	public HotelInfo(String[] args)
	{
		key = args[0];
		properties = new String[5];

		for(int i=0; i<5; i++)
			properties[i] = args[i];
	}

	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof HotelInfo))
			return false;

		boolean flag = true;
		HotelInfo other = (HotelInfo)o;

		flag &= (key.equals(other.getKey()));

		for(int i=0; i<properties.length; i++)
			flag &= (properties[i].equals(other.getProperty(i)));

		return flag;
	}	
}
