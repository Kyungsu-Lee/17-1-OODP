package residence.data.list;

import java.util.*;

public abstract class ListData implements Aggregate
{
	protected HashSet<DataItem> itemHash;
	protected ArrayList<DataItem> items;

	public abstract DataItem getDataItemAt(int index);
	public abstract void addItem(DataItem item);
	public abstract void remove(DataItem item);
	public abstract int getLength();
	public abstract Iterator iterator(); 
}
