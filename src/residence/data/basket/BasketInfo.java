package residence.data.basket;

import residence.data.*;

public class BasketInfo extends DBInfo
{
	/*
	*	key : hotel_name + date
	*	property
	*		id
	*		hotel_name
	*		date
	*		number
	*/
	public BasketInfo()
	{
		initialize(4);
	}

	public BasketInfo(String id, String hotel_name, String date, String number)
	{
		initialize(4);
		this.key = hotel_name + ":" + date;
		this.properties[0] = id;
		this.properties[1] = hotel_name;
		this.properties[2] = date;
		this.properties[3] = number;
	}

	public BasketInfo(String[] args)
	{
		this.key = args[0];
		for(int i=0; i<4; i++)
			this.properties[i] = args[i];
	}

	private void initialize(int size)
	{
		this.properties = new String[size];
	}

	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof BasketInfo))
			return false;

		boolean flag = true;
		BasketInfo other = (BasketInfo)o;
		
		flag &= (key.equals(other.getKey()));

		for(int i=0; i<properties.length; i++)
			flag &= (properties[i].equals(other.getProperty(i)));

		return flag;
	}	
}
