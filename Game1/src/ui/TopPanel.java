package ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopPanel extends JPanel{
	ImageIcon topPanelIcon=new ImageIcon("image/toppanel.png");
	JLabel topLabel;
	 TopPanel(){
		super();
		setOpaque(false);
		setBounds(250, -5, topPanelIcon.getIconWidth(), topPanelIcon.getIconHeight());
		topLabel=new JLabel(topPanelIcon);
		topLabel.setBounds(0, 0, topPanelIcon.getIconWidth(),
				topPanelIcon.getIconHeight());
		topLabel.setOpaque(false);
		add(topLabel);
		
//		   topLabel as a new text player
		topLabel.setText("Radom News.");
		topLabel.setHorizontalTextPosition(JLabel.CENTER);
		topLabel.setVerticalTextPosition(JLabel.CENTER);
		topLabel.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,20));
		
	}
}
