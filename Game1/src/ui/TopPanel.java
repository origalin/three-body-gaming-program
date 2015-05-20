package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import el.Begin;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
	ImageIcon topPanelIcon = new ImageIcon("image/toppanel.png");
	JLabel topLabel;

	TopPanel() {
		super();
		setOpaque(false);
		setBounds(275, -5, topPanelIcon.getIconWidth(),
				topPanelIcon.getIconHeight());
		topLabel = new JLabel(topPanelIcon);
		topLabel.setBounds(0, 0, topPanelIcon.getIconWidth(),
				topPanelIcon.getIconHeight());
		topLabel.setOpaque(false);
		add(topLabel);

		topLabel.setText("�򾭼�ֵ"+Begin.EV+"  "+"���Ҹ�ֵ"+Begin.HV+"  "+"�򻷾�ֵ"+Begin.EMV);
		
		topLabel.setFont(new Font("΢���ź� ", Font.BOLD, 28));
		topLabel.setForeground(new Color(42,96,128));
		topLabel.setHorizontalTextPosition(JLabel.CENTER);

	}
}
