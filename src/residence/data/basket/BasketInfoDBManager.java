package residence.data.basket;

import java.util.*;
import java.io.*;
import java.net.*;

import residence.data.user.*;
import residence.data.hotel.*;
import residence.data.*;

public class BasketInfoDBManager extends DBManager
{
	public static final String TYPE = "basket";
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

	public static DBManager getInstance()
	{
		if(instance == null)
			instance = new BasketInfoDBManager();

		return instance;
	}

	public boolean validate(String key, String value)
	{
		return false;
	}

	public void delete(BasketInfo info)
	{
		try
		{
			String link="http://119.202.36.218/applet/Server/" + getType() + "_delete.php";
			String data = "";
			for(int i=0; i < getPropertiesName().length; i++)
				data += "&" + URLEncoder.encode(getPropertiesName()[i], "UTF-8") + "=" + URLEncoder.encode(info.getProperty(i).toString(), "UTF-8");

			System.out.println(data);

			URL url = new URL(link);
			URLConnection conn = url.openConnection();

			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

			wr.write( data );
			wr.flush();

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String line = null;

			// Read Server Response
			while((line = reader.readLine()) != null)
			{
				sb.append(line);
				break;
			}

			System.out.println(sb.toString());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
