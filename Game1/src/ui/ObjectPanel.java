package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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

public class ObjectPanel extends JLabel {
	JPanel toSetCard;
	JPanel toSetGrid;

	JPanel settingCard;
	JPanel settingGrid;

	JPanel doneSetCard;
	JPanel doneSetGrid;
	ImageIcon settingBackground;
	ImageIcon doneSetBackground;
	ImageIcon toSetBackground;
	
 	private JLabel toSetLabel;
 	private JLabel settingLabel;
 	private JLabel doneSetLabel;
 	private ImageIcon icon1;
 	private ImageIcon icon2;
 	private ImageIcon icon3;
 	
	public ObjectPanel(ImageIcon i) {
		super(i);
		toSetBackground = new ImageIcon("image/anothericon1.png");
		settingBackground = new ImageIcon("image/anothericon2.png");
		doneSetBackground = new ImageIcon("image/anotherdone3.png");
		ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		icon1 = new ImageIcon("image/roundbutton.png");
		icon2 = new ImageIcon("image/roundbutton2.png");
		icon3 = new ImageIcon("image/roundbutton3.png");
		icon1.setImage(icon1.getImage().getScaledInstance(50, 50, 
				Image.SCALE_DEFAULT));
		icon2.setImage(icon2.getImage().getScaledInstance(50, 50, 
				Image.SCALE_DEFAULT));
		icon3.setImage(icon3.getImage().getScaledInstance(50, 50, 
				Image.SCALE_DEFAULT));
		ObjectImageButton confirmButton = new ObjectImageButton(start1, start2, start3,
				false);

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
//				  TODO 自动生成的方法存根
				setVisible(false);
			}
		});
		add(confirmButton);

//		  可建造物品框
 		toSetBackground.setImage(toSetBackground.getImage().getScaledInstance(
 				570, 260, Image.SCALE_DEFAULT));
 		toSetLabel = new JLabel(toSetBackground);
 		toSetLabel.setBounds(0, 0, toSetBackground.getIconWidth(),
 				toSetBackground.getIconHeight());
		toSetCard = new JPanel(new CardLayout());
		FlowLayout flowLayout=new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toSetGrid = new JPanel(flowLayout);
 		JPanel toSetNull = new JPanel();
		toSetCard.setBounds(65, 40, 570, 260);
		toSetGrid.setBounds(0, 0, 570, 260);
 		toSetGrid.setBackground(new Color(85, 125,205));
 		toSetNull.setBounds(0, 0, 570, 260);
	

		toSetGrid.setVisible(true);
		toSetCard.setOpaque(true);
		toSetGrid.setOpaque(true);

		
 		toSetNull.setOpaque(false);
 		toSetNull.add(toSetLabel);
 		toSetNull.add(toSetGrid);
 		toSetLabel.add(toSetGrid);
 		toSetCard.add(toSetNull);
		add(toSetCard);
		
//		  已建造物品框
 		settingBackground.setImage(settingBackground.getImage()
 				.getScaledInstance(570, 200, Image.SCALE_DEFAULT));
 		settingLabel = new JLabel(settingBackground);
 		settingLabel.setBounds(0, 0, settingBackground.getIconWidth(),
 				settingBackground.getIconHeight());
		settingCard = new JPanel(flowLayout);
		settingGrid = new JPanel(new GridLayout(4, 5,570,200));
 		JPanel settingNull = new JPanel();
		settingCard.setBounds(65, 330, 570, 200);
		settingGrid.setBounds(0, 0, 570, 200);

 		settingNull.setBounds(0, 0, 570, 200);
		settingCard.setVisible(true);
		settingGrid.setVisible(true);
		settingCard.setOpaque(false);
		settingGrid.setOpaque(true);
 		settingNull.setOpaque(false);
 		settingNull.add(settingLabel);
 		settingLabel.add(settingGrid);
 		settingCard.add(settingNull);
		add(settingCard);

//		  建造队列物品框
 		doneSetBackground.setImage(doneSetBackground.getImage()
 				.getScaledInstance(60, 520, Image.SCALE_DEFAULT));
 		doneSetLabel = new JLabel(doneSetBackground);
 		doneSetLabel.setBounds(0, 0, doneSetBackground.getIconWidth(),
 				doneSetBackground.getIconHeight());
		doneSetCard = new JPanel(new CardLayout());
		doneSetGrid = new JPanel(new GridLayout(5, 1,60,520));
 		JPanel doneSetNull = new JPanel(flowLayout);
		doneSetCard.setBounds(690, 40, 60, 520);
		doneSetGrid.setBounds(0, 0, 60, 520);
		doneSetGrid.setBackground(new Color(85, 125,205));
 		doneSetNull.setBounds(0, 0, 60, 520);
		doneSetCard.setVisible(true);
		doneSetGrid.setVisible(true);
		doneSetCard.setOpaque(true);
		doneSetGrid.setOpaque(true);
 		doneSetNull.setOpaque(false);
 		doneSetNull.add(doneSetLabel);
 		doneSetLabel.add(doneSetGrid);
 		doneSetCard.add(doneSetNull);
		add(doneSetCard);
		
		
//		创建所有按钮
		ObjectImageButton[] button=new ObjectImageButton[10];
		for(int j=0;j<0;j++){
			button[j]=new ObjectImageButton(icon1, icon2, icon3, false);
		}
	}

	public void addToSet(ObjectImageButton object) {
		if(object.location==-1||object.location==1){
			toSetCard.add(object);
			object.location=0;
		}
	}

	public void deleteToSet(ObjectImageButton object) {
		if(object.location==0){
			toSetGrid.remove(object);
			object.location=1;
			this.addSetting(object);
		}
	}

	public void addSetting(ObjectImageButton object) {
		if(object.location==0){
			settingGrid.add(object);
			object.location=1;
		}
	}

	public void deleteSetting(ObjectImageButton object) {
		if(object.location==1){
			settingGrid.remove(object);
			object.location=0;
			this.addToSet(object);
		}
	}

	public void addDoneSet(ObjectImageButton object) {
		if(object.location==1){
			doneSetGrid.add(object);
			object.location=2;
		}
		
		
		
	}

	

}
