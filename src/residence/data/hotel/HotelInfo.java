package residence.data.hotel;

import residence.data.*;

public class HotelInfo extends DBInfo
{
	/*
	*	key : name
	*	property
	*		location
	*		number
	*		price
	*		imageURL
	*/
	public HotelInfo()
	{
		properties = new String[4];
	}

	public HotelInfo(String name, String location, int number, String price, String imageURL)
	{
		key = name;
		properties = new String[4];

		properties[0] = location;
		properties[1] = number;
		properties[2] = price;
		properties[3] = imageURL;
	}

	public HotelInfo(String[] args)
	{
		if(args.length < 4) return;

		key = args[0];
		properties = new String[4];

		properties[0] = args[1];
		properties[1] = args[2];
		properties[2] = args[3];
		properties[3] = args[4];
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
