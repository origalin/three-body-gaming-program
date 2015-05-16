package ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public  class MessageLabel extends JLabel{
	static int x;
	static int y;
	static ImageIcon messageIcon = new ImageIcon("image/messagepanel.png");
	public MessageLabel() {
		super(messageIcon);
		setSize(messageIcon.getIconWidth(), messageIcon.getIconHeight());
		setLocation(x, y);
	}
}
