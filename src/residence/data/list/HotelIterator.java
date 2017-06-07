package residence.data.list;

public class HotelIterator implements Iterator
{
	private HotelList hotellist;

	private int index;

	public HotelIterator(HotelList hotellist){
		this.hotellist = hotellist;
		this.index = 0;
	}

	public boolean hasNext(){
		if(index < hotellist.getLength()){
			return true;
		}else{
			return false;
		}
	}
	public Object next(){
		HotelItem item = (HotelItem)hotellist.getDataItemAt(index);
		index++;
		return item;
	}
}
