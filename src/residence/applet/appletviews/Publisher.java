package  residence.applet.appletviews;

public interface Publisher {

	public void add(Observer observer);
	public void delete(Observer observer);
	public void notifyCommand();
}
