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

public class searchHotelFrame  extends newPanel implements Observer
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
	
	DBManager hotelInfo;
	CurrentUser SYSTEM;

	searchHotelFrame(int width, int height) {
		super(width, height);
		hotelInfo = HotelInfoDBManager.getInstance();	
	}

	public void renewel()
	{
		this.removeAll();
		
		final List list = new List(hotelInfo.getCount());

		hotelNames = hotelInfo.getKeys();

		for(int i=0; i<hotelInfo.getKeys().length; i++)
			list.add((String)hotelInfo.getKeys()[i]);
		list.select(0);
		this.add(list, BorderLayout.WEST);

		final Panel p = new Panel();
		p.setLayout(new GridBagLayout());

		gc.weightx = 4.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;

		hotel_name_label.setAlignment(Label.CENTER);
		hotel_name_label.setFont(new Font("Arial",Font.PLAIN, 20));
		gc.gridx = 0;
		gc.gridwidth=10;
		gc.gridy = 0;
		p.add(hotel_name_label, gc);


		hotel_location_label.setFont(new Font("Arial",Font.PLAIN, 15));
		gc.weightx = 0.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth=1;
		p.add(hotel_location_label, gc);

		hotel_price_label.setFont(new Font("Arial",Font.PLAIN, 15));
		gc.weightx = 0.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 5;
		p.add(hotel_price_label, gc);

		hotel_number_label.setFont(new Font("Arial",Font.PLAIN, 15));
		gc.weightx = 0.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 6;
		p.add(hotel_number_label, gc);

		user_number_label.setFont(new Font("Arial",Font.PLAIN, 15));
		gc.weightx = 0.0;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 8;
		p.add(user_number_label, gc);

		gc.weightx = 0.1;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 1;
		gc.gridy = 8;
		gc.gridwidth = 2;
		p.add(wanna, gc);

		gc.weightx = 0.2;
		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 3;
		gc.gridy = 8;
		gc.gridwidth = 1;
		p.add(new Panel(), gc);

		hotel_list_btn = new Button("장바구니에 담기");
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
				
				BasketInfo in = new BasketInfo(SYSTEM.getId(), (String)hotelNames[list.getSelectedIndex()], "20170512", (String)wanna.getSelectedItem());
				BasketInfoDBManager.getInstance().writeInfo(in);
				}
				});

		gc.weightx = 4.0;
		gc.weighty = 7.0;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 15;
		gc.gridwidth=10;
		p.add(hotel_image_viewer, gc);

		this.add(p, BorderLayout.CENTER);


		searchThread = new Thread()
		{
			int listIdx = -1;

			public void run()
			{
				while(true)
				{
					int hotelIndex = list.getSelectedIndex();
					info = (HotelInfo)hotelInfo.getInfo((String)(hotelNames[hotelIndex]));
					//			System.out.println(hotelIndex);
					if(hotelIndex >= 0)
						hotel_name_label.setText((String)hotelNames[hotelIndex]);
					hotel_price_label.setText("    가격 : " + info.getProperty(3));
					hotel_number_label.setText("    최대인원 : " + info.getProperty(2));
					hotel_location_label.setText("    장소 : " + info.getProperty(1));
					if(hotelIndex != listIdx)
					{
						listIdx = hotelIndex;
						try
						{
							URL url = new URL("http://119.202.36.218/images/applet/" + info.getProperty(4) + ".jpg");
							Image img = ImageAdaptor.getInstance().getImage(url);
							hotel_image_viewer.changeImage(img);

							revalidate();
							validate();
						}catch(Exception e)
						{
							e.printStackTrace();
						}

						wanna.removeAll();
						int num = 0;
						try
						{
							num = Integer.parseInt((String)info.getProperty(2));
						}catch(Exception e)
						{
						}
						for(int i=0; i<num; i++)
							wanna.add(Integer.toString(i+1));

					}
					try
					{
						Thread.sleep(300);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}	
			}
		};

		searchThread.start();

		this.revalidate();
		validate();
	}
	
}

