package residence.data;

public abstract class DBInfo
{
	protected String key;
	protected Object[] properties;

	public abstract boolean equals(Object o);

	public String toString()
	{
		StringBuilder sb = new StringBuilder("");

		sb.append("(");
		sb.append(key + ", ");
		for(Object property : properties)
			sb.append(property.toString() + ", ");
		sb.replace(sb.lastIndexOf(", "), sb.length()-1, ")"); 
		return sb.toString();
	}

	public String toFormatString()
	{
		StringBuilder sb = new StringBuilder("");

		sb.append(key + "\t");
		for(Object property : properties)
		{
			System.out.println(property);
			sb.append(property.toString() + "\t");
		}
		sb.replace(sb.lastIndexOf("\t"), sb.length()-1, ""); 
		return sb.toString();
	}	

	public String getKey()
	{
		return this.key;
	}

	public void setProperty(int idx, Object property)
	{
		properties[idx] = property;
	}

	public Object getProperty(int idx)
	{
		return this.properties[idx];
	}

	public void setProperties(String... property)
	{
		for(int i=0; i<properties.length; i++)
			properties[i] = property[i];
	}

	public abstract DBInfo set(String[] args);
}
