package ui;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import com.sun.awt.AWTUtilities;

public class Game {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame hello = new JFrame();
		hello.setSize(500, 500);
		JPanel thePanel = (JPanel) hello.getContentPane();
		thePanel.setOpaque(false);
		thePanel.add(new JLabel(new ImageIcon("image/beforepanel1.png")));
		thePanel.setVisible(true);
		hello.setUndecorated(true);
		AWTUtilities.setWindowOpaque(hello, false);
		hello.setLocationRelativeTo(null);
		hello.setVisible(true);
		for (int i = 0; i <= 10; i++) {
			Thread.sleep(10);
			AWTUtilities.setWindowOpacity(hello, (float) (0.1 * i));
		}
		Thread.sleep(2000);
		for (int i = 10; i >= 0; i--) {
			Thread.sleep(10);
			AWTUtilities.setWindowOpacity(hello, (float) (0.1 * i));
		}
		hello.dispose();

		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GameWindow tbc = new GameWindow(gd.getDefaultConfiguration());

		DisplayMode mode = new DisplayMode(1280, 720, 32, 60);
		if (gd.isFullScreenSupported()) {
			try {
				gd.setFullScreenWindow(tbc);
				gd.setDisplayMode(mode);
			} catch (IllegalArgumentException ex) {
			}

		} else {
			System.out.println("Unsupportedfullscreen.");
		}

		tbc.setVisible(true);
		try {
			FileInputStream fileau = new FileInputStream("sound/background.wav");
			AudioStream as = new AudioStream(fileau);
			AudioPlayer.player.start(as);

		} catch (Exception e) {
		}
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		//然后得到当前键盘事件的管理器
		manager.addKeyEventPostProcessor((KeyEventPostProcessor)tbc.getMyKeyEventHandler());
		//然后为管理器添加一个新的键盘事件监听者。
		}
}
