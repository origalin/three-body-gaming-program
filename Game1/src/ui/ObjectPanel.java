package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ObjectPanel extends JLabel{
	JPanel toSetCard;
	JPanel toSetGrid;
	ImageIcon toSetBackground;
	JPanel settingCard;
	JPanel settingGrid;
	ImageIcon settingBackground;
	JPanel doneSetCard;
	JPanel doneSetGrid;
	ImageIcon doneSetBackground;

	
	private JLabel toSetLabel;
	
	
	public ObjectPanel(ImageIcon i) {
		super(i);
		toSetBackground=new ImageIcon("image/anothericon1.png");
		settingBackground=new ImageIcon("image/anothericon2.png");
		doneSetBackground=new ImageIcon("image/anothericon3.png");
		ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		ImageIcon icon1 = new ImageIcon("image/iconblue1.png");
		ImageIcon icon2 = new ImageIcon("image/iconblue2.png");
		ImageIcon icon3 = new ImageIcon("image/iconblue3.png");
		ImageButton confirmButton = new ImageButton(start1, start2, start3, false);
		
		setBounds(240, 28, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);
		
		
		confirmButton.setLocation(70, 540);
		confirmButton.setText("确认");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setVisible(false);
			}
		});
		add(confirmButton);
		
//		JScrollPane tecScrollPane =new JScrollPane();
//		tecScrollPane.setBounds(50, 20, 500, 500);
//		add(tecScrollPane);
		
		
//		可建造物品框
		toSetBackground.
		setImage(
				toSetBackground.getImage().
				getScaledInstance(
				570, 260, Image.SCALE_DEFAULT));
		toSetLabel=new JLabel(toSetBackground);
		toSetLabel.setBounds(0, 0, 
				toSetBackground.getIconWidth(), 
				toSetBackground.getIconHeight());
		toSetCard=new JPanel(new CardLayout());
		toSetGrid=new JPanel(new GridLayout(5,5));
		JPanel toSetNull=new JPanel();
		toSetCard.setBounds(65,40,570,260);
		toSetGrid.setBounds(0,0, 570, 260);
		toSetNull.setBounds(0, 0, 570, 260);
		toSetCard.setVisible(true);
		toSetGrid.setVisible(true);
		toSetCard.setOpaque(true);
		toSetGrid.setOpaque(false);
		toSetNull.setOpaque(false);
		toSetNull.add(toSetLabel);
		toSetLabel.add(toSetGrid);
		toSetCard.add(toSetNull);
		add(toSetCard);
		

		
		
		
		
		
		
		
		
//		已建造物品框
		settingBackground.
		setImage(
				settingBackground.getImage().
				getScaledInstance(
				570, 200, Image.SCALE_DEFAULT));
		toSetLabel=new JLabel(settingBackground);
		toSetLabel.setBounds(0, 0, 
				settingBackground.getIconWidth(), 
				settingBackground.getIconHeight());
		settingCard=new JPanel(new CardLayout());
		settingGrid=new JPanel(new GridLayout(5,5));
		JPanel settingNull=new JPanel();
		settingCard.setBounds(65,330,570,200);
		settingGrid.setBounds(0,0,570, 200);
		settingNull.setBounds(0, 0, 570, 200);
		settingCard.setVisible(true);
		settingGrid.setVisible(true);
		settingCard.setOpaque(true);
		settingGrid.setOpaque(false);
		settingNull.setOpaque(false);
		settingNull.add(toSetLabel);
		toSetLabel.add(settingGrid);
		settingCard.add(settingNull);
		add(settingCard);
		
		
//		建造队列物品框
		doneSetBackground.
		setImage(
				doneSetBackground.getImage().
				getScaledInstance(
				60, 520, Image.SCALE_DEFAULT));
		toSetLabel=new JLabel(doneSetBackground);
		toSetLabel.setBounds(0, 0, 
				doneSetBackground.getIconWidth(), 
				doneSetBackground.getIconHeight());
		doneSetCard=new JPanel(new CardLayout());
		doneSetGrid=new JPanel(new GridLayout(5,5));
		JPanel doneSetNull=new JPanel();
		doneSetCard.setBounds(690,40,60,520);
		doneSetGrid.setBounds(0,0, 60, 520);
		doneSetNull.setBounds(0, 0, 60, 520);
		doneSetCard.setVisible(true);
		doneSetGrid.setVisible(true);
		doneSetCard.setOpaque(true);
		doneSetGrid.setOpaque(false);
		doneSetNull.setOpaque(false);
		doneSetNull.add(toSetLabel);
		toSetLabel.add(doneSetGrid);
		doneSetCard.add(doneSetNull);
		add(doneSetCard);
		
	}
	public void addtoSet(JLabel label){
		
	}
	public void delete(JLabel label){
		
	}
	
}
