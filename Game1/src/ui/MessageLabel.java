package ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public  class MessageLabel extends JLabel{
	static int x;
	static int y;
	static ImageIcon messageIcon = new ImageIcon("image/messagepanel.png");
	static JTextField title = new JTextField();
	static JTextArea contains = new JTextArea();
	public MessageLabel() {
		
		super(messageIcon);
		setSize(messageIcon.getIconWidth(), messageIcon.getIconHeight());
		setLocation(x, y);
		
		title.setEditable(false);
		title.setBounds(5,5,240,40);
		title.setOpaque(false);
		title.setBorder(null);
		title.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 19));
		contains.setEditable(false);
		contains.setBounds(5,50,240,100);
		contains.setOpaque(false);
		contains.setBorder(null);
		contains.setLineWrap(true);
		contains.setFont(new Font("ËÎÌå", Font.BOLD, 15));
		add(title);
		add(contains);
		
		
	}
	public static void setTitle(String s) {
		title.setText(s);
	}
	public static void setContains(String s) {
		contains.setText(s);
	}
}
