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
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		isDisabled = isdisabled;
		setIcon(normalImage);// 设置默认图片
		setRolloverIcon(mouseOverImage);// 设置鼠标经过图片
		setPressedIcon(mouseDownImage);// 设置鼠标按下图片

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根

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
