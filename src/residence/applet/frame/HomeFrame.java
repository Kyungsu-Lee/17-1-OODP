package  residence.applet.frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import residence.applet.appletviews.newButton;
import residence.applet.commands.ToLogInCommand;
import residence.applet.commands.ToSignInCommand;



public class HomeFrame extends Frame implements FrameInterface{

    Panel nPanel, sPanel, cPanel, tcPanel, bcPanel;
    newButton  panel_log, panel_signIn;
    Label bottom, lbl1, lbl2, lbl3;

    Panel loginBox;
    TextField loginTextBox;

	
	public HomeFrame(int width, int height)
	{
		super();
		
        this.setSize(width, height);
		
        nPanel = new Panel();              // north panel will hold three button
        nPanel.setBackground(new Color(255,255,240));  // give it color so you can see it
        nPanel.setSize(width, height/10);

        nPanel.setLayout (new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("숙박 예약 서비스");
        nPanel.add(title);
        title.setFont(new Font("Arial",Font.PLAIN, 15));

        sPanel = new Panel();       // south Panel will just hold one Label
        sPanel.setBackground(new Color(255, 255, 240));  // give it color so you can see it
        bottom = new Label("Made by Group-C");
        bottom.setFont(new Font("Arial",Font.PLAIN, 15));

        //set Layout and add Label
        sPanel.setLayout (new FlowLayout(FlowLayout.CENTER));
        sPanel.add (bottom);

        cPanel  = new Panel();     // center panel holds two other panels
        bcPanel = new Panel();     // bottom panel on center panel hold three buttons
        //bcPanel.setBackground(Color.green);  // give it color so you can see it

        panel_log = new newButton("로그인");
        panel_log.setCommand(new ToLogInCommand().setParams(this, new LogInFrame(width, height)));
        panel_signIn = new newButton("회원가입");
        panel_signIn.setCommand(new ToSignInCommand().setParams(this, new SignInFrame(width, height)));

        //set Layout for bottom center panel and add buttons
        bcPanel.setLayout (new GridLayout(1,3));  // 3 rows, 1 col, 5 pixel gap
        bcPanel.add(panel_log);
        bcPanel.add(panel_signIn);

        //add two center panels (top and bottom) to the center panel
        cPanel.setLayout(new GridLayout(1, 1));  // 2 rows, 1 col, no gaps
        cPanel.setSize(width, (int)(height*9.0/10.0));
        cPanel.add(bcPanel);

        //set Layout for the Applet itself and add the panels
        this.setLayout (new BorderLayout());
        this.add(nPanel, BorderLayout.NORTH);
        this.add(sPanel, BorderLayout.SOUTH);
        this.add(cPanel, BorderLayout.CENTER);

        panel_log.setForeground(new Color(255, 0, 0));
        panel_signIn.setForeground(new Color(99, 171, 235));
        panel_log.setFont(new Font("Arial",Font.PLAIN,40));
        panel_signIn.setFont(new Font("Arial",Font.PLAIN,40));

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
