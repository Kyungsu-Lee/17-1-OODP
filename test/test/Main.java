public class Main
{
	public static void main(String[] args)
	{
		Parent p = new Child();

		System.out.println(p.getString("1", "@", "3"));
	}
}
