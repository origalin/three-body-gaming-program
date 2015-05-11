package ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
	ImageIcon topPanelIcon = new ImageIcon("image/toppanel.png");
	JLabel topLabel;

	TopPanel() {
		super();
		setOpaque(false);
		setBounds(250, -5, topPanelIcon.getIconWidth(),
				topPanelIcon.getIconHeight());
		topLabel = new JLabel(topPanelIcon);
		topLabel.setBounds(0, 0, topPanelIcon.getIconWidth(),
				topPanelIcon.getIconHeight());
		topLabel.setOpaque(false);
		add(topLabel);

		topLabel.setText("–««Ú Ù–‘£∫");
		topLabel.setFont(new Font("Œ¢»Ì—≈∫⁄ ", Font.BOLD, 28));
		topLabel.setHorizontalTextPosition(JLabel.CENTER);

	}
}
