

import java.awt.*;
import java.applet.Applet;

public class SetColor extends Applet {
	//Panel nPanel;
	/*public void init1(){
		//this.setPanelColor(nPanel);
		System.out.printf("hello");
	}*/
	
	public void setPanelColor(Panel nPanel){
		nPanel.setBackground(new Color(255,100,100)); 
	}
	
	public void setColorButton(Button b){
		b.setForeground(new Color(200,250,10));
	}

}
