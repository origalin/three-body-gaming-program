package ui;

import el.*;
import el.Math;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JPanel mainPanel;
	JLabel labelTitle;
	JLabel bottomLabel;
	ImageButton[] bottombottons = new ImageButton[3];
	ImageButton roundButton;

	public GameWindow() {

		frontPanel = getLayeredPane();
		final ImageButton[] imageButton = new ImageButton[3];
		backgroundScn = new ImageIcon("image/scnpanel.png");
		background = new ImageIcon("image/background.png");// 背景图片
		backgroundTitle = new ImageIcon("image/title.png");
		final ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		ImageIcon roundIcon1 = new ImageIcon("image/roundbutton.png");
		ImageIcon roundIcon2 = new ImageIcon("image/roundbutton2.png");
		ImageIcon roundIcon3 = new ImageIcon("image/roundbutton3.png");
		
		
		
		
		//背景图
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		
		
		
		//标题文字
		labelTitle = new JLabel(backgroundTitle);
		labelTitle.setLocation(430, 60);
		labelTitle.setSize(backgroundTitle.getIconWidth(),
				backgroundTitle.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setSize(background.getIconWidth(),
				background.getIconHeight());
		imagePanel.setLocation(200, 0);
		imagePanel.add(labelTitle);

		
		
		
		
		// 创建开始界面按钮
		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(start1, start2, start3, false);
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imageButton[i].setHorizontalTextPosition(JButton.CENTER);
			imageButton[i].setVerticalTextPosition(JButton.CENTER);
			imageButton[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
			imagePanel.add(imageButton[i]);
		}
		imageButton[0].setText("开始游戏");

		imageButton[1].setText("制作人员");

		imageButton[2].setText("退出游戏");


		// 创建星球图片
		backgroundMain = new ImageIcon("image/planet.png");
		backgroundMain.setImage(backgroundMain.getImage().getScaledInstance(
				600, 600, Image.SCALE_DEFAULT));
		mainPanel = new JPanel();
		JLabel labelBackground = new JLabel(backgroundMain);// 把背景图片显示在一个标签里面
		labelBackground.setBounds(0, 0, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.setOpaque(false);
		mainPanel.setBounds(340, 30, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.add(labelBackground);
		imagePanel.add(mainPanel);

		// 创建底部按钮
		ImageIcon bottomImage = new ImageIcon("image/bottompanel.png");
		bottomLabel = new JLabel(bottomImage);
		bottomLabel.setBounds(240, 560, bottomImage.getIconWidth(),
				bottomImage.getIconHeight());
		for (int i = 0; i <= 2; i++) {
			bottombottons[i] = new ImageButton(start1, start2, start3, false);
			bottombottons[i].setLocation(290 + 250 * i, 620);
			bottombottons[i].setHorizontalTextPosition(JButton.CENTER);
			bottombottons[i].setVerticalTextPosition(JButton.CENTER);
			bottombottons[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
		}
		bottombottons[0].setText("学科");

		bottombottons[1].setText("科技");

		bottombottons[2].setText("建造");
		
		//创建回合按钮
		roundButton = new ImageButton(roundIcon1, roundIcon2, roundIcon3, false);
		roundButton.setLocation(1100, 570);

		// 创建学科面板
		sciPanel = new SciPanel(backgroundScn);
		sciDialog.setBounds(500, 500, backgroundScn.getIconWidth(),
				backgroundScn.getIconHeight());
		sciDialog.setLocationRelativeTo(imagePanel);
		sciDialog.setUndecorated(true);
		sciDialog.add(sciPanel);
		sciDialog.getRootPane().setOpaque(false);
		sciDialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
		sciDialog.setBackground(new Color(0, 0, 0, 0));
		sciDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		// 按钮功能
		imageButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				

				TopPanel topPanel = new TopPanel();
				labelTitle.setVisible(false);
				frontPanel.add(topPanel, 1);
				frontPanel.add(bottomLabel, 1);
				for (ImageButton im : bottombottons) {
					frontPanel.add(im, 0);
				}
				for(ImageButton ib : imageButton) {
					ib.setVisible(false);
				}
				frontPanel.add(roundButton);
				validate();

			}
		});
		imageButton[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		imageButton[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		bottombottons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int GP = 0;
				GP = (int) ((int) 50*((Begin.EV-500)/100+1));
				Begin.HP = (int) (Begin.HP + GP);
				int i[] = {Chemistry.point,Biology.point,Physics.point,Math.point,Computer.point,Art.point};
				sciPanel.setpoints(i);
				sciPanel.setpointsavailable(Begin.HP);
				sciPanel.pointsavailable.setText("可分配学科点：" + sciPanel.availablepoints);
				 sciDialog.setVisible(true);
				 sciPanel.setVisible(true);
			}
		});
		
		

		imagePanel.add(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setUndecorated(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
