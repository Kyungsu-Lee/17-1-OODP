public class Child extends Parent
{
	@Override
	public String getString(String... str)
	{
		String r = "";
		for(String s : str)
			r += s;
		return r;
	}
}
