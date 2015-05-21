package ui;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlaneLabel extends JLabel{
	public static int  trance = 0;
 	PlaneLabel(ImageIcon i){
		super(i);
	}
	 public void paint(Graphics g)
	 {
		 Graphics2D g2d=(Graphics2D)g;
		 AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)((float)trance/(float)100));
	       g2d.setComposite(alphaComposite);
	       super.paint(g2d);
	 }
}
