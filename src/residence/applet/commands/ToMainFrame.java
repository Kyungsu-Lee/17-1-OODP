package  residence.applet.commands;

import residence.applet.appletviews.Command;
import residence.applet.frame.*;

public class ToMainFrame implements Command
{
	LogInFrame login;
	MainFrame main;
	
	@Override
	public void execute() //first is HomeFrame, second is loginFrame
	{
		login.close();
		main.open();
	}

	@Override
	public Command setParams(Object... params) 
	{
		login = (LogInFrame)params[0];
		main = (MainFrame)params[1];
		
		return this;
	}

}
