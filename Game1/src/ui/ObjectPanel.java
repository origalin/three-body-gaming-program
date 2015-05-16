package ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
	JPanel SettingCard;
	JPanel SettingGrid;
	
	JPanel doneSetCard;
	JPanel doneSetGrid;
	
	ImageIcon toBackground=new ImageIcon("image/toSetBackground0");
	ImageIcon start1 = new ImageIcon("image/button1.png");
	ImageIcon start2 = new ImageIcon("image/button2.png");
	ImageIcon start3 = new ImageIcon("image/button3.png");
	ImageIcon icon1 = new ImageIcon("image/iconblue1.png");
	ImageIcon icon2 = new ImageIcon("image/iconblue2.png");
	ImageIcon icon3 = new ImageIcon("image/iconblue3.png");
	ImageButton confirmButton = new ImageButton(start1, start2, start3, false);
	public ObjectPanel(ImageIcon i) {
		super(i);
		setBounds(232, 48, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);
		
		
		confirmButton.setLocation(70, 530);
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
		toSetGrid=new JPanel()
		toSetCard.setLayout(new CardLayout());
		toSetGrid.setLayout(new GridLayout(5,5));
		toSetCard.setBounds(50,20,500,500);
		toSetGrid.setBounds(50, 20, 500, 500);
		toSetCard.setVisible(true);
		toSetGrid.setVisible(true);
		toSetCard.setOpaque(false);
		toSetGrid.setOpaque(false);
		toSetGrid.
		toSetCard.add(toSetGrid);
		add(toSetCard);
		

		
		
		
//		已建造物品框
		
		
//		建造队列物品框
		
		
	}
}
