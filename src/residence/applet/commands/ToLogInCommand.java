package  residence.applet.commands;

import residence.applet.appletviews.Command;
import residence.applet.frame.HomeFrame;
import residence.applet.frame.LogInFrame;

public class ToLogInCommand implements Command
{
	HomeFrame home;
	LogInFrame login;
	
	@Override
	public void execute() //first is HomeFrame, second is loginFrame
	{
		home.close();
		login.open();
	}

	@Override
	public Command setParams(Object... params) 
	{
		home = (HomeFrame)params[0];
		login = (LogInFrame)params[1];
		
		return this;
	}

}
