package  residence.applet.frame;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import residence.system.*;
import residence.applet.appletviews.*;
import residence.applet.commands.*;

public class LogInFrame extends Frame implements FrameInterface
{
	TextField id;
	TextField pwd;
	newButton btn_login;

	CurrentUser SYSTEM;
	
	public LogInFrame(int width, int height)
	{
		final Command command = new ToMainFrame().setParams(this, new MainFrame(width, height));

		SYSTEM = CurrentUser.getInstance();

		GridBagLayout gridbag = new GridBagLayout();
		GridBagLayout gridbag2 = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();

		this.setSize(width, 200);
		this.setLayout(new GridLayout(3, 1));

		Panel p = new Panel();
		//p.setLayout(new GridLayout(1,10));
		p.setLayout(gridbag);

		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;

		Label ll = new Label();
		ll.setText("  ID  ");
		ll.setAlignment(Label.CENTER);
		gc.gridx = 0;
		gc.gridy = 0;
		p.add(ll, gc);

		gc.weightx = 8.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;

		id = new TextField(20);
		gc.gridx = 1;
		gc.gridy = 0;
		p.add(id, gc);

		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		Label sp = new Label();
		sp.setAlignment(Label.CENTER);
		gc.gridx = 4;
		gc.gridy = 0;
		p.add(sp, gc);

		Panel p2 = new Panel();
		p2.setLayout(gridbag2);

		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;

		Label ll2 = new Label();
		ll2.setText("PWD");
		ll2.setAlignment(Label.CENTER);
		gc.gridx = 0;
		gc.gridy = 0;
		p2.add(ll2, gc);

		gc.weightx = 8.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;

		pwd = new TextField(20);
		gc.gridx = 1;
		gc.gridy = 0;
		p2.add(pwd, gc);

		pwd.addKeyListener(new KeyAdapter()
				{
				public void keyPressed(KeyEvent e)
				{
				try
				{
				if(e.getKeyCode() == 10)
				{
				if(SYSTEM.logIn(id.getText(), pwd.getText()))
				{
				LogInFrame.this.setVisible(false);
				command.execute();
				}
				else
				{
				id.setText("");
				pwd.setText("");
				}
				}
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
				}
				});

		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		Label sp2 = new Label();
		sp2.setAlignment(Label.CENTER);
		gc.gridx = 4;
		gc.gridy = 0;
		p2.add(sp2, gc);

		btn_login = new newButton("로그인");
		btn_login.setCommand(command);

		this.add(p);
		this.add(p2);
		this.add(btn_login);
	}
	
	@Override
	public void open() {
		this.setVisible(true);
	}

	@Override
	public void close() {
		this.setVisible(false);
	}

}
