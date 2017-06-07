package applet.appletviews;


import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import residence.applet.frame.FrameInterface;


public class newFrame extends Frame implements FrameInterface{

	private GridLayout grid = new GridLayout();
	private GridBagConstraints gc = new GridBagConstraints();
	


	public newFrame(int width, int height)
	{
		this.setSize(width, height);
		this.setLayout(grid);
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
