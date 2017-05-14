package residence.data;

import residence.data.user.*;
import residence.data.hotel.*;
import residence.data.basket.*;

public class DBFactory
{
	public DBInfo makeInfos(String type)
	{
		if(type.equals("hotel"))
			return new HotelInfo();
		else if(type.equals("user"))
			return new UserInfo();
		else if(type.equals("basket"))
			return new BasketInfo();
		else
			return null;
	}
}
