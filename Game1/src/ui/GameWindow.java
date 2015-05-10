package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Closeable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	JLayeredPane frontPanel;
	JDialog sciDialog = new JDialog(this);
	private ImageIcon backgroundScn;
	private JPanel imagePanel;
	// private JPanel panel=new JPanel();
	// private ImageIcon backgroundTest;
	private ImageIcon background;
	SciPanel sciPanel;
	private ImageIcon backgroundTitle;
	ImageIcon backgroundMain;
	JPanel mainPanel ;
	JLabel labelTitle;
	// private JPanel gameWindowScnPanel;
	public GameWindow() {

		// 定义窗体打开时的默认获得焦点的组件
		frontPanel = getLayeredPane();
		final ImageButton[] imageButton = new ImageButton[3];
		backgroundScn = new ImageIcon("image/scnpanel.png");
		background = new ImageIcon("image/background.png");// 背景图片
		backgroundTitle = new ImageIcon("image/title.png");

		// backgroundTest=new ImageIcon("image/scnpanel.png");

		final ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		labelTitle = new JLabel(backgroundTitle);
		// JLabel labelTest=new JLabel(backgroundTest);
		// 把标签的大小位置设置为图片刚好填充整个面板

		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		// labelTest.setBounds(0, 0, backgroundTest.getIconWidth(),
		// backgroundTest.getIconHeight());

		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明

		imagePanel = (JPanel) this.getContentPane();
		//imagePanel.setLayout(new CardLayout());
		imagePanel.setOpaque(false);

		imagePanel.setSize(background.getIconWidth(),
				background.getIconHeight());
		imagePanel.setLocation(200, 0);
		labelTitle.setLocation(430, 60);
		labelTitle.setSize(backgroundTitle.getIconWidth(),
				backgroundTitle.getIconHeight());
		imagePanel.add(labelTitle);
		// Font bigFont = new Font("serif", Font.BOLD, 28);
		// button1.setFont(bigFont);
		// button2.setFont(bigFont);
		// button3.setFont(bigFont);

		// this.getLayeredPane().setLayout(null);

		// 把背景图片添加到分层窗格的最底层作为背景

		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(start1, start2, start3, false);
//			imageButton[i].setSize(start1.getIconWidth(),
//					start1.getIconHeight());
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imagePanel.add(imageButton[i]);
		}
		
		
		
		backgroundMain = new ImageIcon("image/planet.png");
		backgroundMain.setImage(backgroundMain.getImage().getScaledInstance(
				600, 600, Image.SCALE_DEFAULT));
		mainPanel = new JPanel();
		JLabel labelBackground = new JLabel(backgroundMain);// 把背景图片显示在一个标签里面
		labelBackground.setBounds(0, 0, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.setOpaque(false);
		mainPanel.setBounds(340, 30, backgroundMain.getIconWidth(), backgroundMain.getIconHeight());
		mainPanel.add(labelBackground);
		
		
		
		
		

		
		
		
		
		
		
		sciPanel = new SciPanel(backgroundScn);
		sciDialog.setBounds(500, 500, backgroundScn.getIconWidth(),
				backgroundScn.getIconHeight());
		sciDialog.setLocationRelativeTo(imagePanel);
		sciDialog.setUndecorated(true);
		sciDialog.add(sciPanel);
		// ((JPanel) sciDialog.getContentPane()).setOpaque(false);
		// sciDialog.getRootPane().setOpaque(false);
		sciDialog.getRootPane().setOpaque(false);
		sciDialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
		sciDialog.setBackground(new Color(0, 0, 0, 0));
		sciDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		imageButton[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				/*
				 * int i=e.getButton(); if(i==MouseEvent.BUTTON1){
				 * backgroundScn=new ImageIcon("image/scnpanel.png");
				 * labelScn=new JLabel(backgroundScn);
				 * labelScn.setSize(backgroundScn
				 * .getIconWidth(),backgroundScn.getIconHeight());
				 * labelScn.setBounds(0,0,background.getIconWidth(),
				 * backgroundScn.getIconHeight()); labelScn.setLocation(100,
				 * 100); labelScn.setOpaque(false); imagePanel.add(labelScn);
				 * repaint();
				 * 
				 * }
				 */
				int i = e.getButton();
				if (i == MouseEvent.BUTTON1) {

					/*
					 * imagePanel.add(sciPanel); setComponentZOrder(sciPanel,0);
					 * imageButton[0].setVisible(false); repaint();
					 */
//					sciDialog.setVisible(true);
//					sciPanel.setVisible(true);
					TopPanel topPanel = new TopPanel();
					labelTitle.setVisible(false);
					frontPanel.add(topPanel,0);
					frontPanel.add(mainPanel,1);
					validate();

					
					
					
						
					
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// labelTest.setLocation(300,100);
		// imagePanel.add(labelTest);

		imagePanel.add(label);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setUndecorated(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
