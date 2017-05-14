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

	public void readInfo()
	{
		StringBuilder jsonHtml = new StringBuilder();
		try{

			// 연결 url 설정
			URL url = new URL("http://119.202.36.218/applet/Server/"+ getType() + "_read.php");
			// 커넥션 객체 생성
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// 연결되었으면.
			if(conn != null){
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				// 연결되었음 코드가 리턴되면.
				if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)
				{
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
					for(;;)
					{
						// 웹상에 보여지는 텍스트를 라인단위로 읽어 저장.
						String line = br.readLine();
						if(line == null) break;
						// 저장된 텍스트 라인을 jsonHtml에 붙여넣음
						String[] tmp = line.split("\t");
						DBInfo in = new DBFactory().makeInfos(getType()).set(tmp);
						
						addInfo(in);	//add imageURL
					}
					br.close();
				}
				conn.disconnect();
			}

		} catch(Exception ex){
			ex.printStackTrace();
		}

		System.out.println(jsonHtml.toString());
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
