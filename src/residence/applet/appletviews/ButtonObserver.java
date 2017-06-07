package residence.applet.appletviews;

public class ButtonObserver implements Observer{

	@Override
	public void update(View view) 
	{
		if(view.getCommand() == null)
			return;
		
		if(view instanceof newButton)
		{
			newButton button = (newButton)view;
			button.getCommand().execute();
		}
	}

}
