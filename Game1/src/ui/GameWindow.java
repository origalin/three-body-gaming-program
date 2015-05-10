package ui;

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
		background = new ImageIcon("image/background.png");// ����ͼƬ
		backgroundTitle = new ImageIcon("image/title.png");
		final ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		ImageIcon roundIcon1 = new ImageIcon("image/roundbutton.png");
		ImageIcon roundIcon2 = new ImageIcon("image/roundbutton2.png");
		ImageIcon roundIcon3 = new ImageIcon("image/roundbutton3.png");
		
		
		
		
		//����ͼ
		JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		
		
		
		//��������
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

		
		
		
		
		// ������ʼ���水ť
		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(start1, start2, start3, false);
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imageButton[i].setHorizontalTextPosition(JButton.CENTER);
			imageButton[i].setVerticalTextPosition(JButton.CENTER);
			imageButton[i].setFont(new Font("΢���ź�", Font.BOLD, 20));
			imagePanel.add(imageButton[i]);
		}
		imageButton[0].setText("��ʼ��Ϸ");

		imageButton[1].setText("������Ա");

		imageButton[2].setText("�˳���Ϸ");


		// ��������ͼƬ
		backgroundMain = new ImageIcon("image/planet.png");
		backgroundMain.setImage(backgroundMain.getImage().getScaledInstance(
				600, 600, Image.SCALE_DEFAULT));
		mainPanel = new JPanel();
		JLabel labelBackground = new JLabel(backgroundMain);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		labelBackground.setBounds(0, 0, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.setOpaque(false);
		mainPanel.setBounds(340, 30, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.add(labelBackground);
		imagePanel.add(mainPanel);

		// �����ײ���ť
		ImageIcon bottomImage = new ImageIcon("image/bottompanel.png");
		bottomLabel = new JLabel(bottomImage);
		bottomLabel.setBounds(240, 560, bottomImage.getIconWidth(),
				bottomImage.getIconHeight());
		for (int i = 0; i <= 2; i++) {
			bottombottons[i] = new ImageButton(start1, start2, start3, false);
			bottombottons[i].setLocation(290 + 250 * i, 620);
			bottombottons[i].setHorizontalTextPosition(JButton.CENTER);
			bottombottons[i].setVerticalTextPosition(JButton.CENTER);
			bottombottons[i].setFont(new Font("΢���ź�", Font.BOLD, 20));
		}
		bottombottons[0].setText("ѧ��");

		bottombottons[1].setText("�Ƽ�");

		bottombottons[2].setText("����");
		
		//�����غϰ�ť
		roundButton = new ImageButton(roundIcon1, roundIcon2, roundIcon3, false);
		roundButton.setLocation(1100, 570);

		// ����ѧ�����
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

		// ��ť����
		imageButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������


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
				// TODO �Զ����ɵķ������
				
			}
		});
		imageButton[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				dispose();
			}
		});
		bottombottons[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
