package residence.data.list;

import java.util.HashSet;
import java.util.ArrayList;

public class BasketList extends ListData
{
	public BasketList(){
		this.items = new ArrayList<DataItem>();
		this.itemHash = new HashSet<DataItem>();
	}

	public DataItem getDataItemAt(int index)
	{
		return items.get(index);
	}

	public void addItem(DataItem item)
	{
		if(!itemHash.contains(item))
		{
			this.itemHash.add(item);
			this.items.add(item);
		}
	}

	public void remove(DataItem item)
	{
		itemHash.remove(item);
		items.remove(item);
	}

	public int getLength(){
		return items.size();
	}

	public Iterator iterator() {
		return new BasketIterator(this);
	}
}
