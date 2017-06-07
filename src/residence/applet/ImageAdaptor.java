package residence.applet;
import java.awt.Image;
import java.net.*;
import java.applet.Applet;

public class ImageAdaptor extends Applet
{
	private static ImageAdaptor instance;

	private ImageAdaptor()
	{
	}

	public static ImageAdaptor getInstance()
	{
		if(instance == null)
			instance = new ImageAdaptor();

		return instance;
	}

	public Image getImages(URL image)
	{
		return super.getImage(image);
	}
	
}
