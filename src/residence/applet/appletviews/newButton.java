package  residence.applet.appletviews;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class newButton extends Button implements View, Publisher{

	private ArrayList<Observer> observers = new ArrayList<>();
	private Command command;
	
	public newButton(String name)
	{
		super(name);
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				newButton.this.notifyCommand();	
			}});
		
		this.add(new ButtonObserver());
	}
	
	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void delete(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyCommand() 
	{	
		for(Observer observer : observers)
			observer.update(this);
	}

	@Override
	public void setCommand(Command command) {
		this.command = command;
	}

	@Override
	public Command getCommand() {
			return this.command;
	}
	
	
}
