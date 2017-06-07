package  residence.applet.frame;

import java.applet.Applet;
import residence.system.*;
import residence.data.*;
import residence.data.user.*;

public class Main extends Applet
{
	DBManager db;
	DBManager hotelInfo;
	CurrentUser SYSTEM;

	public void init()
	{
		db = UserInfoDBManager.getInstance();
		db.readInfo();
		SYSTEM = CurrentUser.getInstance();

		setSize(600, 600);

		FrameInterface f = new HomeFrame(600, 600);
		f.open();
	}

	public void start()
	{

	}
}
