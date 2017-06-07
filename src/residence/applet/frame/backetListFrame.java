package residence.applet.frame;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.net.*;
import java.util.*;

import residence.system.*;
import residence.applet.appletviews.*;
import residence.applet.*;
import residence.applet.frame.*;
import java.awt.event.ActionListener;
import residence.data.*;
import residence.data.user.*;
import residence.data.hotel.*;
import residence.data.basket.*;
import residence.data.list.*;

public class backetListFrame extends newPanel implements residence.applet.appletviews.Observer
{
	public void update(View view)
	{
		renewel();
	}

	Thread searchThread;
	Object[] hotelNames;
	Label hotel_name_label = new Label();
	Button hotel_list_btn;
	Label hotel_price_label = new Label("   가격");
	Label hotel_location_label = new Label("   지역");
	Label hotel_number_label = new Label("  인원");
	Label user_number_label = new Label("  신청인원");
	ImageView hotel_image_viewer = new ImageView();
	Choice wanna = new Choice();
	HotelInfo info;
	GridBagConstraints gc = new GridBagConstraints();
	Object[] keys;
	DBManager hotelInfo;
	CurrentUser SYSTEM;

	backetListFrame(int width, int height) {
		super(width, height);
		hotelInfo = HotelInfoDBManager.getInstance();	
	}

	public void renewel()
	{
		this.removeAll();
		this.setLayout(new BorderLayout());

		final DBManager basketInfo = BasketInfoDBManager.getInstance();
		basketInfo.readInfo();

		final List list = new List(basketInfo.getCount());

		keys = basketInfo.getKeys();
		for(Object key : keys)
			System.out.println(key.toString());

		for(int i=0; i<keys.length; i++)
			if(basketInfo.getInfo((String)keys[i]).getProperty(0).equals(SYSTEM.getId()))
				list.add((String)basketInfo.getInfo((String)keys[i]).getProperty(1));
		list.select(0);
		this.add(list, BorderLayout.WEST);

		Panel p = new Panel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		Button hotel_list_btns = new Button("결제");
		gc.weightx = 5.0;
		gc.weighty = 3.0;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 10;
		gc.gridwidth= 10;
		p.add(hotel_list_btns, gc);

		hotel_list_btn = new Button("장바구니에 삭제");
		gc.weightx = 5.0;
		gc.weighty = 3.0;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 20;
		gc.gridwidth= 10;
		p.add(hotel_list_btn, gc);
		hotel_list_btn.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
				if(list.getSelectedIndex() == -1) return;

				BasketInfo in = new BasketInfo(SYSTEM.getId(), (String)basketInfo.getInfo((String)keys[list.getSelectedIndex()]).getProperty(1), "20170512", "5");
				System.out.println(keys[list.getSelectedIndex()].toString());
				((BasketInfoDBManager)BasketInfoDBManager.getInstance()).delete(in);			
				list.remove((String)basketInfo.getInfo((String)keys[list.getSelectedIndex()]).getProperty(1));
		revalidate();
		validate();
				}
				});
		this.add(p, BorderLayout.CENTER);

		revalidate();
		validate();
	}
	
}

