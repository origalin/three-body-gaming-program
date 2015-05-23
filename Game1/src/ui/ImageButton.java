package ui;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class ImageButton extends JButton {
	ImageIcon normal;
	boolean ispressed = false;
	boolean isDisabled;
	ImageIcon spimage;

	public ImageButton(ImageIcon normalImage, ImageIcon mouseOverImage,
			ImageIcon mouseDownImage, boolean isdisabled) {
		super();
		setUI(new MyButtonUI());
		normal = normalImage;
		this.setSize(normalImage.getIconWidth(), normalImage.getIconHeight());
		setMargin(new Insets(0, 0, 0, 0));// ���ñ߾�
		setContentAreaFilled(false);// �����ư�ť����
		setBorderPainted(false);// �����Ʊ߿�
		isDisabled = isdisabled;
		setIcon(normalImage);// ����Ĭ��ͼƬ
		setRolloverIcon(mouseOverImage);// ������꾭��ͼƬ
		setPressedIcon(mouseDownImage);// ������갴��ͼƬ

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				if (isDisabled == false) {
					try {
						FileInputStream fileau = new FileInputStream(
								"sound/mousedown.wav");
						AudioStream as = new AudioStream(fileau);
						AudioPlayer.player.start(as);
					} catch (Exception e1) {
					}
					
				}
				else {
					try {
						FileInputStream fileau = new FileInputStream(
								"sound/error.wav");
						AudioStream as = new AudioStream(fileau);
						AudioPlayer.player.start(as);
					} catch (Exception e1) {
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				if (isDisabled == false) {
					try {
						FileInputStream fileau = new FileInputStream(
								"sound/mouseover.wav");
						AudioStream as = new AudioStream(fileau);
						AudioPlayer.player.start(as);
					} catch (Exception e1) {
					}
				}
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������

			}
		});
	}
	public void setspimage(ImageIcon i ) {
		spimage = i;
	}
	public void setavalible(boolean b) {
		if (b == true) {
			isDisabled = false;
			setEnabled(true);
		} else {
			isDisabled = true;
			setEnabled(false);
			if(ispressed) {
				setIcon(spimage);
			}
			
		}
	}
}
