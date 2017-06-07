package  residence.applet.frame;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class SignInFrame extends Frame implements FrameInterface {

	TextField[] sign_text;

	public SignInFrame(int width, int height)
	{
		sign_text = new TextField[4];
		Panel[] p = new Panel[4];
		GridBagLayout[] gridbag = new GridBagLayout[4];
		Label[] ll = new Label[4];
		String[] titles = new String[] {"  ID  ", "PWD", "NME", "AGE" };
		GridBagConstraints gc = new GridBagConstraints();

		this.setSize(width, 200);
		this.setLayout(new GridLayout(5, 1));

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

			this.add(p[i]);
		}

		Button btn_login = new Button("회원가입");

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
