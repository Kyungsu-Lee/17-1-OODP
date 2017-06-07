package residence.data.list;

import residence.data.basket.*;

public class BasketItem implements DataItem
{
	public BasketInfo item;

	public BasketItem(BasketInfo item)
	{
		this.item = item;
	}

	public String getHotelName()
	{
		return (String)item.getProperty(1);
	}

	public String getDate()
	{
		return (String)item.getProperty(2);
	}
	
	public int getNumber()
	{
		try
		{	
			return Integer.parseInt((String)item.getProperty(3));
		}
		catch(Exception e)
		{
			return -1;
		}
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof BasketItem) && this.item.equals(((BasketItem)o).item);
	}
}
