package ui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImageButton extends JButton {
	public ImageButton(ImageIcon normalImage, ImageIcon mouseOverImage,
			ImageIcon mouseDownImage, boolean isdisabled) {
		super();
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setSize(normalImage.getIconWidth(), normalImage.getIconHeight());
		setMargin(new Insets(0, 0, 0, 0));// ���ñ߾�
		setContentAreaFilled(false);// �����ư�ť����
		setBorderPainted(false);// �����Ʊ߿�
		if (isdisabled == false) {
			setIcon(normalImage);// ����Ĭ��ͼƬ
			setRolloverIcon(mouseOverImage);// ������꾭��ͼƬ
			setPressedIcon(mouseDownImage);// ������갴��ͼƬ
		} else {
			setIcon(normalImage);
			setRolloverIcon(normalImage);
			setPressedIcon(normalImage);
			setEnabled(false);
		}
	}
	public void setavalible(boolean b) {
		if(b==true) {
			setEnabled(true);
		}
		else {
			setEnabled(false);
		}
	}
}
