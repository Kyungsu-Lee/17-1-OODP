import java.awt.*;

public class ImageView extends Panel
{
	private Image bgImage;

	@Override
	public void paint(Graphics g)
	{
		 g.drawImage(bgImage, 0, 0,
              (int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
	}

	public void changeImage(Image image)
	{
		this.bgImage = image;
		repaint();
	}
}
