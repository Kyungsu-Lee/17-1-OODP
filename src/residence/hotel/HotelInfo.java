package residence.hotel;

public class HotelInfo
{
	private String name;
	private String location;
	private int number;
	private String price;
	private String imageURL;

	public HotelInfo(String name, String location, int number, String price, String imageURL)
	{
		setName(name); setLocation(location); setNumber(number); setPrice(price); setImageURL(imageURL);
	}

	public void setName(String name) { this.name = name; }
	public void setLocation(String location) { this.location = location; }
	public void setNumber(int number) { this.number = number; }
	public void setPrice(String price) { this.price = price; }
	public void setImageURL(String imageURL) { this.imageURL = imageURL; }

	public String getName() { return this.name; }
	public String getLocation() { return this.location; }
	public int  getNumber() { return this.number; }
	public String getPrice() { return this.price; }
	public String getImageURL() { return this.imageURL; }

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("");

		sb.append("(");
		sb.append(name + ", ");
		sb.append(location + ", ");
		sb.append(number + ", ");
		sb.append(price + ", ");
		sb.append(imageURL + ")");

		return sb.toString();
	}

	public String toFormatString()
	{
		StringBuilder sb = new StringBuilder("");

		sb.append(name + "\t");
		sb.append(location + "\t");
		sb.append(number + "\t");
		sb.append(price + "\t");
		sb.append(imageURL);

		return sb.toString();
	}

	@Override
		public boolean equals(Object o)
		{
			if(!(o instanceof HotelInfo))
				return false;

			HotelInfo other = (HotelInfo)o;

			try
			{

				return 	this.name.equals(other.getName())
					& this.getLocation().equals(other.getLocation())
					& this.getNumber()==(other.getNumber())
					& this.getPrice().equals(other.getPrice())
					& this.getImageURL().equals(other.getImageURL())
					;
			}
			catch(Exception e)
			{
				return false;
			}
		}	
}
