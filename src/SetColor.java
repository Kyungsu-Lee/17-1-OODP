

import java.awt.*;
import java.applet.Applet;

public class SetColor extends Applet {
	//Panel nPanel;
	/*public void init1(){
		//this.setPanelColor(nPanel);
		System.out.printf("hello");
	}*/
	
	public void setPanelColor(Panel nPanel){
		nPanel.setBackground(new Color(255,100,100)); 	//봄
	}
	
	public void setPanelColor1(Panel nPanel){
		nPanel.setBackground(new Color(0,255,0)); 	//여름 - 초록
	}
	
	public void setPanelColor2(Panel nPanel){
		nPanel.setBackground(new Color(255,128,64)); 	//가을 - 주황
	}
	
	public void setPanelColor3(Panel nPanel){
		nPanel.setBackground(new Color(255,255,255)); 	//겨울 - 완전 흰색
	}
	
	public void setColorButton(Button b){
		b.setForeground(new Color(200,250,10));
	}

}
