package ui;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
class ImageButton extends JButton {
	ImageIcon disable;
	boolean ispressed = false;
	public ImageButton(ImageIcon normalImage, ImageIcon mouseOverImage,
			ImageIcon mouseDownImage, boolean isdisabled) {
		super();
		setUI(new MyButtonUI());
		disable = mouseOverImage;
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
