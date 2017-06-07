package residence.applet.appletviews;

public interface Command {
	
	public Command setParams(Object... params);
	public void execute();
}
