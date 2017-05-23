import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

import residence.user.*;

public class Main extends Applet implements ActionListener
{
	Panel nPanel, sPanel, cPanel, tcPanel, bcPanel;
	Button  panel_log, panel_signIn;
	Button one, two, three, four, five, six;
	Label bottom, lbl1, lbl2, lbl3;
	Frame f;

	Panel loginBox;
	TextField loginTextBox;

	UserInfoDBManager db;

	public void init()
	{
		db = UserInfoDBManager.getInstance();
		db.readInfo("data");

		f = new Frame();
		f.setSize(getSize().width, getSize().height);
		homeActivity();
		f.setVisible(true);
	}

	public void start()
	{
		panel_log.addActionListener(this);
		panel_log.setActionCommand("login");
		panel_signIn.addActionListener(this);
		panel_signIn.setActionCommand("signin");
	}

	private void homeActivity()
	{
		nPanel = new Panel();              // north panel will hold three button
		//nPanel.setBackground(new Color(255,255,240));  // give it color so you can see it
		nPanel.setBackground(new Color(255,100,100));  //theme1
		nPanel.setSize(getSize().width, getSize().height/10);

		nPanel.setLayout (new FlowLayout(FlowLayout.CENTER));
		Label title = new Label("숙박 예약 서비스");
		nPanel.add(title);
		title.setFont(new Font("Arial",Font.PLAIN, 15));

		sPanel = new Panel();       // south Panel will just hold one Label
		//sPanel.setBackground(new Color(255, 255, 240));  // give it color so you can see it
		sPanel.setBackground(new Color(255, 100, 100));		//theme1
		bottom = new Label("Made by Group-C");
		bottom.setFont(new Font("Arial",Font.PLAIN, 15));

		//set Layout and add Label
		sPanel.setLayout (new FlowLayout(FlowLayout.CENTER));
		sPanel.add (bottom);

		cPanel  = new Panel();     // center panel holds two other panels
		bcPanel = new Panel();     // bottom panel on center panel hold three buttons
		//bcPanel.setBackground(Color.green);  // give it color so you can see it

		panel_log = new Button("로그인");
		panel_signIn = new Button("회원가입");

		//set Layout for bottom center panel and add buttons
		bcPanel.setLayout (new GridLayout(1,3));  // 3 rows, 1 col, 5 pixel gap
		bcPanel.add(panel_log);
		bcPanel.add(panel_signIn);

		//add two center panels (top and bottom) to the center panel
		cPanel.setLayout(new GridLayout(1, 1));  // 2 rows, 1 col, no gaps
		cPanel.setSize(getSize().width, (int)(getSize().height*9.0/10.0));
		cPanel.add(bcPanel);

		//set Layout for the Applet itself and add the panels
		f.setLayout (new BorderLayout());
		f.add(nPanel, BorderLayout.NORTH);
		f.add(sPanel, BorderLayout.SOUTH);
		f.add(cPanel, BorderLayout.CENTER);

		//panel_log.setForeground(new Color(255, 0, 0));
		panel_log.setForeground(new Color(200, 150, 10)); 	//theme1
		//panel_signIn.setForeground(new Color(99, 171, 235));
		panel_signIn.setForeground(new Color(100, 200, 100));//theme1
		panel_log.setFont(new Font("Arial",Font.PLAIN,40));
		panel_signIn.setFont(new Font("Arial",Font.PLAIN,40));

	}


	Frame loginFrame;
	TextField id;
	TextField pwd;
	Button btn_login;
	public void event_login()
	{
		f.setVisible(false);

		GridBagLayout gridbag = new GridBagLayout();
		GridBagLayout gridbag2 = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();


		loginFrame = new Frame();
		loginFrame.setSize(getSize().width/3, 200);
		loginFrame.setLayout(new GridLayout(3, 1));

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
		//p.setLayout(new GridLayout(1,10));
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
				if(db.validateUser(id.getText(), pwd.getText()))
				{
				loginFrame.setVisible(false);
				login_success();
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

		btn_login = new Button("로그인");
		btn_login.addActionListener(this);
		btn_login.setActionCommand("tologin");

		loginFrame.add(p);
		loginFrame.add(p2);
		loginFrame.add(btn_login);
		loginFrame.setVisible(true);	

	}

	Frame login_succ_frame;
	public void login_success()
	{
		login_succ_frame = new Frame();
		login_succ_frame.setSize(getSize());
		login_succ_frame.setLayout(new BorderLayout());

		Label l = new Label("Success");
		l.setFont(new Font("Arial",Font.PLAIN, 50));
		l.setAlignment(Label.CENTER);
		login_succ_frame.add(l, BorderLayout.CENTER);

		login_succ_frame.setVisible(true);
	}

	Frame sign_frame;
	TextField[] sign_text;
	public void sign()
	{
		f.setVisible(false);

		sign_text = new TextField[4];
		Panel[] p = new Panel[4];
		GridBagLayout[] gridbag = new GridBagLayout[4];
		Label[] ll = new Label[4];
		String[] titles = new String[] {"  ID  ", "PWD", "NME", "AGE" };
		GridBagConstraints gc = new GridBagConstraints();


		sign_frame = new Frame();
		sign_frame.setSize(getSize().width/3, 200);
		sign_frame.setLayout(new GridLayout(5, 1));

		for(int i=0; i<4; i++)
		{
			p[i] = new Panel();
			gridbag[i] = new GridBagLayout();
			ll[i] = new Label();

			p[i].setLayout(gridbag[i]);

			gc.weightx = 2.0;
			gc.weighty = 1.0;
			gc.fill = GridBagConstraints.HORIZONTAL;
			Label ss = new Label();
			ss.setAlignment(Label.CENTER);
			gc.gridx = 0;
			gc.gridy = 0;
			p[i].add(ss, gc);

			gc.weightx = 1.0;
			gc.weighty = 1.0;
			gc.fill = GridBagConstraints.HORIZONTAL;

			ll[i].setText(titles[i]);
			ll[i].setAlignment(Label.CENTER);
			gc.gridx = 1;
			gc.gridy = 0;
			p[i].add(ll[i], gc);

			gc.weightx = 4.0;
			gc.weighty = 1.0;
			gc.fill = GridBagConstraints.HORIZONTAL;

			sign_text[i] = new TextField(20);
			gc.gridx = 2;
			gc.gridy = 0;
			p[i].add(sign_text[i], gc);

			gc.weightx = 2.0;
			gc.weighty = 1.0;
			gc.fill = GridBagConstraints.HORIZONTAL;
			Label sp = new Label();
			sp.setAlignment(Label.CENTER);
			gc.gridx = 5;
			gc.gridy = 0;
			p[i].add(sp, gc);

			sign_frame.add(p[i]);
		}

		Button btn_login = new Button("회원가입");
		btn_login.addActionListener(this);
		btn_login.setActionCommand("tosignin");

		sign_frame.add(btn_login);
		sign_frame.setVisible(true);	
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("login"))
		{
			event_login();
		}
		else if(e.getActionCommand().equals("signin"))
		{
			sign();
		}
		else if(e.getActionCommand().equals("tologin"))
		{
			if(db.validateUser(id.getText(), pwd.getText()))
			{
				loginFrame.setVisible(false);
				login_success();
			}
			else
			{
				id.setText("");
				pwd.setText("");
			}
		}
		else if(e.getActionCommand().equals("tosignin"))
		{
			try {
				String serverIP = "119.202.36.218"; // 127.0.0.1 & localhost 본인
				OutputStream os = null;
				OutputStreamWriter osw =null;
				BufferedWriter bw = null;

				// 소켓을 생성하여 연결을 요청한다.
				Socket socket = new Socket(serverIP, 5000);

				os = socket.getOutputStream();
				osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);  

				int age = Integer.parseInt(sign_text[3].getText());
				if(db.contains(sign_text[0].getText()))
					throw new Exception();

				UserInfo info = new UserInfo(sign_text[0].getText(), sign_text[1].getText(), sign_text[2].getText(), age);
			
				bw.write(info.toFormatString());
			//	bw.newLine();
				bw.flush();
			
				sign_frame.setVisible(false);
				f.setVisible(true);
			}	
			catch(Exception ne)
			{
				ne.printStackTrace();
				
				sign_frame.setVisible(false);
				for(TextField tf : sign_text)
					tf.setText("");
				repaint();
				sign_frame.setVisible(true);
			}
		}
	}
}
