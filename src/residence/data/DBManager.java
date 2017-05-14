package residence.data;

import java.util.*;
import java.net.*;
import java.io.*;

public abstract class DBManager
{
	protected HashSet<String> keys = new HashSet<String>();
	protected HashMap<String, DBInfo> properties = new HashMap<String, DBInfo>();

	protected abstract String getType();
	protected abstract String[] getPropertiesName();

	public boolean containsKey(String key)
	{
		return this.keys.contains(key);
	}
	private void addKey(String key)
	{
		keys.add(key);
	}
	
	public void addInfo(DBInfo data)
	{
		addKey(data.getKey());
		this.properties.put(data.getKey(), data);
	}

	public DBInfo getInfo(String key)
	{
		return properties.get(key);
	}

	public int getCount()
	{
		return this.keys.size();
	}

	public Object[] getKeys()
	{
		ArrayList<String> tmp = new ArrayList<String>();
		for(String key : keys)
			tmp.add(key);

		return tmp.toArray();
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
				addInfo(new DBFactory().makeInfos(getType()).set(tmp));	//add imageURL
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void writeInfo(DBInfo info)
	{
		try
		{

			String link="http://119.202.36.218/applet/Server/" + getType() + "_write.php";
			String data = "";
			for(int i=0; i < getPropertiesName().length; i++)
				data += "&" + URLEncoder.encode(getPropertiesName()[i], "UTF-8") + "=" + URLEncoder.encode(info.getProperty(i).toString(), "UTF-8");

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

	@Override
	public String toString()
	{
		String str = "";
		for(String key : keys)
			str += properties.get(key) + "\n";

		return str;
	}

	public String toFormatString()
	{
		String str = "";
		for(String key : keys)
			str += properties.get(key).toFormatString() + "\n";

		return str;
	}

	public abstract boolean validate(String key, String value);
}
