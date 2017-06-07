package  residence.applet.frame;

import java.awt.*;

import residence.applet.appletviews.newButton;
import residence.applet.commands.ToLogInCommand;
import residence.applet.commands.ToSignInCommand;
import residence.data.*;
import residence.data.hotel.*;
import residence.data.user.*;


public class MainFrame extends Frame implements FrameInterface
{
	Panel sideBar;
	Panel content;
	Panel body;
	newButton[] btns;
	String[] btn_name;

	MainFrame(int width, int height)
	{
		this.setSize(width, height);
		this.setLayout (new BorderLayout());

		Panel title = new Panel();

		title.setLayout (new FlowLayout(FlowLayout.CENTER));
		title.setBackground(new Color(255, 255, 240));  // give it color so you can see it
		Label titles = new Label("숙박 예약 서비스");
		title.add(titles);
		titles.setFont(new Font("Arial",Font.PLAIN, 15));

		Panel subTitle = new Panel();       // south Panel will just hold one Label
		subTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		subTitle.setBackground(new Color(255, 255, 240));  // give it color so you can see it
		Label bottom = new Label("Made by Group-C");
		bottom.setFont(new Font("Arial",Font.PLAIN, 15));
		subTitle.add(bottom);

		GridBagLayout gb1 = new GridBagLayout();
		GridBagLayout gb2 = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();

		body = new Panel();
		body.setSize(getSize().width, (int)(getSize().height * 8 / 10.0));
		body.setLayout(gb1);

		sideBar = new Panel();
		sideBar.setLayout(new GridLayout(10, 1));
		gc.weightx = 1.0;
		gc.weighty = 3.0;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.BOTH;

		btns = new newButton[10];
		btn_name = new String[]
		{
			"숙박업체 조회",
			"장바구니 조회"
		};
		for(int i=0; i<btn_name.length; i++)
		{
			btns[i] = new newButton(btn_name[i]);
			btns[i].add(new searchHotelFrame(600, 800));	
			sideBar.add(btns[i]);
		}

		body.add(sideBar, gc);


		content = new Panel();
		gc.weightx = 3.0;
		gc.weighty = 3.0;
		gc.gridx = 1;
		gc.gridy = 0;
		body.add(content, gc);


		this.add(title, BorderLayout.NORTH);
		this.add(subTitle, BorderLayout.SOUTH);
		this.add(body, BorderLayout.CENTER);

		DBManager hotelInfo = HotelInfoDBManager.getInstance();
		hotelInfo.readInfo();
	}

	public void open()
	{
		this.setVisible(true);
	}

	public void close()
	{
		this.setVisible(false);
	}
}

