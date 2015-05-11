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
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		if (isdisabled == false) {
			setIcon(normalImage);// 设置默认图片
			setRolloverIcon(mouseOverImage);// 设置鼠标经过图片
			setPressedIcon(mouseDownImage);// 设置鼠标按下图片
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
