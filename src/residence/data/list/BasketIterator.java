package residence.data.list;

public class BasketIterator implements Iterator
{
	private BasketList basketlist;

	private int index;

	public BasketIterator(BasketList basketlist){
		this.basketlist = basketlist;
		this.index = 0;
	}

	public boolean hasNext(){
		if(index < basketlist.getLength()){
			return true;
		}else{
			return false;
		}
	}
	public Object next(){
		BasketItem item = (BasketItem)basketlist.getDataItemAt(index);
		index++;
		return item;
	}
}
