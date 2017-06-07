package  residence.applet.commands;


import residence.applet.appletviews.Command;
import residence.applet.frame.HomeFrame;
import residence.applet.frame.SignInFrame;

public class ToSignInCommand implements Command {

	HomeFrame home;
	SignInFrame sign;
	
	@Override
	public Command setParams(Object... params) {
		
		home = (HomeFrame)params[0];
		sign = (SignInFrame)params[1];
		
		return this;

	}

	@Override
	public void execute() {
		home.close();
		sign.open();
	}

}
