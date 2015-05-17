package ui;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
		hello.setSize(300, 300);
		JPanel thePanel = (JPanel) hello.getContentPane();
		thePanel.setOpaque(false);
		thePanel.add(new JLabel(new ImageIcon("image/messagepanel.png")));
		thePanel.setVisible(true);
		hello.setUndecorated(true);
		AWTUtilities.setWindowOpaque(hello, false);
		hello.setLocationRelativeTo(null);
		hello.setVisible(true);
		Thread.sleep(1000);
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
	}

}
